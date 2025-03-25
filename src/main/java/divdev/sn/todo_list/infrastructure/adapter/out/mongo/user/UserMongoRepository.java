package divdev.sn.todo_list.infrastructure.adapter.out.mongo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserMongoRepository extends MongoRepository<UserEntityMongo, String> {
    Optional<UserEntityMongo> findByEmail(String email);
}
