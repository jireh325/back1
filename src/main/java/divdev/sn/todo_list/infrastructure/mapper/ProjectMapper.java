package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.infrastructure.adapter.out.jpa.project.ProjectEntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.project.ProjectEntityMongo;
import divdev.sn.todo_list.domain.model.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    Project fromJpatoModel(ProjectEntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    Project fromMongotoModel(ProjectEntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.parseLong(entity.getId()) : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null && !entity.getIdCreateur().isEmpty() ? Long.parseLong(entity.getIdCreateur()) : null)")
    ProjectEntityJpa toProjectEntityJpa(Project entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    ProjectEntityMongo toProjectEntityMongo(Project entity);
}
