package com.fexample.fhub.facade.exception.Service;

public class EntityNotExistsException extends RuntimeException{

    public EntityNotExistsException(String msg, Throwable cause) {

        super(msg, cause);
    }

    public EntityNotExistsException(String msg) {

        super(msg);
    }

    public EntityNotExistsException(Throwable cause) {

        super(cause);
    }
}
