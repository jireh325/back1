package divdev.sn.todo_list.domain.model;
import divdev.sn.todo_list.domain.model.Enum.HistStatus;


public class Historique {

    private String id;
    private String idUser;
    private String idTodo;
    private HistStatus status;
    private String createdAt;

    public Historique(String id, String idUser, String idTodo, HistStatus status){
        this.id = id;
        this.idUser = idUser;
        this.idTodo = idTodo;
        this.status = status;

    }

    public Historique(){

    }

    public String getId(){
        return id;
    }

    public String getIdUser(){
        return idUser;
    }

    public String getIdTodo(){
        return idTodo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public HistStatus getStatus(){
        return status;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }

    public void setIdTodo( String idTodo){
        this.idTodo = idTodo;
    }

    public void setStatus(HistStatus status){
        this.status = status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}