package ma.wiebatouta.controllers;

import ma.wiebatouta.exceptions.DataEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(DataEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String dataEmptyExceptionHandler(DataEmptyException e){
        return e.getMessage();
    }
}
