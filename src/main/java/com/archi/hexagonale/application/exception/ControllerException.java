package com.archi.hexagonale.application.exception;

import com.archi.hexagonale.domain.exception.OperationNotAllowedException;
import com.archi.hexagonale.domain.exception.RessourceNotFoundException;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

    private Problem buildProblem(Exception ex, HttpStatus status) {
        return Problem.create().withStatus(status).withDetail(ex.getMessage());
    }


    @ExceptionHandler(value = RessourceNotFoundException.class)
    public ResponseEntity<Problem> handleRessourceNotFoundException(RessourceNotFoundException exception){
        return new ResponseEntity<>(buildProblem(exception, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OperationNotAllowedException.class)
    public ResponseEntity<Problem> handleOperationNotAllowed(OperationNotAllowedException exception){
        return new ResponseEntity<>(buildProblem(exception, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Problem> handleBadParameter(BadRequestException exception){
        return new ResponseEntity<>(buildProblem(exception, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
