package divdev.sn.todo_list.application.dto;

public class LoginDto {

    private String email;
    private String pass;


    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}