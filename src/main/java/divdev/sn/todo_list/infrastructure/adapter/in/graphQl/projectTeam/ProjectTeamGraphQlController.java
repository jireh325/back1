package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.projectTeam;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.port.in.UseCasePortProjectTeam;
import divdev.sn.todo_list.domain.model.ProjectTeam;
import divdev.sn.todo_list.application.dto.ProjectTeamDto;

@Controller
public class ProjectTeamGraphQlController {

    private final UseCasePortProjectTeam useCasePortProjectTeam;

    public ProjectTeamGraphQlController(UseCasePortProjectTeam useCasePortProjectTeam) {
        this.useCasePortProjectTeam = useCasePortProjectTeam;
    }

    @QueryMapping(name = "getAllProjectTeams")
    public List<ProjectTeam> getAll() {
        return useCasePortProjectTeam.getAll();
    }

    @QueryMapping(name = "getOneProjectTeam")
    public Optional<ProjectTeam> getOne(@Argument String id) {
        return useCasePortProjectTeam.getOne(id);
    }

    @MutationMapping(name = "createProjectTeam")
    public ProjectTeam create(@Argument("ProjectTeamInput") ProjectTeamDto projectTeamDto) {
        ProjectTeam projectTeam = new ProjectTeam();
        projectTeam.setIdTeam(projectTeamDto.getIdTeam());
        projectTeam.setIdProject(projectTeamDto.getIdProject());
        projectTeam.setStatus(projectTeamDto.getStatus());
        return useCasePortProjectTeam.create(projectTeam);
    }

    @MutationMapping(name = "updateProjectTeam")
    public ProjectTeam update(@Argument String id, @Argument("ProjectTeamInput") ProjectTeamDto projectTeamDto) {
        ProjectTeam projectTeam = new ProjectTeam();
        projectTeam.setIdTeam(projectTeamDto.getIdTeam());
        projectTeam.setIdProject(projectTeamDto.getIdProject());
        projectTeam.setStatus(projectTeamDto.getStatus());
        return useCasePortProjectTeam.update(id, projectTeam);
    }

    @MutationMapping(name = "deleteProjectTeam")
    public void delete(@Argument String id) {
        useCasePortProjectTeam.delete(id);
    }
}
