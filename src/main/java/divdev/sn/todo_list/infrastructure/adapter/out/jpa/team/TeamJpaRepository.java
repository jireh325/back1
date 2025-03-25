package divdev.sn.todo_list.infrastructure.adapter.out.jpa.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamJpaRepository extends JpaRepository<TeamEntityJpa, Long> {
}
