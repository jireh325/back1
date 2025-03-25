package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Todo;

public interface UseCasePort {

    Todo create(Todo todo);
    void delete(String id);
    List<Todo> getAll();
    Optional<Todo> getOne(String id);
    Todo update(String id, Todo todo);
    List<Todo> getByIdProject(String idProject);
    List<Todo> getByIdCreateur(String idCreateur);


}
