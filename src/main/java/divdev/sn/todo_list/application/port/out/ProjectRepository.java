package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Project;

public interface ProjectRepository {

    Project save(Project project);
    Optional<Project> findById(String id);
    List<Project> findAll();
    Project update(String id, Project project);
    List<Project> findByIdCreateur(String idCreateur);
    void delete(String id);
}
