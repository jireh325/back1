package divdev.sn.todo_list.infrastructure.adapter.out.mongo.team;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import divdev.sn.todo_list.application.port.out.TeamRepository;
import divdev.sn.todo_list.domain.model.Team;
import divdev.sn.todo_list.infrastructure.mapper.TeamMapper;

@Repository("TeamMongoAdapter")
public class TeamMongoAdapter implements TeamRepository {

    private final TeamMongoRepository teamMongoRepository;
    private final TeamMapper teamMapper;

    public TeamMongoAdapter(TeamMongoRepository teamMongoRepository, TeamMapper teamMapper) {
        this.teamMongoRepository = teamMongoRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public Team save(Team team) {
        TeamEntityMongo entity = this.teamMapper.toTeamEntityMongo(team);
        return this.teamMapper.fromMongotoModel(this.teamMongoRepository.save(entity));
    }

    @Override
    public List<Team> findAll() {
        return this.teamMongoRepository.findAll().stream()
            .map(this.teamMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Team> findById(String id) {
        return this.teamMongoRepository.findById(id).map(this.teamMapper::fromMongotoModel);
    }

    @Override
    public Team update(String id, Team team) {
        TeamEntityMongo existingTeam = this.teamMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Équipe non trouvée avec l'ID : " + id));

        existingTeam.setName(team.getName());
        existingTeam.setIdCreateur(team.getIdCreateur());

        return this.teamMapper.fromMongotoModel(this.teamMongoRepository.save(existingTeam));
    }

    @Override
    public void delete(String id) {
        this.teamMongoRepository.deleteById(id);
    }
}
