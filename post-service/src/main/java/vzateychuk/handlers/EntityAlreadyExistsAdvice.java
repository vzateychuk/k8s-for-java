package vzateychuk.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import vzateychuk.exceptions.EntityAlreadyExistsException;

@ControllerAdvice
public class EntityAlreadyExistsAdvice {

    @ResponseBody
    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String alreadyExistsHandler(EntityAlreadyExistsException ex) {
        return ex.getMessage();
    }

}
