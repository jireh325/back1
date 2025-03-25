package divdev.sn.todo_list.infrastructure.adapter.out.jpa.userRight;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRightJpaRepository extends JpaRepository<UserRightEntityJpa, Long> {

    List<UserRightEntityJpa> findByIdUser(Long idUser);
    List<UserRightEntityJpa> findByIdProject(Long idProject);
    Optional<UserRightEntityJpa> findByIdUserAndIdProject(Long idUser, Long idProject);
}
