package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.infrastructure.adapter.out.jpa.user.UserEntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.user.UserEntityMongo;
import divdev.sn.todo_list.domain.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    User fromUserJpatoModel(UserEntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    User fromUserMongotoModel(UserEntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.valueOf(entity.getId()) : null)")
    UserEntityJpa toUserEntityJpa(User entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    UserEntityMongo toUserEntityMongo(User entity);
}
