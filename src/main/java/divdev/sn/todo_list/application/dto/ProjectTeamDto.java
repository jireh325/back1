package divdev.sn.todo_list.application.dto;
import divdev.sn.todo_list.domain.model.Enum.Status;

public class ProjectTeamDto {

    private String idTeam;
    private String idProject;
    private Status status;



    public String getIdTeam(){
        return idTeam;
    }

    public String getIdProject(){
        return idProject;
    }


    public Status getStatus(){
        return status;
    }

    public void setIdTeam( String idTeam){
        this.idTeam = idTeam;
    }

    public void setIdProject( String idProject){
        this.idProject = idProject;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
