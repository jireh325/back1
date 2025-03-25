package divdev.sn.todo_list.infrastructure.adapter.out.mongo.project;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMongoRepository extends MongoRepository<ProjectEntityMongo, String> {

    List<ProjectEntityMongo> findByIdCreateur(String idCreateur);

}
