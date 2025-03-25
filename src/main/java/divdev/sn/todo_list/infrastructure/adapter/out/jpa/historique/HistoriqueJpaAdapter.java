package divdev.sn.todo_list.infrastructure.adapter.out.jpa.historique;

import divdev.sn.todo_list.application.port.out.HistoriqueRepository;
import divdev.sn.todo_list.domain.model.Historique;
import divdev.sn.todo_list.infrastructure.mapper.HistoriqueMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Repository("HistoriqueJpaAdapter")
public class HistoriqueJpaAdapter implements HistoriqueRepository {

    private final HistoriqueJpaRepository historiqueJpaRepository;
    private final HistoriqueMapper historiqueMapper;

    public HistoriqueJpaAdapter(HistoriqueJpaRepository historiqueJpaRepository, HistoriqueMapper historiqueMapper) {
        this.historiqueJpaRepository = historiqueJpaRepository;
        this.historiqueMapper = historiqueMapper;
    }

    @Override
    public Historique save(Historique historique) {
        HistoriqueEntityJpa entity = this.historiqueMapper.toHistoriqueEntityJpa(historique);
        return this.historiqueMapper.fromJpatoModel(this.historiqueJpaRepository.save(entity));
    }

    @Override
    public List<Historique> findAll() {
        return this.historiqueJpaRepository.findAll().stream()
            .map(this.historiqueMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Historique> findById(String id) {
        return this.historiqueJpaRepository.findById(Long.valueOf(id))
            .map(this.historiqueMapper::fromJpatoModel);
    }

    @Override
    public List<Historique> findByIdTodo(String idTodo) {
        return this.historiqueJpaRepository.findByIdTodo(Long.valueOf(idTodo)).stream()
            .map(this.historiqueMapper::fromJpatoModel)
            .collect(Collectors.toList());

    }

    @Override
    public List<Historique> findByIdUser(String idUser) {
        return this.historiqueJpaRepository.findByIdUser(Long.valueOf(idUser)).stream()
            .map(this.historiqueMapper::fromJpatoModel)
            .collect(Collectors.toList());
    }

    @Override
    public Historique update(String id, Historique historique) {
        HistoriqueEntityJpa historiqueExist = this.historiqueJpaRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new RuntimeException("Historique non trouvé avec l'ID : " + id));

        historiqueExist.setIdUser(this.historiqueMapper.toHistoriqueEntityJpa(historique).getIdUser());
        historiqueExist.setIdTodo(this.historiqueMapper.toHistoriqueEntityJpa(historique).getIdTodo());
        historiqueExist.setStatus(this.historiqueMapper.toHistoriqueEntityJpa(historique).getStatus());

        return this.historiqueMapper.fromJpatoModel(this.historiqueJpaRepository.save(historiqueExist));
    }

    @Override
    public void delete(String id) {
        this.historiqueJpaRepository.deleteById(Long.valueOf(id));
    }
}
