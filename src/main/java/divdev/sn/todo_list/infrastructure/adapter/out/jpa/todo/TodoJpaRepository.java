package divdev.sn.todo_list.infrastructure.adapter.out.jpa.todo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<EntityJpa, Long> {
    List<EntityJpa> findByIdCreateur(Long idCreateur);
    List<EntityJpa> findByIdProject(Long idProject);
}
