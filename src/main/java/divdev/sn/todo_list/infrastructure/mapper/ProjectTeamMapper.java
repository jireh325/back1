package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.domain.model.ProjectTeam;
import divdev.sn.todo_list.infrastructure.adapter.out.jpa.projectTeam.ProjectTeamEntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.projectTeam.ProjectTeamEntityMongo;

@Mapper(componentModel = "spring")
public interface ProjectTeamMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    @Mapping(target = "idTeam", expression = "java(entity.getIdTeam() != null ? entity.getIdTeam().toString() : null)")
    ProjectTeam fromJpatoModel(ProjectTeamEntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    @Mapping(target = "idTeam", expression = "java(entity.getIdTeam() != null ? entity.getIdTeam().toString() : null)")
    ProjectTeam fromMongotoModel(ProjectTeamEntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.valueOf(entity.getId()) : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null && !entity.getIdProject().isEmpty() ? Long.valueOf(entity.getIdProject()) : null)")
    @Mapping(target = "idTeam", expression = "java(entity.getIdTeam() != null && !entity.getIdTeam().isEmpty() ? Long.valueOf(entity.getIdTeam()) : null)")
    ProjectTeamEntityJpa toProjectTeamEntityJpa(ProjectTeam entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idProject", expression = "java(entity.getIdProject() != null ? entity.getIdProject().toString() : null)")
    @Mapping(target = "idTeam", expression = "java(entity.getIdTeam() != null ? entity.getIdTeam().toString() : null)")
    ProjectTeamEntityMongo toProjectTeamEntityMongo(ProjectTeam entity);
}
