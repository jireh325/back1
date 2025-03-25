package divdev.sn.todo_list.infrastructure.adapter.out.jpa.team;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import divdev.sn.todo_list.application.port.out.TeamRepository;
import divdev.sn.todo_list.domain.model.Team;
import divdev.sn.todo_list.infrastructure.mapper.TeamMapper;

@Primary
@Repository("TeamJpaAdapter")
public class TeamJpaAdapter implements TeamRepository {

    private final TeamJpaRepository teamJpaRepository;
    private final TeamMapper teamMapper;

    public TeamJpaAdapter(TeamJpaRepository teamJpaRepository, TeamMapper teamMapper) {
        this.teamJpaRepository = teamJpaRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public Team save(Team team) {
        TeamEntityJpa entity = this.teamMapper.toTeamEntityJpa(team);
        return this.teamMapper.fromJpatoModel(this.teamJpaRepository.save(entity));
    }

    @Override
    public List<Team> findAll() {
        return this.teamJpaRepository.findAll().stream()
            .map(this.teamMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Team> findById(String id) {
        return this.teamJpaRepository.findById(Long.valueOf(id)).map(this.teamMapper::fromJpatoModel);
    }

    @Override
    public Team update(String id, Team team) {
        TeamEntityJpa existingTeam = this.teamJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("Équipe non trouvée avec l'ID : " + id));

        existingTeam.setName(team.getName());
        existingTeam.setIdCreateur(Long.valueOf(team.getIdCreateur()));

        return this.teamMapper.fromJpatoModel(this.teamJpaRepository.save(existingTeam));
    }

    @Override
    public void delete(String id) {
        this.teamJpaRepository.deleteById(Long.valueOf(id));
    }
}
