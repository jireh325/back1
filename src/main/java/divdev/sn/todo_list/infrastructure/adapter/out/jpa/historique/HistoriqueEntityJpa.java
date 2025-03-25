package divdev.sn.todo_list.infrastructure.adapter.out.jpa.historique;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import divdev.sn.todo_list.domain.model.Enum.HistStatus;
import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "historique")
@EntityListeners(AuditingEntityListener.class)
public class HistoriqueEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private Long idTodo;
    private HistStatus status;

    @CreatedDate  // Gère automatiquement la date de création
    private LocalDateTime createdAt;

    public HistoriqueEntityJpa(Long id, Long idUser, Long idTodo, HistStatus status) {
        this.id = id;
        this.idUser = idUser;
        this.idTodo = idTodo;
        this.status = status;
    }

    public HistoriqueEntityJpa() {
    }

    public Long getId() {
        return id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdTodo() {
        return idTodo;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public HistStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setIdTodo(Long idTodo) {
        this.idTodo = idTodo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(HistStatus status) {
        this.status = status;
    }
}
