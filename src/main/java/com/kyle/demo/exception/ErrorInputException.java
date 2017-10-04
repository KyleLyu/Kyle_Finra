package com.kyle.demo.exception;

public class ErrorInputException extends StorageException{

    public ErrorInputException(String mess) {
        super(mess);
    }

    public ErrorInputException(String mess, Throwable cause) {
        super(mess, cause);
    }

}