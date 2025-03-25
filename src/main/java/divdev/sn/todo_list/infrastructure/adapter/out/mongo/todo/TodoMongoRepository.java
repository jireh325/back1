package divdev.sn.todo_list.infrastructure.adapter.out.mongo.todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository("TodoMongoRepository")
public interface TodoMongoRepository extends MongoRepository<EntityMongo, String>{

    List<EntityMongo> findByIdCreateur(String idCreateur);
    List<EntityMongo> findByIdProject(String idProject);
}
