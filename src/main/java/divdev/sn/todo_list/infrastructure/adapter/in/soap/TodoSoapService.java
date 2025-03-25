package divdev.sn.todo_list.infrastructure.adapter.in.soap;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.domain.model.Todo;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "TodoSoap")
@Service
public class TodoSoapService {

    private final UseCasePort useCasePort;

    public TodoSoapService(UseCasePort useCasePort) {
        this.useCasePort = useCasePort;
    }

    @WebMethod(operationName = "getAllTodos")
    public List<Todo> getAll() {
        return useCasePort.getAll();
    }

    @WebMethod(operationName = "getOneTodo")
    public Optional<Todo> getOne(@WebParam(name = "id") String id) {
        return useCasePort.getOne(id);
    }

    @WebMethod(operationName = "createTodo")
    public Todo create(@WebParam(name = "todo") Todo todo) {
        return useCasePort.create(todo);
    }

    @WebMethod(operationName = "updateTodo")
    public Todo update(@WebParam(name = "id") String id, @WebParam(name = "todo") Todo todo) {
        return useCasePort.update(id, todo);
    }

    @WebMethod(operationName = "deleteTodo")
    public void delete(@WebParam(name = "id") String id) {
        useCasePort.delete(id);
    }
}
