package divdev.sn.todo_list.application.dto;

public class TeamDto {

    private String name;
    private String idCreateur;

    public String getName(){
        return name;
    }

    public String getIdCreateur(){
        return idCreateur;
    }

    public void setName( String name){
        this.name = name;
    }

    public void setIdCreateur(String idCreateur){
        this.idCreateur = idCreateur;
    }


}
