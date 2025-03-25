package divdev.sn.todo_list.infrastructure.adapter.out.mongo.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.UserRepository;
import divdev.sn.todo_list.domain.model.User;
import divdev.sn.todo_list.infrastructure.mapper.UserMapper;

@Repository("UserMongoAdapter")
public class UserMongoAdapter implements UserRepository {

    private final UserMongoRepository userMongoRepository;
    private final UserMapper userMapper;

    public UserMongoAdapter(UserMongoRepository userMongoRepository, UserMapper userMapper) {
        this.userMongoRepository = userMongoRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntityMongo entity = this.userMapper.toUserEntityMongo(user);
        return this.userMapper.fromUserMongotoModel(this.userMongoRepository.save(entity));
    }

    @Override
    public List<User> findAll() {
        return this.userMongoRepository.findAll().stream()
            .map(this.userMapper::fromUserMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return this.userMongoRepository.findById(id).map(this.userMapper::fromUserMongotoModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.userMongoRepository.findByEmail(email).map(this.userMapper::fromUserMongotoModel);
    }

    @Override
    public User update(String id, User user) {
        UserEntityMongo existingUser = this.userMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPass(user.getPass());
        existingUser.setProfil(user.getProfil());

        return this.userMapper.fromUserMongotoModel(this.userMongoRepository.save(existingUser));
    }

    @Override
    public void delete(String id) {
        this.userMongoRepository.deleteById(id);
    }
}
