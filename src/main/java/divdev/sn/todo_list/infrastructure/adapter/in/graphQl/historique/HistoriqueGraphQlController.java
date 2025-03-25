package divdev.sn.todo_list.infrastructure.adapter.in.graphQl.historique;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import divdev.sn.todo_list.application.port.in.UseCasePortHistorique;
import divdev.sn.todo_list.domain.model.Historique;
import divdev.sn.todo_list.application.dto.HistoriqueDto;

@Controller
public class HistoriqueGraphQlController {

    private final UseCasePortHistorique useCasePortHistorique;

    public HistoriqueGraphQlController(UseCasePortHistorique useCasePortHistorique) {
        this.useCasePortHistorique = useCasePortHistorique;
    }

    @QueryMapping(name = "getAllHistoriques")
    public List<Historique> getAll() {
        return useCasePortHistorique.getAll();
    }

    @QueryMapping(name = "getOneHistorique")
    public Optional<Historique> getOne(@Argument String id) {
        return useCasePortHistorique.getOne(id);
    }

    @QueryMapping(name = "getHistoriqueByIdUser")
    public List<Historique> getByIdUser(@Argument String idUser) {
        return useCasePortHistorique.getByIdUser(idUser);
    }

    @QueryMapping(name = "getHistoriqueByIdTodo")
    public List<Historique> getByIdTodo(@Argument String id) {
        return useCasePortHistorique.getByIdTodo(id);
    }

    @MutationMapping(name = "createHistorique")
    public Historique create(@Argument("historiqueInput") HistoriqueDto historiqueDto) {
        Historique historique = new Historique();
        historique.setIdUser(historiqueDto.getIdUser());
        historique.setIdTodo(historiqueDto.getIdTodo());
        historique.setStatus(historiqueDto.getStatus());
        return useCasePortHistorique.create(historique);
    }

    @MutationMapping(name = "updateHistorique")
    public Historique update(@Argument String id, @Argument("historiqueInput") HistoriqueDto historiqueDto) {
        Historique historique = new Historique();
        historique.setIdUser(historiqueDto.getIdUser());
        historique.setIdTodo(historiqueDto.getIdTodo());
        historique.setStatus(historiqueDto.getStatus());
        return useCasePortHistorique.update(id, historique);
    }

    @MutationMapping(name = "deleteHistorique")
    public void delete(@Argument String id) {
        useCasePortHistorique.delete(id);
    }
}
