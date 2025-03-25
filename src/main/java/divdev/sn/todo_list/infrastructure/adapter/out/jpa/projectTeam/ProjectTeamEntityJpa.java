package divdev.sn.todo_list.infrastructure.adapter.out.jpa.projectTeam;

import divdev.sn.todo_list.domain.model.Enum.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projectTeam")
public class ProjectTeamEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idTeam;

    private Long idProject;

    @Enumerated(EnumType.STRING)
    private Status status;

    public ProjectTeamEntityJpa(Long id, Long idTeam, Long idProject, Status status) {
        this.id = id;
        this.idTeam = idTeam;
        this.idProject = idProject;
        this.status = status;
    }

    public ProjectTeamEntityJpa() {
    }

    public Long getId() {
        return id;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public Long getIdProject() {
        return idProject;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
