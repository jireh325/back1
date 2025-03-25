package divdev.sn.todo_list.application.dto;
import divdev.sn.todo_list.domain.model.Enum.HistStatus;

public class HistoriqueDto {

    private String idTodo;
    private String idUser;
    private HistStatus status;


    public String getIdUser(){
        return idUser;
    }

    public String getIdTodo(){
        return idTodo;
    }


    public HistStatus getStatus(){
        return status;
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

}
