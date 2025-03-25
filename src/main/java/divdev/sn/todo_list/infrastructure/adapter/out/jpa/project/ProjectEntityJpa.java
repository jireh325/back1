package divdev.sn.todo_list.infrastructure.adapter.out.jpa.project;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "project")
public class ProjectEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long idCreateur;

    public ProjectEntityJpa(Long id, String name, String description, Long idCreateur) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idCreateur = idCreateur;
    }

    public ProjectEntityJpa(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdCreateur() {
        return idCreateur;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdCreateur( Long idCreateur) {
        this.idCreateur = idCreateur;
    }

}
