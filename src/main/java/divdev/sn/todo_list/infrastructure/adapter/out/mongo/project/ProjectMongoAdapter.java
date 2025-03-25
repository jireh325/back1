package divdev.sn.todo_list.infrastructure.adapter.out.mongo.project;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.ProjectRepository;
import divdev.sn.todo_list.domain.model.Project;
import divdev.sn.todo_list.infrastructure.mapper.ProjectMapper;

@Repository("ProjectMongoAdapter")
public class ProjectMongoAdapter implements ProjectRepository {

    private final ProjectMongoRepository projectMongoRepository;
    private final ProjectMapper projectMapper;

    public ProjectMongoAdapter(ProjectMongoRepository projectMongoRepository, ProjectMapper projectMapper) {
        this.projectMongoRepository = projectMongoRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Project save(Project project) {
        ProjectEntityMongo entityProject = this.projectMapper.toProjectEntityMongo(project);
        return this.projectMapper.fromMongotoModel(this.projectMongoRepository.save(entityProject));
    }

    @Override
    public List<Project> findAll() {
        return this.projectMongoRepository.findAll().stream()
            .map(this.projectMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Project> findById(String id) {
        return this.projectMongoRepository.findById(id).map(this.projectMapper::fromMongotoModel);
    }

    @Override
    public List<Project> findByIdCreateur(String idUser) {
        return this.projectMongoRepository.findByIdCreateur(idUser).stream()
            .map(this.projectMapper::fromMongotoModel)
            .collect(Collectors.toList());

    }


    @Override
    public Project update(String id, Project project) {
        ProjectEntityMongo projectExist = this.projectMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'ID : " + id));

        ProjectEntityMongo updatedProject = this.projectMapper.toProjectEntityMongo(project);

        projectExist.setName(updatedProject.getName());
        projectExist.setDescription(updatedProject.getDescription());
        projectExist.setIdCreateur(updatedProject.getIdCreateur());

        return this.projectMapper.fromMongotoModel(this.projectMongoRepository.save(projectExist));
    }

    @Override
    public void delete(String id) {
        this.projectMongoRepository.deleteById(id);
    }
}
