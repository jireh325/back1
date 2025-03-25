package divdev.sn.todo_list.infrastructure.adapter.out.jpa.historique;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueJpaRepository extends JpaRepository<HistoriqueEntityJpa, Long> {
    List<HistoriqueEntityJpa> findByIdUser(Long idUser);
    List<HistoriqueEntityJpa> findByIdTodo(Long idTodo);
}
