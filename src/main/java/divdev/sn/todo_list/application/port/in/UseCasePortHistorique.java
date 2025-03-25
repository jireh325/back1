
package divdev.sn.todo_list.application.port.in;
import java.util.List;
import java.util.Optional;

import divdev.sn.todo_list.domain.model.Historique;

public interface UseCasePortHistorique {

    Historique create(Historique historique);
    void delete(String id);
    List<Historique> getAll();
    Optional<Historique> getOne(String id);
    List<Historique> getByIdUser(String idUser);
    List<Historique> getByIdTodo(String idTodo);
    Historique update(String id, Historique historique);

}
