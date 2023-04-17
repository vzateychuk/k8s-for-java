package vzateychuk.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import vzateychuk.exceptions.NotFoundEntityException;

/**
 * When an NotFoundEntityException is thrown, this extra of Spring MVC configuration is used to render an HTTP 404
 * */
@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundEntityException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundHandler(NotFoundEntityException ex) {
        return ex.getMessage();
    }

}
