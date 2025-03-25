package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.todo;
import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.dto.TodoDto;
import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.domain.model.Todo;

@Controller
public class TodoGraphQlController{

    private final UseCasePort useCasePort;

    public TodoGraphQlController(UseCasePort useCasePort) {
        this.useCasePort = useCasePort;
    }

    @QueryMapping(name = "getAllTodos")
    public List<Todo> getAll() {
        return useCasePort.getAll();
    }

    @QueryMapping(name = "getOneTodo")
    public Optional<Todo> getOne(@Argument String id) {
        return useCasePort.getOne(id);
    }

    @QueryMapping(name = "getTodoByIdProject")
    public List<Todo> getByIdProject(@Argument String idProject) {
        return useCasePort.getByIdProject(idProject);
    }

    @QueryMapping(name = "getTodoByIdCreateur")
    public List<Todo> getByIdCreateur(@Argument String id) {
        return useCasePort.getByIdCreateur(id);
    }

    @MutationMapping(name = "createTodo")
    public Todo create(@Argument("todoInput") TodoDto todoDto) {
        System.out.println("todo transferer" + todoDto);
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setIdCreateur(todoDto.getIdCreateur());
        todo.setIdProject(todoDto.getIdProject());
        todo.setDateExp(todoDto.getDateExp());
        todo.setStatus(todoDto.getStatus());
        return useCasePort.create(todo);
    }

    @MutationMapping(name = "updateTodo")
    public Todo update(@Argument String id, @Argument("todoInput") TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setIdCreateur(todoDto.getIdCreateur());
        todo.setIdProject(todoDto.getIdProject());
        todo.setDateExp(todoDto.getDateExp());
        todo.setStatus(todoDto.getStatus());
        return useCasePort.update(id, todo);
    }

    @MutationMapping(name = "deleteTodo")
    public void delete(@Argument String id) {
        useCasePort.delete(id);
    }
}
