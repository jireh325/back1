package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.ProjectTeam;

public interface ProjectTeamRepository {

    ProjectTeam save(ProjectTeam projectTeam);
    Optional<ProjectTeam> findById(String id);
    List<ProjectTeam> findAll();
    ProjectTeam update(String id, ProjectTeam projectTeam);
    void delete(String id);
}
