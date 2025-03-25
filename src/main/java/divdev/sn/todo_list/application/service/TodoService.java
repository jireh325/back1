package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePort;
import divdev.sn.todo_list.application.port.out.TodoRepository;
import divdev.sn.todo_list.domain.model.Historique;
import divdev.sn.todo_list.domain.model.Todo;
import divdev.sn.todo_list.domain.model.Enum.HistStatus;
import divdev.sn.todo_list.domain.model.Enum.Status;

import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class TodoService implements UseCasePort {

    private final TodoRepository todoRepository;
    private final HistoriqueService historiqueService;

    public TodoService(@Qualifier("todoMongoAdapter") TodoRepository todoRepository, HistoriqueService historiqueService) {
        this.todoRepository = todoRepository;
        this.historiqueService = historiqueService;
    }

    @Override
    public Todo create(Todo todo){
        Todo createdTodo = this.todoRepository.save(todo);

        // Création de l'historique pour une nouvelle tâche
        historiqueService.create(new Historique(
            null, // ID généré automatiquement
            createdTodo.getIdCreateur(),
            createdTodo.getId(),
            HistStatus.created
        ));

        return createdTodo;
    }

    @Override
    public Optional<Todo> getOne(String id){
        return this.todoRepository.findById(id);
    }

    @Override
    public List<Todo> getAll(){
        return this.todoRepository.findAll();
    }

    @Override
    public void delete(String id){
        Optional<Todo> todo = this.todoRepository.findById(id);
        if (todo.isPresent()) {
            this.todoRepository.delete(id);

            // Ajout d'un historique pour suppression
            historiqueService.create(new Historique(
                null,
                todo.get().getIdCreateur(),
                id,
                HistStatus.deleted
            ));
        }
    }

    @Override
    public Todo update(String id, Todo todo){

 
        Todo updatedTodo = this.todoRepository.update(id, todo);
    
        historiqueService.create(new Historique(
            null, // ID généré automatiquement
            updatedTodo.getIdCreateur(),
            updatedTodo.getId(),
            updatedTodo.getStatus() == Status.isFinished ? HistStatus.ProgressToFinished : HistStatus.noStartedToProgress
        ));

        return updatedTodo;
    }

    @Override
    public List<Todo> getByIdCreateur(String idCreateur){
        return this.todoRepository.findByIdCreateur(idCreateur);
    }
    
    @Override
    public List<Todo> getByIdProject(String idProject){
        return this.todoRepository.findByIdProject(idProject);
    }

}
