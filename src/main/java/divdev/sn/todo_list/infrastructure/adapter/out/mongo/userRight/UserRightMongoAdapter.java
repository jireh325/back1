package divdev.sn.todo_list.infrastructure.adapter.out.mongo.userRight;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.UserRightRepository;
import divdev.sn.todo_list.domain.model.UserRight;
import divdev.sn.todo_list.infrastructure.mapper.UserRightMapper;

@Repository("UserRightMongoAdapter")
public class UserRightMongoAdapter implements UserRightRepository {

    private final UserRightMongoRepository userRightMongoRepository;
    private final UserRightMapper userRightMapper;

    public UserRightMongoAdapter(UserRightMongoRepository userRightMongoRepository, UserRightMapper userRightMapper) {
        this.userRightMongoRepository = userRightMongoRepository;
        this.userRightMapper = userRightMapper;
    }

    @Override
    public UserRight save(UserRight userRight) {
        UserRightEntityMongo entity = this.userRightMapper.toUserRightEntityMongo(userRight);
        return this.userRightMapper.fromMongoToModel(this.userRightMongoRepository.save(entity));
    }

    @Override
    public List<UserRight> findAll() {
        return this.userRightMongoRepository.findAll().stream()
            .map(this.userRightMapper::fromMongoToModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRight> findById(String id) {
        return this.userRightMongoRepository.findById(id).map(this.userRightMapper::fromMongoToModel);
    }

    @Override
    public List<UserRight> findByIdUser(String idUser) {
        return this.userRightMongoRepository.findByIdUser(idUser).stream()
            .map(this.userRightMapper::fromMongoToModel)
            .collect(Collectors.toList());
    }

    @Override
    public List<UserRight> findByIdProject(String idProject) {
        return this.userRightMongoRepository.findByIdProject(idProject).stream()
            .map(this.userRightMapper::fromMongoToModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRight> findByIdUserAndIdProject(String idUser, String idProject) {
        return this.userRightMongoRepository.findByIdUserAndIdProject(idUser, idProject)
            .map(this.userRightMapper::fromMongoToModel);
    }

    @Override
    public UserRight update(String id, UserRight userRight) {
        UserRightEntityMongo existingUserRight = this.userRightMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));

        existingUserRight.setIdUser(userRight.getIdUser());
        existingUserRight.setIdProject(userRight.getIdProject());
        existingUserRight.setAdmin(userRight.isAdmin());

        return this.userRightMapper.fromMongoToModel(this.userRightMongoRepository.save(existingUserRight));
    }

    @Override
    public void delete(String id) {
        this.userRightMongoRepository.deleteById(id);
    }
}
