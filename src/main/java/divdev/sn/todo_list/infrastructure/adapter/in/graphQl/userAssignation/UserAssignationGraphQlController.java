package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.userAssignation;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.port.in.UseCasePortUserAssignation;
import divdev.sn.todo_list.domain.model.UserAssignation;
import divdev.sn.todo_list.application.dto.UserAssignationDto;

@Controller
public class UserAssignationGraphQlController {

    private final UseCasePortUserAssignation useCasePortUserAssignation;

    public UserAssignationGraphQlController(UseCasePortUserAssignation useCasePortUserAssignation) {
        this.useCasePortUserAssignation = useCasePortUserAssignation;
    }

    @QueryMapping(name = "getAllUserAssignations")
    public List<UserAssignation> getAll() {
        return useCasePortUserAssignation.getAll();
    }

    @QueryMapping(name = "getOneUserAssignation")
    public Optional<UserAssignation> getOne(@Argument String id) {
        return useCasePortUserAssignation.getOne(id);
    }

    @QueryMapping(name = "getUserAssignationsByTodo")
    public List<UserAssignation> getByIdTodo(@Argument String idTodo) {
        return useCasePortUserAssignation.getByIdTodo(idTodo);
    }

    @QueryMapping(name = "getUserAssignationsByUser")
    public List<UserAssignation> getByIdUser(@Argument String idUser) {
        return useCasePortUserAssignation.getByIdUser(idUser);
    }

    @QueryMapping(name = "getUserAssignationByTodoAndUser")
    public Optional<UserAssignation> getByIdTodoAndIdUser(@Argument String idTodo, @Argument String idUser) {
        return useCasePortUserAssignation.getByIdTodoAndIdUser(idTodo, idUser);
    }

    @MutationMapping(name = "createUserAssignation")
    public UserAssignation create(@Argument("userAssignationInput") UserAssignationDto userAssignationDto) {
        UserAssignation userAssignation = new UserAssignation();
        userAssignation.setIdTodo(userAssignationDto.getIdTodo());
        userAssignation.setIdUser(userAssignationDto.getIdUser());
        return useCasePortUserAssignation.create(userAssignation);
    }

    @MutationMapping(name = "updateUserAssignation")
    public UserAssignation update(@Argument String id, @Argument("userAssignationInput") UserAssignationDto userAssignationDto) {
        UserAssignation userAssignation = new UserAssignation();
        userAssignation.setIdTodo(userAssignationDto.getIdTodo());
        userAssignation.setIdUser(userAssignationDto.getIdUser());
        return useCasePortUserAssignation.update(id, userAssignation);
    }

    @MutationMapping(name = "deleteUserAssignation")
    public void delete(@Argument String id) {
        useCasePortUserAssignation.delete(id);
    }
}
