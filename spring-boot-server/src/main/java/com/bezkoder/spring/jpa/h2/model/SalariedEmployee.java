package com.bezkoder.spring.jpa.h2.model;

public class SalariedEmployee implements IEmployee {

    private float vacationDays;
    private final float vacationDaysPerYear;

    public SalariedEmployee() {
        vacationDays = 0f;
        vacationDaysPerYear = 15f;
    }

    @Override
    public float getVacationDays() {
        return vacationDays;
    }

    @Override
    public float getVacationDaysPerYear() {
        return vacationDaysPerYear;
    }


    @Override
    public void work(int workDays) {
        validate(workDays);
        vacationDays = calculateVacationDays(vacationDays, workDays);
    }


    @Override
    public void takeVacation(float vacationDays) {

    }
}
