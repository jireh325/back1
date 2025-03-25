package divdev.sn.todo_list.infrastructure.adapter.out.jpa.todo;
import divdev.sn.todo_list.domain.model.Enum.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class EntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProject;
    private String title;
    private String description;
    private Status status;
    private String dateExp;
    private Long idCreateur;

    public EntityJpa() {
    }

    public EntityJpa(Long id, Long idProject, Long idCreateur, String title, String description, Status status, String dateExp) {
        this.id = id;
        this.idProject = idProject;
        this.idCreateur = idCreateur;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateExp = dateExp;
    }

    public Long getId() {
        return id;
    }

    public Long getIdProject() {
        return idProject;
    }

    public Long getIdCreateur() {
        return idCreateur;
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


    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdCreateur(Long idCreateur) {
        this.idCreateur = idCreateur;
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
