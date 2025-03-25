package divdev.sn.todo_list.infrastructure.adapter.out.mongo.userRight;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRightMongoRepository extends MongoRepository<UserRightEntityMongo, String>{

    List<UserRightEntityMongo> findByIdUser(String idUser);
    List<UserRightEntityMongo> findByIdProject(String idProject);
    Optional<UserRightEntityMongo> findByIdUserAndIdProject(String idUser, String idProject);
}
