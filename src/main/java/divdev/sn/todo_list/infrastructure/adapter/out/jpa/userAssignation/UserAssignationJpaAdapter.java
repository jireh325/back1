package divdev.sn.todo_list.infrastructure.adapter.out.jpa.userAssignation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.UserAssignationRepository;
import divdev.sn.todo_list.domain.model.UserAssignation;
import divdev.sn.todo_list.infrastructure.mapper.UserAssignationMapper;

@Primary
@Repository("UserAssignationJpaAdapter")
public class UserAssignationJpaAdapter implements UserAssignationRepository {

    private final UserAssignationJpaRepository userAssignationJpaRepository;
    private final UserAssignationMapper userAssignationMapper;

    public UserAssignationJpaAdapter(UserAssignationJpaRepository userAssignationJpaRepository, UserAssignationMapper userAssignationMapper) {
        this.userAssignationJpaRepository = userAssignationJpaRepository;
        this.userAssignationMapper = userAssignationMapper;
    }

    @Override
    public UserAssignation save(UserAssignation userAssignation) {
        UserAssignationEntityJpa entity = this.userAssignationMapper.toUserAssignationEntityJpa(userAssignation);
        return this.userAssignationMapper.fromJpatoModel(this.userAssignationJpaRepository.save(entity));
    }

    @Override
    public List<UserAssignation> findAll() {
        return this.userAssignationJpaRepository.findAll().stream()
            .map(this.userAssignationMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserAssignation> findById(String id) {
        return this.userAssignationJpaRepository.findById(Long.valueOf(id)).map(this.userAssignationMapper::fromJpatoModel);
    }

    @Override
    public List<UserAssignation> findByIdTodo(String idTodo) {
        return this.userAssignationJpaRepository.findByIdTodo(Long.valueOf(idTodo)).stream()
            .map(this.userAssignationMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public UserAssignation update(String id, UserAssignation userAssignation){
        UserAssignationEntityJpa existingUserAssignation = this.userAssignationJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));

        existingUserAssignation.setIdTodo(Long.valueOf(userAssignation.getIdTodo()));
        existingUserAssignation.setIdUser(Long.valueOf(userAssignation.getIdUser()));

        return this.userAssignationMapper.fromJpatoModel(this.userAssignationJpaRepository.save(existingUserAssignation));
    }


    @Override
    public List<UserAssignation> findByIdUser(String idUser) {
        return this.userAssignationJpaRepository.findByIdUser(Long.valueOf(idUser)).stream()
            .map(this.userAssignationMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserAssignation> findByIdTodoAndIdUser(String idTodo, String idUser) {
        return this.userAssignationJpaRepository.findByIdTodoAndIdUser(Long.valueOf(idTodo), Long.valueOf(idUser))
            .map(this.userAssignationMapper::fromJpatoModel);
    }

    @Override
    public void delete(String id) {
        this.userAssignationJpaRepository.deleteById(Long.valueOf(id));
    }
}
