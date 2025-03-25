package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Team;

public interface TeamRepository {

    Team save(Team team);
    Optional<Team> findById(String id);
    List<Team> findAll();
    Team update(String id, Team team);
    void delete(String id);
}
