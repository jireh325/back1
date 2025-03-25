package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePortTeam;
import divdev.sn.todo_list.application.port.out.TeamRepository;
import divdev.sn.todo_list.domain.model.Team;
import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class TeamService implements UseCasePortTeam {

    private final TeamRepository teamRepository;

    public TeamService(@Qualifier("TeamMongoAdapter") TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team create(Team team){
        return this.teamRepository.save(team);
    }

    @Override
    public Optional<Team> getOne(String id){
        return this.teamRepository.findById(id);
    }

    @Override
    public List<Team> getAll(){
        return this.teamRepository.findAll();
    }

    @Override
    public void delete(String id){
        this.teamRepository.delete(id);
    }

    @Override
    public Team update(String id, Team team){
        return this.teamRepository.update(id, team);
    }
}
