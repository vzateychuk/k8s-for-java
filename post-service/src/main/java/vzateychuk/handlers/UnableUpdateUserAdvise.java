package vzateychuk.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import vzateychuk.exceptions.UnableUpdateUserException;

@ControllerAdvice
public class UnableUpdateUserAdvise {
    @ResponseBody
    @ExceptionHandler(UnableUpdateUserException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String updateUserExceptionHandler(UnableUpdateUserException ex) {
            return ex.getMessage();
    }
}
