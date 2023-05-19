package com.bezkoder.spring.jpa.h2.model;

public class TooMuchWorkException extends RuntimeException {

    private static final String TOO_MUCH_WORK_MESSAGE = "You are working too much";

    public TooMuchWorkException() {
        super(TOO_MUCH_WORK_MESSAGE);
    }
}
