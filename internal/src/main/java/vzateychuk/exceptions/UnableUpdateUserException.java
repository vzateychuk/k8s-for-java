package vzateychuk.exceptions;

public class UnableUpdateUserException extends RuntimeException{
    public UnableUpdateUserException(String message) {
        super(message);
    }
}
