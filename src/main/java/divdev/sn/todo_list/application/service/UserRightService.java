package divdev.sn.todo_list.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePortUserRight;
import divdev.sn.todo_list.application.port.out.UserRightRepository;
import divdev.sn.todo_list.domain.model.UserRight;
import org.springframework.beans.factory.annotation.Qualifier;



@Service
public class UserRightService implements UseCasePortUserRight {

    private final UserRightRepository userRightRepository;

    public UserRightService(@Qualifier("UserRightMongoAdapter") UserRightRepository userRightRepository) {
        this.userRightRepository = userRightRepository;
    }

    @Override
    public UserRight create(UserRight userRight){
        return this.userRightRepository.save(userRight);
    }

    @Override
    public Optional<UserRight> getOne(String id){
        return this.userRightRepository.findById(id);
    }

    @Override
    public List<UserRight> getByIdUser(String idUser){
        return this.userRightRepository.findByIdUser(idUser);
    }

    @Override
    public List<UserRight> getByIdProject(String idProject){
        return this.userRightRepository.findByIdUser(idProject);
    }

    @Override
    public Optional<UserRight> getByIdUserAndIdProject(String idUser, String idProject){
        return this.userRightRepository.findByIdUserAndIdProject(idUser, idProject);
    }

    @Override
    public List<UserRight> getAll(){
        return this.userRightRepository.findAll();
    }

    @Override
    public void delete(String id){
        this.userRightRepository.delete(id);
    }

    @Override
    public UserRight update(String id, UserRight userRight){
        return this.userRightRepository.update(id, userRight);
    }
}
