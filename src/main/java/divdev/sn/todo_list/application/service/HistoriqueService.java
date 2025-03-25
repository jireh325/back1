
package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePortHistorique;
import divdev.sn.todo_list.application.port.out.HistoriqueRepository;
import divdev.sn.todo_list.domain.model.Historique;

import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class HistoriqueService implements UseCasePortHistorique {

    private final HistoriqueRepository historiqueRepository;

    public HistoriqueService(@Qualifier("HistoriqueMongoAdapter") HistoriqueRepository historiqueRepository) {
        this.historiqueRepository = historiqueRepository;
    }

    @Override
    public Historique create(Historique historique){
        return this.historiqueRepository.save(historique);
    }

    @Override
    public Optional<Historique> getOne(String id){
        return this.historiqueRepository.findById(id);
    }

    @Override
    public List<Historique> getAll(){
        return this.historiqueRepository.findAll();
    }

    @Override
    public void delete(String id){
        this.historiqueRepository.delete(id);
    }

    @Override
    public Historique update(String id, Historique historique){
        return this.historiqueRepository.update(id, historique);
    }

    @Override
    public List<Historique> getByIdUser(String idUser){
        return this.historiqueRepository.findByIdUser(idUser);
    }

    @Override
    public List<Historique> getByIdTodo(String idTodo){
        return this.historiqueRepository.findByIdTodo(idTodo);
    }
}
