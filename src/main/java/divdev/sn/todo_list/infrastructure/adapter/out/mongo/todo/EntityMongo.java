package divdev.sn.todo_list.infrastructure.adapter.out.mongo.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import divdev.sn.todo_list.domain.model.Enum.Status;


@Document(collection = "todo")
public class EntityMongo {
    @Id
    private String id;
    private String idProject;
    private String title;
    private String description;
    private Status status;
    private String dateExp;
    private String idCreateur;

    public EntityMongo() {
    }

    public EntityMongo(String id, String idProject, String idCreateur, String title, String description, Status status, String dateExp) {
        this.id = id;
        this.idProject = idProject;
        this.idCreateur = idCreateur;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateExp = dateExp;
    }

    public String getId() {
        return id;
    }

    public String getIdProject() {
        return idProject;
    }

    public String getIdCreateur() {
        return idCreateur;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public String getDateExp() {
        return dateExp;
    }


    public void setIdCreateur(String idCreateur) {
        this.idCreateur = idCreateur;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }
}