package divdev.sn.todo_list.infrastructure.adapter.out.jpa.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectJpaRepository extends JpaRepository<ProjectEntityJpa, Long> {
    List<ProjectEntityJpa> findByIdCreateur(Long idCreateur);

}
