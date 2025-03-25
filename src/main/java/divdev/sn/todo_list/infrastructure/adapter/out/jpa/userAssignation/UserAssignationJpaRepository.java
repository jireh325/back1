package divdev.sn.todo_list.infrastructure.adapter.out.jpa.userAssignation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserAssignationJpaRepository extends JpaRepository<UserAssignationEntityJpa, Long> {
    List<UserAssignationEntityJpa> findByIdTodo(Long idTodo);
    List<UserAssignationEntityJpa> findByIdUser(Long idUser);
    Optional<UserAssignationEntityJpa> findByIdTodoAndIdUser(Long idTodo, Long idUser);
}
