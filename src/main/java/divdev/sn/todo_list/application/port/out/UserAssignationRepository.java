package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.UserAssignation;

public interface UserAssignationRepository {

    UserAssignation save(UserAssignation userAssignation);
    Optional<UserAssignation> findById(String id);
    List<UserAssignation> findByIdTodo(String idTodo);
    List<UserAssignation> findByIdUser(String idUser);
    Optional<UserAssignation> findByIdTodoAndIdUser(String idTodo, String idUser);
    List<UserAssignation> findAll();
    UserAssignation update(String id, UserAssignation userAssignation);
    void delete(String id);
}
