package com.fexample.fhub.facade.exception;

import org.springframework.security.core.AuthenticationException;


public class JwtAuthenticationException extends AuthenticationException {
    /**
     *
     */
    private static final long serialVersionUID = -6426395063089824165L;

    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}