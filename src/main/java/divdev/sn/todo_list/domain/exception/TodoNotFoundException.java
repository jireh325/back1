package divdev.sn.todo_list.domain.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String message){
        
        super(message);
    }
}
