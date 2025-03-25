package divdev.sn.todo_list.application.dto;

import divdev.sn.todo_list.domain.model.Enum.Status;

public class TodoDto {
    private String idProject;
    private String title;
    private String description;
    private Status status;
    private String dateExp;
    private String idCreateur;


    public String getIdCreateur() {
        return idCreateur;
    }

    public String getIdProject() {
        return idProject;
    }

    public String getDateExp() {
        return dateExp;
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
