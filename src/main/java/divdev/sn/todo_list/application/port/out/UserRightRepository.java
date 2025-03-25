package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.UserRight;

public interface UserRightRepository {

    UserRight save(UserRight userRight);
    Optional<UserRight> findById(String id);
    List<UserRight> findByIdUser(String idUser);
    List<UserRight> findByIdProject(String idProject);
    Optional<UserRight> findByIdUserAndIdProject(String idUser, String idProject);
    List<UserRight> findAll();
    UserRight update(String id, UserRight userRight);
    void delete(String id);
}
