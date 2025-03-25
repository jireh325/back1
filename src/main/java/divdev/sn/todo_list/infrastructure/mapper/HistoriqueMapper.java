package divdev.sn.todo_list.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import divdev.sn.todo_list.infrastructure.adapter.out.jpa.historique.HistoriqueEntityJpa;
import divdev.sn.todo_list.infrastructure.adapter.out.mongo.historique.HistoriqueEntityMongo;
import divdev.sn.todo_list.domain.model.Historique;

@Mapper(componentModel = "spring")
public interface HistoriqueMapper {

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idTodo", expression = "java(entity.getIdTodo() != null ? entity.getIdTodo().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    Historique fromJpatoModel(HistoriqueEntityJpa entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idTodo", expression = "java(entity.getIdTodo() != null ? entity.getIdTodo().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    Historique fromMongotoModel(HistoriqueEntityMongo entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null && !entity.getId().isEmpty() ? Long.valueOf(entity.getId()) : null)")
    @Mapping(target = "idTodo", expression = "java(entity.getIdTodo() != null && !entity.getIdTodo().isEmpty() ? Long.valueOf(entity.getIdTodo()) : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null && !entity.getIdUser().isEmpty() ? Long.valueOf(entity.getIdUser()) : null)")
    HistoriqueEntityJpa toHistoriqueEntityJpa(Historique entity);

    @Mapping(target = "id", expression = "java(entity.getId() != null ? entity.getId().toString() : null)")
    @Mapping(target = "idTodo", expression = "java(entity.getIdTodo() != null ? entity.getIdTodo().toString() : null)")
    @Mapping(target = "idUser", expression = "java(entity.getIdUser() != null ? entity.getIdUser().toString() : null)")
    HistoriqueEntityMongo toHistoriqueEntityMongo(Historique entity);
}
