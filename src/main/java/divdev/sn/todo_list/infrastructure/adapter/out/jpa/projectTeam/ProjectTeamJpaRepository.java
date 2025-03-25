package divdev.sn.todo_list.infrastructure.adapter.out.jpa.projectTeam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTeamJpaRepository extends JpaRepository<ProjectTeamEntityJpa, Long> {
}
