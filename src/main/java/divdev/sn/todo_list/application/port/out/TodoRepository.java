package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Todo;

public interface TodoRepository {

    Todo save(Todo todo);
    Optional<Todo> findById(String id);
    List<Todo> findAll();
    Todo update(String id, Todo todo);
    void delete(String id);
    List<Todo> findByIdCreateur(String idCreateur);
    List<Todo> findByIdProject(String idProject);

}
