package divdev.sn.todo_list.infrastructure.adapter.out.mongo.team;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team")
public class TeamEntityMongo {

    @Id
    private String id;
    private String name;
    private String idCreateur;

    public TeamEntityMongo(String id, String name, String idCreateur) {
        this.id = id;
        this.name = name;
        this.idCreateur = idCreateur;
    }

    public TeamEntityMongo() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setIdCreateur(String idCreateur) {
        this.idCreateur = idCreateur;
    }
}
