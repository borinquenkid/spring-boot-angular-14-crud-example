package com.bezkoder.spring.jpa.h2.model;

public class SalariedEmployee implements IEmployee {


    public SalariedEmployee() {

    }
    @Override
    public float getVacationDays() {
        return 0f;
    }

    @Override
    public int getWorkDays() {
        return 0;
    }

    @Override
    public void work(int workDays) {

    }

    @Override
    public void takeVacation(float vacationDays) {

    }
}
