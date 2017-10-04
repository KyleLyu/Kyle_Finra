package com.kyle.demo.exception;

public class StorageException extends RuntimeException {

    public StorageException(String mess) {
        super(mess);
    }

    public StorageException(String mess, Throwable cause) {
        super(mess, cause);
    }
}