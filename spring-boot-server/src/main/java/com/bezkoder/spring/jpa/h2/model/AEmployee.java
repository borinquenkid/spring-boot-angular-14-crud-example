package com.bezkoder.spring.jpa.h2.model;

abstract class AEmployee implements IEmployee {

    protected float vacationDays;
    protected float vacationDaysPerYear;

    protected float vacationRate;

    @Override
    public float getVacationDays() {
        return vacationDays;
    }

    @Override
    public float getVacationDaysPerYear() {
        return vacationDaysPerYear;
    }

    public float getVacationRate() {
        return vacationDaysPerYear / MAX_WORK_DAYS_PER_YEAR;
    }

    @Override
    public void work(int workDays) {
        validate(workDays);
        vacationDays = calculateVacationDays(getVacationDays(), workDays);
    }
}
