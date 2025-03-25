package divdev.sn.todo_list.infrastructure.adapter.out.mongo.team;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMongoRepository extends MongoRepository<TeamEntityMongo, String> {
}
