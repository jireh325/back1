package divdev.sn.todo_list.application.dto;

public class ProjectDto {

    private String name;
    private String description;
    private String idCreateur;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIdCreateur() {
        return idCreateur;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdCreateur( String idCreateur) {
        this.idCreateur = idCreateur;
    }

}
