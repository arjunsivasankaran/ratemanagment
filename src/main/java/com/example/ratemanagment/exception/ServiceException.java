package com.example.ratemanagment.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceException(String exception) {
        super(exception);
    }
}
