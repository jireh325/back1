package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.domain.model.Todo;
import divdev.sn.todo_list.infrastructure.adapter.out.jpa.todo.EntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.todo.EntityMongo;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    Todo fromJpatoModel(EntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    Todo fromMongotoModel(EntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.valueOf(entity.getId()) : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null && !entity.getIdProject().isEmpty() ? Long.valueOf(entity.getIdProject()) : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null && !entity.getIdCreateur().isEmpty() ? Long.valueOf(entity.getIdCreateur()) : null)")
    EntityJpa toEntityJpa(Todo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    EntityMongo toEntityMongo(Todo entity);
}
