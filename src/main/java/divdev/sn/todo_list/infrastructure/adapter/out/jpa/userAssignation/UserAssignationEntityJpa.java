package divdev.sn.todo_list.infrastructure.adapter.out.jpa.userAssignation;

import jakarta.persistence.*;

@Entity
@Table(name = "userAssignations")
public class UserAssignationEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idTodo;

    @Column(nullable = false)
    private Long idUser;

    public UserAssignationEntityJpa(Long id, Long idTodo, Long idUser) {
        this.id = id;
        this.idTodo = idTodo;
        this.idUser = idUser;
    }

    public UserAssignationEntityJpa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTodo() {
        return idTodo;
    }

    public void setIdTodo(Long idTodo) {
        this.idTodo = idTodo;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
