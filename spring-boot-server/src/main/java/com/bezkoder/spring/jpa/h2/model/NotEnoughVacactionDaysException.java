package com.bezkoder.spring.jpa.h2.model;

public class NotEnoughVacactionDaysException extends RuntimeException {

    public NotEnoughVacactionDaysException() {
        super("You have not worked enough days");
    }
}
