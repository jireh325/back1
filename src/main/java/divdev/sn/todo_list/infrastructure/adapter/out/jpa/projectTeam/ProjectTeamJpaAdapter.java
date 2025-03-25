package divdev.sn.todo_list.infrastructure.adapter.out.jpa.projectTeam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.ProjectTeamRepository;
import divdev.sn.todo_list.domain.model.ProjectTeam;
import divdev.sn.todo_list.infrastructure.mapper.ProjectTeamMapper;

@Primary
@Repository("ProjectTeamJpaAdapter")
public class ProjectTeamJpaAdapter implements ProjectTeamRepository {

    private final ProjectTeamJpaRepository projectTeamJpaRepository;
    private final ProjectTeamMapper projectTeamMapper;

    public ProjectTeamJpaAdapter(ProjectTeamJpaRepository projectTeamJpaRepository, ProjectTeamMapper projectTeamMapper) {
        this.projectTeamJpaRepository = projectTeamJpaRepository;
        this.projectTeamMapper = projectTeamMapper;
    }

    @Override
    public ProjectTeam save(ProjectTeam projectTeam) {
        ProjectTeamEntityJpa entity = this.projectTeamMapper.toProjectTeamEntityJpa(projectTeam);
        return this.projectTeamMapper.fromJpatoModel(this.projectTeamJpaRepository.save(entity));
    }

    @Override
    public List<ProjectTeam> findAll() {
        return this.projectTeamJpaRepository.findAll().stream()
            .map(this.projectTeamMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProjectTeam> findById(String id) {
        return this.projectTeamJpaRepository.findById(Long.valueOf(id)).map(this.projectTeamMapper::fromJpatoModel);
    }

    @Override
    public ProjectTeam update(String id, ProjectTeam projectTeam) {
        ProjectTeamEntityJpa existingProjectTeam = this.projectTeamJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("ProjectTeam non trouvé avec l'ID : " + id));

        ProjectTeamEntityJpa updatedProjectTeam = this.projectTeamMapper.toProjectTeamEntityJpa(projectTeam);

        existingProjectTeam.setIdTeam(updatedProjectTeam.getIdTeam());
        existingProjectTeam.setIdProject(updatedProjectTeam.getIdProject());
        existingProjectTeam.setStatus(updatedProjectTeam.getStatus());

        return this.projectTeamMapper.fromJpatoModel(this.projectTeamJpaRepository.save(existingProjectTeam));
    }

    @Override
    public void delete(String id) {
        this.projectTeamJpaRepository.deleteById(Long.valueOf(id));
    }
}
