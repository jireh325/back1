package divdev.sn.todo_list.infrastructure.adapter.out.mongo.projectTeam;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTeamMongoRepository extends MongoRepository<ProjectTeamEntityMongo, String> {
}
