package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.team;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.port.in.UseCasePortTeam;
import divdev.sn.todo_list.domain.model.Team;
import divdev.sn.todo_list.application.dto.TeamDto;

@Controller
public class TeamGraphQlController {

    private final UseCasePortTeam useCasePortTeam;

    public TeamGraphQlController(UseCasePortTeam useCasePortTeam) {
        this.useCasePortTeam = useCasePortTeam;
    }

    @QueryMapping(name = "getAllTeams")
    public List<Team> getAll() {
        return useCasePortTeam.getAll();
    }

    @QueryMapping(name = "getOneTeam")
    public Optional<Team> getOne(@Argument String id) {
        return useCasePortTeam.getOne(id);
    }

    @MutationMapping(name = "createTeam")
    public Team create(@Argument("teamInput") TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        team.setIdCreateur(teamDto.getIdCreateur());
        return useCasePortTeam.create(team);
    }

    @MutationMapping(name = "updateTeam")
    public Team update(@Argument String id, @Argument("teamInput") TeamDto teamDto) {
        Team team = new Team();
        team.setName(teamDto.getName());
        team.setIdCreateur(teamDto.getIdCreateur());
        return useCasePortTeam.update(id, team);
    }

    @MutationMapping(name = "deleteTeam")
    public void delete(@Argument String id) {
        useCasePortTeam.delete(id);
    }
}
