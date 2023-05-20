package com.bezkoder.spring.jpa.h2.model;

public class SalariedEmployee extends AEmployee {


    public SalariedEmployee() {
        vacationDays = 0f;
        vacationDaysPerYear = 15f;
    }


    @Override
    public void takeVacation(float vacationDays) {

    }
}
