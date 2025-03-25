package divdev.sn.todo_list.infrastructure.adapter.out.jpa.todo;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.TodoRepository;
import divdev.sn.todo_list.domain.model.Todo;
import divdev.sn.todo_list.infrastructure.mapper.TodoMapper;


@Primary
@Repository("todoJpaAdapter")
public class TodoJpaAdapter implements TodoRepository {

    private final TodoJpaRepository todoJpaRepository;
    private final TodoMapper todoMapper;

    public TodoJpaAdapter(TodoJpaRepository todoJpaRepository, TodoMapper todoMapper) {
        this.todoJpaRepository = todoJpaRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public Todo save(Todo todo){
        EntityJpa entityTodo = this.todoMapper.toEntityJpa(todo);
        return this.todoMapper.fromJpatoModel(this.todoJpaRepository.save(entityTodo));
    }

    @Override
    public List<Todo> findAll(){
        return this.todoJpaRepository.findAll().stream()
            .map(this.todoMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Todo> findById(String id){
        return this.todoJpaRepository.findById(Long.valueOf(id)).map(this.todoMapper::fromJpatoModel);
    }

    @Override
    public List<Todo> findByIdProject(String idProject) {
        return this.todoJpaRepository.findByIdProject(Long.valueOf(idProject)).stream()
            .map(this.todoMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public List<Todo> findByIdCreateur(String idCreateur) {
        return this.todoJpaRepository.findByIdCreateur(Long.valueOf(idCreateur)).stream()
            .map(this.todoMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }


    @Override
    public Todo update(String id, Todo todo){
        EntityJpa todoExist = this.todoJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'ID : " + id));
        todoExist.setIdCreateur(this.todoMapper.toEntityJpa(todo).getIdCreateur());
        todoExist.setIdProject(this.todoMapper.toEntityJpa(todo).getIdProject());
        todoExist.setTitle(this.todoMapper.toEntityJpa(todo).getTitle());
        todoExist.setDescription(this.todoMapper.toEntityJpa(todo).getDescription());
        todoExist.setStatus(this.todoMapper.toEntityJpa(todo).getStatus());
        todoExist.setDateExp(this.todoMapper.toEntityJpa(todo).getDateExp());


        return this.todoMapper.fromJpatoModel(this.todoJpaRepository.save(todoExist));
    }

    @Override
    public void delete(String id){
        this.todoJpaRepository.deleteById(Long.valueOf(id));
    }

}
