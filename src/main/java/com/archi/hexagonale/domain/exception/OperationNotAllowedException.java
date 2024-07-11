package com.archi.hexagonale.domain.exception;

public class OperationNotAllowedException extends RuntimeException{
    public OperationNotAllowedException(final String message) {
        super(message);
    }
}
