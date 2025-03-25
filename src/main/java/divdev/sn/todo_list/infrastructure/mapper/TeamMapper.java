package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.infrastructure.adapter.out.jpa.team.TeamEntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.team.TeamEntityMongo;
import divdev.sn.todo_list.domain.model.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    Team fromJpatoModel(TeamEntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    Team fromMongotoModel(TeamEntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.valueOf(entity.getId()) : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null && !entity.getIdCreateur().isEmpty() ? Long.valueOf(entity.getIdCreateur()) : null)")
    TeamEntityJpa toTeamEntityJpa(Team entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idCreateur", expression = "java(entity.getIdCreateur() != null ? entity.getIdCreateur().toString() : null)")
    TeamEntityMongo toTeamEntityMongo(Team entity);
}
