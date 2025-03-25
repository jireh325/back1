package divdev.sn.todo_list.infrastructure.adapter.out.jpa.userRight;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.UserRightRepository;
import divdev.sn.todo_list.domain.model.UserRight;
import divdev.sn.todo_list.infrastructure.mapper.UserRightMapper;

@Primary
@Repository("UserRightJpaAdapter")
public class UserRightJpaAdapter implements UserRightRepository {

    private final UserRightJpaRepository userRightJpaRepository;
    private final UserRightMapper userRightMapper;

    public UserRightJpaAdapter(UserRightJpaRepository userRightJpaRepository, UserRightMapper userRightMapper) {
        this.userRightJpaRepository = userRightJpaRepository;
        this.userRightMapper = userRightMapper;
    }

    @Override
    public UserRight save(UserRight userRight) {
        UserRightEntityJpa entity = this.userRightMapper.toUserRightEntityJpa(userRight);
        return this.userRightMapper.fromJpaToModel(this.userRightJpaRepository.save(entity));
    }

    @Override
    public List<UserRight> findAll() {
        return this.userRightJpaRepository.findAll().stream()
            .map(this.userRightMapper::fromJpaToModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRight> findById(String id) {
        return this.userRightJpaRepository.findById(Long.valueOf(id))
            .map(this.userRightMapper::fromJpaToModel);
    }

    @Override
    public List<UserRight> findByIdUser(String idUser) {
        return this.userRightJpaRepository.findByIdUser(Long.valueOf(idUser)).stream()
            .map(this.userRightMapper::fromJpaToModel)
            .collect(Collectors.toList());
    }

    @Override
    public List<UserRight> findByIdProject(String idProject) {
        return this.userRightJpaRepository.findByIdProject(Long.valueOf(idProject)).stream()
            .map(this.userRightMapper::fromJpaToModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRight> findByIdUserAndIdProject(String idUser, String idProject) {
        return this.userRightJpaRepository.findByIdUserAndIdProject(Long.valueOf(idUser), Long.valueOf(idProject))
            .map(this.userRightMapper::fromJpaToModel);
    }

    @Override
    public UserRight update(String id, UserRight userRight) {
        UserRightEntityJpa existingUserRight = this.userRightJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("User right not found with ID: " + id));

        existingUserRight.setIdUser(Long.valueOf(userRight.getIdUser()));
        existingUserRight.setIdProject(Long.valueOf(userRight.getIdProject()));
        existingUserRight.setAdmin(userRight.isAdmin());

        return this.userRightMapper.fromJpaToModel(this.userRightJpaRepository.save(existingUserRight));
    }

    @Override
    public void delete(String id) {
        this.userRightJpaRepository.deleteById(Long.valueOf(id));
    }
}
