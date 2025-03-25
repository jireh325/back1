package divdev.sn.todo_list.infrastructure.adapter.out.jpa.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.UserRepository;
import divdev.sn.todo_list.domain.model.User;
import divdev.sn.todo_list.infrastructure.mapper.UserMapper;

@Primary
@Repository("UserJpaAdapter")
public class UserJpaAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    public UserJpaAdapter(UserJpaRepository userJpaRepository, UserMapper userMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntityJpa entity = this.userMapper.toUserEntityJpa(user);
        return this.userMapper.fromUserJpatoModel(this.userJpaRepository.save(entity));
    }

    @Override
    public List<User> findAll() {
        return this.userJpaRepository.findAll().stream()
            .map(this.userMapper::fromUserJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return this.userJpaRepository.findById(Long.valueOf(id)).map(this.userMapper::fromUserJpatoModel);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.userJpaRepository.findByEmail(email).map(this.userMapper::fromUserJpatoModel);
    }

    @Override
    public User update(String id, User user) {
        UserEntityJpa existingUser = this.userJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPass(user.getPass());
        existingUser.setProfil(user.getProfil());


        return this.userMapper.fromUserJpatoModel(this.userJpaRepository.save(existingUser));
    }

    @Override
    public void delete(String id) {
        this.userJpaRepository.deleteById(Long.valueOf(id));
    }
}
