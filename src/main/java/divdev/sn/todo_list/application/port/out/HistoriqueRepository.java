package divdev.sn.todo_list.application.port.out;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Historique;

public interface HistoriqueRepository {

    Historique save(Historique historique);
    Optional<Historique> findById(String id);
    List<Historique> findAll();
    List<Historique> findByIdUser(String idUser);
    List<Historique> findByIdTodo(String idTodo);
    Historique update(String id, Historique historique);
    void delete(String id);
}
