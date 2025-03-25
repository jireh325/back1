package divdev.sn.todo_list.infrastructure.adapter.out.jpa.project;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.ProjectRepository;
import divdev.sn.todo_list.domain.model.Historique;
import divdev.sn.todo_list.domain.model.Project;
import divdev.sn.todo_list.infrastructure.mapper.ProjectMapper;


@Primary
@Repository("ProjectJpaAdapter")
public class ProjectJpaAdapter implements ProjectRepository {

    private final ProjectJpaRepository projectJpaRepository;
    private final ProjectMapper projectMapper;

    public ProjectJpaAdapter(ProjectJpaRepository projectJpaRepository, ProjectMapper projectMapper) {
        this.projectJpaRepository = projectJpaRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Project save(Project Project){
        ProjectEntityJpa entityProject = this.projectMapper.toProjectEntityJpa(Project);
        return this.projectMapper.fromJpatoModel(this.projectJpaRepository.save(entityProject));
    }

    @Override
    public List<Project> findAll(){
        return this.projectJpaRepository.findAll().stream()
            .map(this.projectMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Project> findById(String id){
        return this.projectJpaRepository.findById(Long.valueOf(id)).map(this.projectMapper::fromJpatoModel);
    }

    @Override
    public List<Project> findByIdCreateur(String idCreateur) {
        return this.projectJpaRepository.findByIdCreateur(Long.valueOf(idCreateur)).stream()
        .map(this.projectMapper::fromJpatoModel)
        .collect(Collectors.toList());
    }


    @Override
    public Project update(String id, Project Project){
        ProjectEntityJpa projectExist = this.projectJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("Tâche non trouvée avec l'ID : " + id));
        projectExist.setName(this.projectMapper.toProjectEntityJpa(Project).getName());
        projectExist.setDescription(this.projectMapper.toProjectEntityJpa(Project).getDescription());
        projectExist.setIdCreateur(this.projectMapper.toProjectEntityJpa(Project).getIdCreateur());


        return this.projectMapper.fromJpatoModel(this.projectJpaRepository.save(projectExist));
    }

    @Override
    public void delete(String id){
        this.projectJpaRepository.deleteById(Long.valueOf(id));
    }

}
