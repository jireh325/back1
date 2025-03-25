package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.user;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.port.in.UseCasePortUser;
import divdev.sn.todo_list.domain.model.User;
import divdev.sn.todo_list.application.dto.UserDto;

@Controller
public class UserGraphQlController {

    private final UseCasePortUser useCasePortUser;

    public UserGraphQlController(UseCasePortUser useCasePortUser) {
        this.useCasePortUser = useCasePortUser;
    }

    @QueryMapping(name = "getAllUsers")
    public List<User> getAll() {
        return useCasePortUser.getAll();
    }

    @QueryMapping(name = "getOneUser")
    public Optional<User> getOne(@Argument String id) {
        return useCasePortUser.getOne(id);
    }

    @MutationMapping(name = "createUser")
    public User create(@Argument("userInput") UserDto UserDto) {
        User user = new User();
        user.setFirstName(UserDto.getFirstName());
        user.setLastName(UserDto.getLastName());
        user.setPass(UserDto.getPass());
        user.setEmail(UserDto.getEmail());
        return useCasePortUser.create(user);
    }

    @MutationMapping(name = "updateUser")
    public User update(@Argument String id, @Argument("userInput") UserDto UserDto) {
        User user = new User();
        user.setFirstName(UserDto.getFirstName());
        user.setLastName(UserDto.getLastName());
        user.setPass(UserDto.getPass());
        user.setEmail(UserDto.getEmail());
        return useCasePortUser.update(id, user);
    }

    @MutationMapping(name = "deleteUser")
    public void delete(@Argument String id) {
        useCasePortUser.delete(id);
    }
}
