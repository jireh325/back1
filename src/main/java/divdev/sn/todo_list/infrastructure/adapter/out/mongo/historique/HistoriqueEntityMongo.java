package divdev.sn.todo_list.infrastructure.adapter.out.mongo.historique;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;
import divdev.sn.todo_list.domain.model.Enum.HistStatus;


@Document(collection = "historique")
public class HistoriqueEntityMongo {

    @Id
    private String id;
    private String idUser;
    private String idTodo;
    private HistStatus status;

    @CreatedDate  // Gère automatiquement la date de création
    @LastModifiedDate
    @Field("createdAt")
    private LocalDateTime createdAt;

    public HistoriqueEntityMongo(String id, String idUser, String idTodo, HistStatus status) {
        this.id = id;
        this.idUser = idUser;
        this.idTodo = idTodo;
        this.status = status;
    }

    public HistoriqueEntityMongo() {
    }

    public String getId() {
        return id;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdTodo() {
        return idTodo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public HistStatus getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIdTodo(String idTodo) {
        this.idTodo = idTodo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(HistStatus status) {
        this.status = status;
    }
}
