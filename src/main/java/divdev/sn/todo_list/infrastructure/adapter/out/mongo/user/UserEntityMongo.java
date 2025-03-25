package divdev.sn.todo_list.infrastructure.adapter.out.mongo.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserEntityMongo {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String pass;
    String profil;

    public UserEntityMongo(String id, String firstName, String lastName, String email, String pass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
    }

    public UserEntityMongo(String id, String firstName, String lastName, String email, String pass, String profil) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.profil = profil;
    }


    public UserEntityMongo() {
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getProfil() {
        return profil;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
