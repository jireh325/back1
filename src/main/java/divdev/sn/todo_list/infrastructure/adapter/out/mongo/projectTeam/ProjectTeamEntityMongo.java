package divdev.sn.todo_list.infrastructure.adapter.out.mongo.projectTeam;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import divdev.sn.todo_list.domain.model.Enum.Status;

@Document(collection = "projectTeam")
public class ProjectTeamEntityMongo {

    @Id
    private String id;
    private String idTeam;
    private String idProject;
    private Status status;

    public ProjectTeamEntityMongo(String id, String idTeam, String idProject, Status status) {
        this.id = id;
        this.idTeam = idTeam;
        this.idProject = idProject;
        this.status = status;
    }

    public ProjectTeamEntityMongo() {
    }

    public String getId() {
        return id;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getIdProject() {
        return idProject;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
