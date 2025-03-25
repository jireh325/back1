package divdev.sn.todo_list.infrastructure.adapter.in.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.domain.model.Todo;

@RestController
@RequestMapping("/Todo")
public class TodoRestController {

    private final UseCasePort useCasePort;

    public TodoRestController(UseCasePort useCasePort) {
        this.useCasePort = useCasePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        return this.useCasePort.create(todo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getAll() {
        return this.useCasePort.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Todo> getOne(@PathVariable String id) {
        return this.useCasePort.getOne(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.useCasePort.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo update(@PathVariable String id, @RequestBody Todo todo) {
        return this.useCasePort.update(id, todo);
    }
}
