package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;
import divdev.sn.todo_list.domain.model.UserRight;

public interface UseCasePortUserRight {

    UserRight create(UserRight userRight);
    void delete(String id);
    List<UserRight> getAll();
    Optional<UserRight> getOne(String id);
    List<UserRight> getByIdUser(String idUser);
    List<UserRight> getByIdProject(String idProject);
    Optional<UserRight> getByIdUserAndIdProject(String idUser, String idProject);
    UserRight update(String id, UserRight userRight);

}