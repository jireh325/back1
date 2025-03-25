package divdev.sn.todo_list.infrastructure.adapter.out.mongo.userAssignation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.UserAssignationRepository;
import divdev.sn.todo_list.domain.model.UserAssignation;
import divdev.sn.todo_list.infrastructure.mapper.UserAssignationMapper;

@Repository("UserAssignationMongoAdapter")
public class UserAssignationMongoAdapter implements UserAssignationRepository {

    private final UserAssignationMongoRepository userAssignationMongoRepository;
    private final UserAssignationMapper userAssignationMapper;

    public UserAssignationMongoAdapter(UserAssignationMongoRepository userAssignationMongoRepository, UserAssignationMapper userAssignationMapper) {
        this.userAssignationMongoRepository = userAssignationMongoRepository;
        this.userAssignationMapper = userAssignationMapper;
    }

    @Override
    public UserAssignation save(UserAssignation userAssignation) {
        UserAssignationEntityMongo entity = this.userAssignationMapper.toUserAssignationEntityMongo(userAssignation);
        return this.userAssignationMapper.fromMongotoModel(this.userAssignationMongoRepository.save(entity));
    }

    @Override
    public List<UserAssignation> findAll() {
        return this.userAssignationMongoRepository.findAll().stream()
            .map(this.userAssignationMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserAssignation> findById(String id) {
        return this.userAssignationMongoRepository.findById(id).map(this.userAssignationMapper::fromMongotoModel);
    }

    @Override
    public List<UserAssignation> findByIdTodo(String idTodo) {
        return this.userAssignationMongoRepository.findByIdTodo(idTodo).stream()
            .map(this.userAssignationMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public UserAssignation update(String id, UserAssignation userAssignation){
        UserAssignationEntityMongo existingUserAssignation = this.userAssignationMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));

        existingUserAssignation.setIdTodo(userAssignation.getIdTodo());
        existingUserAssignation.setIdUser(userAssignation.getIdUser());

        return this.userAssignationMapper.fromMongotoModel(this.userAssignationMongoRepository.save(existingUserAssignation));
    }


    @Override
    public List<UserAssignation> findByIdUser(String idUser) {
        return this.userAssignationMongoRepository.findByIdUser(idUser).stream()
            .map(this.userAssignationMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserAssignation> findByIdTodoAndIdUser(String idTodo, String idUser) {
        return this.userAssignationMongoRepository.findByIdTodoAndIdUser(idTodo, idUser)
            .map(this.userAssignationMapper::fromMongotoModel);
    }

    @Override
    public void delete(String id) {
        this.userAssignationMongoRepository.deleteById(id);
    }
}
