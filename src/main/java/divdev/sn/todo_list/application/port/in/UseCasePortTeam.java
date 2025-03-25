
package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Team;

public interface UseCasePortTeam {

    Team create(Team team);
    void delete(String id);
    List<Team> getAll();
    Optional<Team> getOne(String id);
    Team update(String id, Team team);

}