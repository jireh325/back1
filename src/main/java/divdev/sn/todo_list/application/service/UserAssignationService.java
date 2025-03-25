package divdev.sn.todo_list.application.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import divdev.sn.todo_list.application.port.in.UseCasePortUserAssignation;
import divdev.sn.todo_list.application.port.out.UserAssignationRepository;
import divdev.sn.todo_list.domain.model.Historique;
import divdev.sn.todo_list.domain.model.UserAssignation;
import divdev.sn.todo_list.domain.model.Enum.HistStatus;

import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class UserAssignationService implements UseCasePortUserAssignation {

    private final UserAssignationRepository userAssignationRepository;
    private final HistoriqueService historiqueService;

    public UserAssignationService(@Qualifier("UserAssignationMongoAdapter") UserAssignationRepository userAssignationRepository, HistoriqueService historiqueService) {
        this.userAssignationRepository = userAssignationRepository;
        this.historiqueService = historiqueService;
       
    }

    @Override
    public UserAssignation create(UserAssignation userAssignation){
        UserAssignation createdAssignation = this.userAssignationRepository.save(userAssignation);

        // Vérifier si la tâche était déjà assignée à cet utilisateur
        Optional<UserAssignation> existingAssignation = this.userAssignationRepository.findByIdTodoAndIdUser(
            userAssignation.getIdTodo(),
            userAssignation.getIdUser()
        );

        HistStatus status = existingAssignation.isPresent() ? HistStatus.reassigned : HistStatus.assigned;

        // Ajout d'un historique
        historiqueService.create(new Historique(
            null,
            userAssignation.getIdUser(),
            userAssignation.getIdTodo(),
            status
        ));

        return createdAssignation;
    }

    @Override
    public Optional<UserAssignation> getOne(String id){
        return this.userAssignationRepository.findById(id);
    }

    @Override
    public List<UserAssignation> getByIdTodo(String idTodo){
        return this.userAssignationRepository.findByIdTodo(idTodo);
    }
    
    @Override
    public Optional<UserAssignation> getByIdTodoAndIdUser(String idTodo, String idUser){
        return this.userAssignationRepository.findByIdTodoAndIdUser(idTodo, idUser);
    }
    
    @Override
    public List<UserAssignation> getByIdUser(String idUser){
        return this.userAssignationRepository.findByIdUser(idUser);
    }

    @Override
    public List<UserAssignation> getAll(){
        return this.userAssignationRepository.findAll();
    }

    @Override
    public void delete(String id){
        this.userAssignationRepository.delete(id);
    }

    @Override
    public UserAssignation update(String id, UserAssignation userAssignation){
        return this.userAssignationRepository.update(id, userAssignation);
    }
}
