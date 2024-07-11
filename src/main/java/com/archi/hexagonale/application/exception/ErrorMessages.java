package com.archi.hexagonale.application.exception;
import java.util.Date;

public record ErrorMessages(int status , Date timestamp , String message){}