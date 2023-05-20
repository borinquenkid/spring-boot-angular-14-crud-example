package com.bezkoder.spring.jpa.h2.model;

public class HourlyEmployee extends AEmployee {


    public HourlyEmployee() {
        vacationDays = 0f;
        vacationDaysPerYear = 10f;
    }


    @Override
    public void takeVacation(float vacationDays) {

    }
}
