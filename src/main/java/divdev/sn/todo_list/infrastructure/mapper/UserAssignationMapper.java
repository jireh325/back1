package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.infrastructure.adapter.out.jpa.userAssignation.UserAssignationEntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.userAssignation.UserAssignationEntityMongo;
import divdev.sn.todo_list.domain.model.UserAssignation;

@Mapper(componentModel = "spring")
public interface UserAssignationMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    UserAssignation fromJpatoModel(UserAssignationEntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    UserAssignation fromMongotoModel(UserAssignationEntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.valueOf(entity.getId()) : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null && !entity.getIdUser().isEmpty() ? Long.valueOf(entity.getIdUser()) : null)")
    UserAssignationEntityJpa toUserAssignationEntityJpa(UserAssignation entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    UserAssignationEntityMongo toUserAssignationEntityMongo(UserAssignation entity);
}
