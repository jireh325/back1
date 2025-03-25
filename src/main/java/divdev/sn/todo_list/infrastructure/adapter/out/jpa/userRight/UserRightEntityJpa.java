package divdev.sn.todo_list.infrastructure.adapter.out.jpa.userRight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userRight")
public class UserRightEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private Long idProject;
    private boolean isAdmin;

    public UserRightEntityJpa(Long id, Long idUser, Long idProject, boolean isAdmin){

        this.id = id;
        this.idUser = idUser;
        this.idProject = idProject;
        this.isAdmin = isAdmin;
    }

    public UserRightEntityJpa(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}

