package divdev.sn.todo_list.infrastructure.adapter.out.mongo.projectTeam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.ProjectTeamRepository;
import divdev.sn.todo_list.domain.model.ProjectTeam;
import divdev.sn.todo_list.infrastructure.mapper.ProjectTeamMapper;

@Repository("ProjectTeamMongoAdapter")
public class ProjectTeamMongoAdapter implements ProjectTeamRepository {

    private final ProjectTeamMongoRepository projectTeamMongoRepository;
    private final ProjectTeamMapper projectTeamMapper;

    public ProjectTeamMongoAdapter(ProjectTeamMongoRepository projectTeamMongoRepository, ProjectTeamMapper projectTeamMapper) {
        this.projectTeamMongoRepository = projectTeamMongoRepository;
        this.projectTeamMapper = projectTeamMapper;
    }

    @Override
    public ProjectTeam save(ProjectTeam projectTeam) {
        ProjectTeamEntityMongo entity = this.projectTeamMapper.toProjectTeamEntityMongo(projectTeam);
        return this.projectTeamMapper.fromMongotoModel(this.projectTeamMongoRepository.save(entity));
    }

    @Override
    public List<ProjectTeam> findAll() {
        return this.projectTeamMongoRepository.findAll().stream()
            .map(this.projectTeamMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProjectTeam> findById(String id) {
        return this.projectTeamMongoRepository.findById(id).map(this.projectTeamMapper::fromMongotoModel);
    }

    @Override
    public ProjectTeam update(String id, ProjectTeam projectTeam) {
        ProjectTeamEntityMongo existingProjectTeam = this.projectTeamMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("ProjectTeam non trouvé avec l'ID : " + id));

        ProjectTeamEntityMongo updatedProjectTeam = this.projectTeamMapper.toProjectTeamEntityMongo(projectTeam);

        existingProjectTeam.setIdTeam(updatedProjectTeam.getIdTeam());
        existingProjectTeam.setIdProject(updatedProjectTeam.getIdProject());
        existingProjectTeam.setStatus(updatedProjectTeam.getStatus());

        return this.projectTeamMapper.fromMongotoModel(this.projectTeamMongoRepository.save(existingProjectTeam));
    }

    @Override
    public void delete(String id) {
        this.projectTeamMongoRepository.deleteById(id);
    }
}
