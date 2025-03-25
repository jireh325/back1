package divdev.sn.todo_list.infrastructure.adapter.out.jpa.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String pass;

    private String profil;


    public UserEntityJpa(Long id, String firstName, String lastName, String email, String pass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
    }

    public UserEntityJpa(Long id, String firstName, String lastName, String email, String pass, String profil) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.profil = profil;
    }

    public UserEntityJpa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getProfil() {
        return profil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }
}
