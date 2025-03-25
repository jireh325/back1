package divdev.sn.todo_list.domain.model;
import divdev.sn.todo_list.domain.model.Enum.Status;

public class ProjectTeam {

    private String id;
    private String idTeam;
    private String idProject;
    private Status status;

    public ProjectTeam(String id, String idTeam, String idProject, Status status){
        this.id = id;
        this.idTeam = idTeam;
        this.status = status;
        this.idProject = idProject;
    }

    public ProjectTeam(){

    }

    public String getId(){
        return id;
    }

    public String getIdTeam(){
        return idTeam;
    }

    public String getIdProject(){
        return idProject;
    }


    public Status getStatus(){
        return status;
    }

    public void setId(String id){
        this.id = id;
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
