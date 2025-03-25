package divdev.sn.todo_list.infrastructure.adapter.out.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntityJpa, Long> {
    Optional<UserEntityJpa> findByEmail(String email);
}
