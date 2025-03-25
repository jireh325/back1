package divdev.sn.todo_list.domain.model;

public class Team {

    private String id;
    private String name;
    private String idCreateur;

    public Team(String id, String name, String idCreateur){
        this.id = id;
        this.name = name;
        this.idCreateur = idCreateur;
    }

    public Team(){

    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    public String getIdCreateur(){
        return idCreateur;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName( String name){
        this.name = name;
    }

    public void setIdCreateur(String idCreateur){
        this.idCreateur = idCreateur;
    }


}
