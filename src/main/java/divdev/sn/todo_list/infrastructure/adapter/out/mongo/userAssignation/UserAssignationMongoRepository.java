package divdev.sn.todo_list.infrastructure.adapter.out.mongo.userAssignation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserAssignationMongoRepository extends MongoRepository<UserAssignationEntityMongo, String> {
    List<UserAssignationEntityMongo> findByIdTodo(String idTodo);
    List<UserAssignationEntityMongo> findByIdUser(String idUser);
    Optional<UserAssignationEntityMongo> findByIdTodoAndIdUser(String idTodo, String idUser);
}
