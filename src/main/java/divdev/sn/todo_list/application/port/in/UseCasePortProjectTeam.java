package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.ProjectTeam;

public interface UseCasePortProjectTeam {

    ProjectTeam create(ProjectTeam projectTeam);
    void delete(String id);
    List<ProjectTeam> getAll();
    Optional<ProjectTeam> getOne(String id);
    ProjectTeam update(String id, ProjectTeam projectTeam);

}