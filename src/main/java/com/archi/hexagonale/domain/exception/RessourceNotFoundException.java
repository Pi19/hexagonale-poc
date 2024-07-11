package com.archi.hexagonale.domain.exception;


public class RessourceNotFoundException extends  RuntimeException{
    public RessourceNotFoundException(final String message) {
        super(message);
    }
}
