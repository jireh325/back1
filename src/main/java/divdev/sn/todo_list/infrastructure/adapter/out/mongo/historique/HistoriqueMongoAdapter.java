package divdev.sn.todo_list.infrastructure.adapter.out.mongo.historique;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import divdev.sn.todo_list.application.port.out.HistoriqueRepository;
import divdev.sn.todo_list.domain.model.Historique;
import divdev.sn.todo_list.infrastructure.mapper.HistoriqueMapper;

@Repository("HistoriqueMongoAdapter")
public class HistoriqueMongoAdapter implements HistoriqueRepository {

    private final HistoriqueMongoRepository historiqueMongoRepository;
    private final HistoriqueMapper historiqueMapper;

    public HistoriqueMongoAdapter(HistoriqueMongoRepository historiqueMongoRepository, HistoriqueMapper historiqueMapper) {
        this.historiqueMongoRepository = historiqueMongoRepository;
        this.historiqueMapper = historiqueMapper;
    }

    @Override
    public Historique save(Historique historique) {
        HistoriqueEntityMongo entityHistorique = this.historiqueMapper.toHistoriqueEntityMongo(historique);
        return this.historiqueMapper.fromMongotoModel(this.historiqueMongoRepository.save(entityHistorique));
    }

    @Override
    public List<Historique> findAll() {
        return this.historiqueMongoRepository.findAll().stream()
            .map(this.historiqueMapper::fromMongotoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Historique> findById(String id) {
        return this.historiqueMongoRepository.findById(id).map(this.historiqueMapper::fromMongotoModel);
    }

    @Override
    public List<Historique> findByIdTodo(String idTodo) {
        return this.historiqueMongoRepository.findByIdTodo(idTodo).stream()
        .map(this.historiqueMapper::fromMongotoModel)
        .collect(Collectors.toList());
    }

    @Override
    public List<Historique> findByIdUser(String idUser) {
        return this.historiqueMongoRepository.findByIdUser(idUser).stream()
            .map(this.historiqueMapper::fromMongotoModel)
            .collect(Collectors.toList());

    }

    @Override
    public Historique update(String id, Historique historique) {
        HistoriqueEntityMongo historiqueExist = this.historiqueMongoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Historique non trouvé avec l'ID : " + id));

        HistoriqueEntityMongo updatedHistorique = this.historiqueMapper.toHistoriqueEntityMongo(historique);

        historiqueExist.setIdUser(updatedHistorique.getIdUser());
        historiqueExist.setIdTodo(updatedHistorique.getIdTodo());
        historiqueExist.setStatus(updatedHistorique.getStatus());

        return this.historiqueMapper.fromMongotoModel(this.historiqueMongoRepository.save(historiqueExist));
    }

    @Override
    public void delete(String id) {
        this.historiqueMongoRepository.deleteById(id);
    }
}
