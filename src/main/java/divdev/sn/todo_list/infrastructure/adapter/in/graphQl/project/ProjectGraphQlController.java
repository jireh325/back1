package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.project;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.dto.ProjectDto;
import divdev.sn.todo_list.application.port.in.UseCasePortProject;
import divdev.sn.todo_list.domain.model.Project;

@Controller
public class ProjectGraphQlController {

    private final UseCasePortProject useCasePortProject;

    public ProjectGraphQlController(UseCasePortProject useCasePortProject) {
        this.useCasePortProject = useCasePortProject;
    }

    @QueryMapping(name = "getAllProjects")
    public List<Project> getAll() {
        return useCasePortProject.getAll();
    }

    @QueryMapping(name = "getProjectById")
    public Optional<Project> getOne(@Argument String id) {
        return useCasePortProject.getOne(id);
    }

    @QueryMapping(name = "getProjectByIdCreateur")
    public List<Project> getByIdCreateur(@Argument String idCreateur) {
        return useCasePortProject.getByIdCreateur(idCreateur);
    }

    @MutationMapping(name = "createProject")
    public Project create(@Argument("projectInput") ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setIdCreateur(projectDto.getIdCreateur());
        return useCasePortProject.create(project);
    }

    @MutationMapping(name = "updateProject")
    public Project update(@Argument String id, @Argument("projectInput") ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        return useCasePortProject.update(id, project);
    }

    @MutationMapping(name = "deleteProject")
    public void delete(@Argument String id) {
        useCasePortProject.delete(id);
    }
}
