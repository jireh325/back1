package divdev.sn.todo_list.infrastructure.adapter.out.mongo.historique;
import divdev.sn.todo_list.domain.model.Historique;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueMongoRepository extends MongoRepository<HistoriqueEntityMongo, String> {

    List<HistoriqueEntityMongo> findByIdUser(String idUser);
    List<HistoriqueEntityMongo> findByIdTodo(String idTodo);
}
