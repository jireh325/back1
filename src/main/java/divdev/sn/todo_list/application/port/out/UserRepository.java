package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.User;

public interface UserRepository {

    User save(User user);
    Optional<User> findById(String id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    User update(String id, User user);
    void delete(String id);
}
