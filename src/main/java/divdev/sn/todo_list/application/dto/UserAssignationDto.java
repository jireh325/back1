package divdev.sn.todo_list.application.dto;

public class UserAssignationDto {

    private String idTodo;
    private String idUser;



    public String getIdTodo(){
        return idTodo;
    }


    public String getIdUser(){
        return idUser;
    }

    public void setIdTodo( String idTodo){
        this.idTodo = idTodo;
    }

    public void setIdUser(String idUser){
        this.idUser = idUser;
    }
}
