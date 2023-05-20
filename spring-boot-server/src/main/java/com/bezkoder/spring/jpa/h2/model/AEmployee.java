package com.bezkoder.spring.jpa.h2.model;

abstract class AEmployee implements  IEmployee{

    protected float vacationDays;
    protected float vacationDaysPerYear;

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
        vacationDays = calculateVacationDays(getVacationDays(), workDays);
    }
}
