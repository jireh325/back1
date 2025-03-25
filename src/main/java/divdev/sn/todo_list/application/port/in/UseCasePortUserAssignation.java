package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.UserAssignation;

public interface UseCasePortUserAssignation {

    UserAssignation create(UserAssignation userAssignation);
    void delete(String id);
    List<UserAssignation> getAll();
    Optional<UserAssignation> getOne(String id);
    List<UserAssignation> getByIdTodo(String idTodo);
    List<UserAssignation> getByIdUser(String idUser);
    Optional<UserAssignation> getByIdTodoAndIdUser(String idTodo, String idUser);
    UserAssignation update(String id, UserAssignation userAssignation);

}