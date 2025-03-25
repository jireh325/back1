
package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePortProjectTeam;
import divdev.sn.todo_list.application.port.out.ProjectTeamRepository;
import divdev.sn.todo_list.domain.model.ProjectTeam;
import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class ProjectTeamService implements UseCasePortProjectTeam {

    private final ProjectTeamRepository projectTeamRepository;

    public ProjectTeamService(@Qualifier("ProjectTeamMongoAdapter") ProjectTeamRepository projectTeamRepository) {
        this.projectTeamRepository = projectTeamRepository;
    }

    @Override
    public ProjectTeam create(ProjectTeam projectTeam){
        return this.projectTeamRepository.save(projectTeam);
    }

    @Override
    public Optional<ProjectTeam> getOne(String id){
        return this.projectTeamRepository.findById(id);
    }

    @Override
    public List<ProjectTeam> getAll(){
        return this.projectTeamRepository.findAll();
    }

    @Override
    public void delete(String id){
        this.projectTeamRepository.delete(id);
    }

    @Override
    public ProjectTeam update(String id, ProjectTeam projectTeam){
        return this.projectTeamRepository.update(id, projectTeam);
    }
}
