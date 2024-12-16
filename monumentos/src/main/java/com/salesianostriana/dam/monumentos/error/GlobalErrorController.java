package com.salesianostriana.dam.monumentos.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonumentoNotFoundException.class)
    public ProblemDetail handleMonumentoNotFound(MonumentoNotFoundException ex){
        ProblemDetail result  = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Monumento no encontrado");
        result.setProperty("Author", "Francisco José");

        return result;
    }


}
