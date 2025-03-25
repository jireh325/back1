package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Project;

public interface UseCasePortProject {

    Project create(Project project);
    void delete(String id);
    List<Project> getAll();
    Optional<Project> getOne(String id);
    List<Project> getByIdCreateur(String idCreateur);
    Project update(String id, Project project);

}
