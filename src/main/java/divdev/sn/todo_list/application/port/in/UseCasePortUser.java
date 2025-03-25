package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.User;

public interface UseCasePortUser {

    User create(User user);
    void delete(String id);
    List<User> getAll();
    Optional<User> getOne(String id);
    Optional<User> getByEmail(String email);
    User update(String id, User user);

}