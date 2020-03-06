package com.fexample.fhub.facade.exception;

public class UserServiceException extends Exception { 
    /**
     *
     */
    private static final long serialVersionUID = 6084803057791121593L;

    public UserServiceException(String errorMessage) {
        super(errorMessage);
    }
}