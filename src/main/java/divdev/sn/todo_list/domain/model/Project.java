package divdev.sn.todo_list.domain.model;

public class Project {

    private String id;
    private String name;
    private String description;
    private String idCreateur;

    public Project(String id, String name, String description, String idCreateur) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idCreateur = idCreateur;
    }

    public Project(){

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIdCreateur() {
        return idCreateur;
    }


    public void setId(String id) {
        this.id = id;
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
