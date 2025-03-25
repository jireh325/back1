package divdev.sn.todo_list.infrastructure.adapter.out.mongo.userRight;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userRight")
public class UserRightEntityMongo {

    @Id
    private String id;
    private String idUser;
    private String idProject;
    private boolean isAdmin;

    public UserRightEntityMongo(String id, String idUser, String idProject, boolean isAdmin){

        this.id = id;
        this.idUser = idUser;
        this.idProject = idProject;
        this.isAdmin = isAdmin;
    }

    public UserRightEntityMongo(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}

