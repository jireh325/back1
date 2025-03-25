package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.userRight;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.port.in.UseCasePortUserRight;
import divdev.sn.todo_list.domain.model.UserRight;
import divdev.sn.todo_list.application.dto.UserRightDto;

@Controller
public class UserRightGraphQlController {

    private final UseCasePortUserRight useCasePortUserRight;

    public UserRightGraphQlController(UseCasePortUserRight useCasePortUserRight) {
        this.useCasePortUserRight = useCasePortUserRight;
    }

    @QueryMapping(name = "getAllUserRights")
    public List<UserRight> getAll() {
        return useCasePortUserRight.getAll();
    }

    @QueryMapping(name = "getOneUserRight")
    public Optional<UserRight> getOne(@Argument String id) {
        return useCasePortUserRight.getOne(id);
    }

    @QueryMapping(name = "getUserRightsByUser")
    public List<UserRight> getByIdUser(@Argument String idUser) {
        return useCasePortUserRight.getByIdUser(idUser);
    }

    @QueryMapping(name = "getUserRightsByProject")
    public List<UserRight> getByIdProject(@Argument String idProject) {
        return useCasePortUserRight.getByIdProject(idProject);
    }

    @QueryMapping(name = "getUserRightByUserAndProject")
    public Optional<UserRight> getByIdUserAndIdProject(@Argument String idUser, @Argument String idProject) {
        return useCasePortUserRight.getByIdUserAndIdProject(idUser, idProject);
    }

    @MutationMapping(name = "createUserRight")
    public UserRight create(@Argument("userRightInput") UserRightDto userRightDto) {
        UserRight userRight = new UserRight();
        userRight.setIdUser(userRightDto.getIdUser());
        userRight.setIdProject(userRightDto.getIdProject());
        userRight.setAdmin(userRightDto.isAdmin());
        return useCasePortUserRight.create(userRight);
    }

    @MutationMapping(name = "updateUserRight")
    public UserRight update(@Argument String id, @Argument("userRightInput") UserRightDto userRightDto) {
        UserRight userRight = new UserRight();
        userRight.setIdUser(userRightDto.getIdUser());
        userRight.setIdProject(userRightDto.getIdProject());
        userRight.setAdmin(userRightDto.isAdmin());
        return useCasePortUserRight.update(id, userRight);
    }

    @MutationMapping(name = "deleteUserRight")
    public void delete(@Argument String id) {
        useCasePortUserRight.delete(id);
    }
}
