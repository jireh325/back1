package divdev.sn.todo_list.domain.model;

public class UserAssignation {

    private String id;
    private String idTodo;
    private String idUser;

    public UserAssignation(String id, String idTodo, String idUser){
        this.id = id;
        this.idTodo = idTodo;
        this.idUser = idUser;
    }

    public UserAssignation(){

    }

    public String getId(){
        return id;
    }

    public String getIdTodo(){
        return idTodo;
    }


    public String getIdUser(){
        return idUser;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setIdTodo( String idTodo){
        this.idTodo = idTodo;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }
}
