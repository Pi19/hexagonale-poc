package com.archi.hexagonale.application.exception;

import com.archi.hexagonale.domain.exception.OperationNotAllowedException;
import com.archi.hexagonale.domain.exception.RessourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerException {

    private ErrorMessages buildProblem(Exception ex, HttpStatus status) {
        return new ErrorMessages(status.value() , new Date() , ex.getMessage());
    }


    @ExceptionHandler(value = RessourceNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleRessourceNotFoundException(RessourceNotFoundException exception){
        return new ResponseEntity<>(buildProblem(exception, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OperationNotAllowedException.class)
    public ResponseEntity<ErrorMessages> handleOperationNotAllowed(OperationNotAllowedException exception){
        return new ResponseEntity<>(buildProblem(exception, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorMessages> handleBadParameter(BadRequestException exception){
        return new ResponseEntity<>(buildProblem(exception, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
