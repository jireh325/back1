package divdev.sn.todo_list.infrastructure.response;
import divdev.sn.todo_list.domain.model.User;

public class LoginResponse {
    private String token;
    private long expiresIn;
    private User user;


    public LoginResponse(String token, long expiresIn, User user){
        this.token = token;
        this.expiresIn = expiresIn;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public long getExpiresIn(){
        return expiresIn;
    }

    public User getUser(){
        return user;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setExpiresIn(long expiresIn){
        this.expiresIn = expiresIn;
    }

    public void setUser(User user){
        this.user = user;
    }
}