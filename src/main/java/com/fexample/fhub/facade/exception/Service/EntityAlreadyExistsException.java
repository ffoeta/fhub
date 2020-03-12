package com.fexample.fhub.facade.exception.Service;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String msg, Throwable cause) {

        super(msg, cause);
    }

    public EntityAlreadyExistsException(String msg) {

        super(msg);
    }

    public EntityAlreadyExistsException(Throwable cause) {

        super(cause);
    }
}
