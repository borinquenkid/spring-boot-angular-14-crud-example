package com.bezkoder.spring.jpa.h2.model;

public class NegativeWorkException extends RuntimeException{

    public static final String NEGATIVE_WORK_MESSAGE = "You can not work negative days";

    public NegativeWorkException() {
        super(NEGATIVE_WORK_MESSAGE);
    }

}
