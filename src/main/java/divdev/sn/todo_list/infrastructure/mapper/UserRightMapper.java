package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.infrastructure.adapter.out.jpa.userRight.UserRightEntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.userRight.UserRightEntityMongo;
import divdev.sn.todo_list.domain.model.UserRight;

@Mapper(componentModel = "spring")
public interface UserRightMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    UserRight fromJpaToModel(UserRightEntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    UserRight fromMongoToModel(UserRightEntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.valueOf(entity.getId()) : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null && !entity.getIdUser().isEmpty() ? Long.valueOf(entity.getIdUser()) : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null && !entity.getIdProject().isEmpty() ? Long.valueOf(entity.getIdProject()) : null)")
    UserRightEntityJpa toUserRightEntityJpa(UserRight entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    UserRightEntityMongo toUserRightEntityMongo(UserRight entity);
}
