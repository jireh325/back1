package divdev.sn.todo_list.infrastructure.adapter.out.jpa.team;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class TeamEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long idCreateur;

    public TeamEntityJpa(Long id, String name, Long idCreateur) {
        this.id = id;
        this.name = name;
        this.idCreateur = idCreateur;
    }

    public TeamEntityJpa() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setIdCreateur(Long idCreateur) {
        this.idCreateur = idCreateur;
    }
}
