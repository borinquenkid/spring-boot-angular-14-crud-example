package com.bezkoder.spring.jpa.h2.model;

public class SalariedEmployee implements IEmployee {


    private float vacationDays;
    private float vacationDaysPerYear = 15f;

    public SalariedEmployee() {

        vacationDays = 0f;
    }

    @Override
    public float getVacationDays() {
        return vacationDays;
    }


    @Override
    public void work(int workDays) {
        vacationDays+= (workDays / vacationDaysPerYear);
    }

    @Override
    public void takeVacation(float vacationDays) {

    }
}
