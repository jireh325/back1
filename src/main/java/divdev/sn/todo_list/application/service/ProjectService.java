package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePortProject;
import divdev.sn.todo_list.application.port.out.ProjectRepository;
import divdev.sn.todo_list.domain.model.Project;
import divdev.sn.todo_list.domain.model.Todo;
import divdev.sn.todo_list.domain.model.UserRight;


@Service
public class ProjectService implements UseCasePortProject {

    private final ProjectRepository projectRepository;
    private final TodoService todoService;
    private final UserRightService userRightService;

    public ProjectService(@Qualifier("ProjectMongoAdapter") ProjectRepository projectRepository, TodoService todoService, UserRightService userRightService){
        this.projectRepository = projectRepository;
        this.todoService = todoService;
        this.userRightService = userRightService;
    }

    @Override
    public Project create(Project project){
        Project savedProject = this.projectRepository.save(project);

        UserRight userRight = new UserRight();
        userRight.setIdUser(savedProject.getIdCreateur());
        userRight.setIdProject(savedProject.getId());
        userRight.setAdmin(true);  // L'utilisateur créateur est admin par défaut

        userRightService.create(userRight); // Sauvegarder les droits utilisateur

        return savedProject;
    }

    @Override
    public Optional<Project> getOne(String id){
        return this.projectRepository.findById(id);
    }

    @Override
    public List<Project> getAll(){
        return this.projectRepository.findAll();
    }

    @Override
    public void delete(String id){

        List<Todo> todos = todoService.getByIdProject(id);
        for (Todo todo : todos) {
            todoService.delete(todo.getId());
        }

        // Supprimer le projet après avoir supprimé les tâches
        this.projectRepository.delete(id);
    }

    @Override
    public Project update(String id, Project project){
        return this.projectRepository.update(id, project);
    }

    @Override
    public List<Project> getByIdCreateur(String idCreateur){
        return this.projectRepository.findByIdCreateur(idCreateur);
    }
}
