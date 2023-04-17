package vzateychuk.exceptions;

public class NotFoundEntityException extends RuntimeException{
    public NotFoundEntityException(String s) {
        super(s);
    }
}
