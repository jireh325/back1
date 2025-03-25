package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePortUser;
import divdev.sn.todo_list.application.port.out.UserRepository;
import divdev.sn.todo_list.domain.model.Project;
import divdev.sn.todo_list.domain.model.User;


@Service
public class UserService implements UseCasePortUser {

    private final UserRepository userRepository;
    private final ProjectService projectService;


    public UserService(@Qualifier("UserMongoAdapter") UserRepository userRepository, ProjectService projectService) {
        this.userRepository = userRepository;
        this.projectService = projectService;
    }

    @Override
    public User create(User User){
        return this.userRepository.save(User);
    }

    @Override
    public Optional<User> getOne(String id){
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> getByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    @Override
    public void delete(String id){
        
        List<Project> projects = projectService.getByIdCreateur(id);
        for (Project project : projects) {
            projectService.delete(project.getId());
        }

        this.userRepository.delete(id);
    }

    @Override
    public User update(String id, User user){
        return this.userRepository.update(id, user);
    }
}
