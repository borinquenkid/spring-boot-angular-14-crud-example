package com.bezkoder.spring.jpa.h2.model;

public class ManagerEmployee extends SalariedEmployee {

    public ManagerEmployee() {
        vacationDays = 0f;
        vacationDaysPerYear = 30f;
    }

    @Override
    public void takeVacation(float vacationDays) {

    }
}
