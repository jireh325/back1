package divdev.sn.todo_list.infrastructure.adapter.out.mongo.userAssignation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userAssignations")
public class UserAssignationEntityMongo {

    @Id
    private String id;
    private String idTodo;
    private String idUser;

    public UserAssignationEntityMongo(String id, String idTodo, String idUser) {
        this.id = id;
        this.idTodo = idTodo;
        this.idUser = idUser;
    }

    public UserAssignationEntityMongo() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTodo() {
        return idTodo;
    }

    public void setIdTodo(String idTodo) {
        this.idTodo = idTodo;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
