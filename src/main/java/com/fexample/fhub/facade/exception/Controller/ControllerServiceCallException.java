package com.fexample.fhub.facade.exception.Controller;

import java.util.function.Supplier;

public class ControllerServiceCallException extends RuntimeException {

    public ControllerServiceCallException(String msg, Throwable cause) {

        super(msg, cause);
    }

    public ControllerServiceCallException(String msg) {

        super(msg);
    }

    public ControllerServiceCallException(Throwable cause) {

        super(cause);
    }
}
