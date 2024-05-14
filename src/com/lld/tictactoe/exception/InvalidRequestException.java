package com.lld.tictactoe.exception;

public class InvalidRequestException extends Exception{
    public InvalidRequestException(String message){
        super(message);
    }
}
