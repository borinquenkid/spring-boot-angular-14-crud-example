package com.bezkoder.spring.jpa.h2.model;

public class SalariedEmployee implements IEmployee {


    private float vacationDays;
    private static final float VACATION_DAYS_PER_YEAR = 15f;
    public static final int MAX_WORK_DAYS_PER_YEAR = 260;

    public static final int MIN_WORK_DAYS_PER_YEAR = 0;


    public SalariedEmployee() {

        vacationDays = 0f;
    }

    @Override
    public float getVacationDays() {
        return vacationDays;
    }


    @Override
    public void work(int workDays) {
        if (workDays > MAX_WORK_DAYS_PER_YEAR) {
            throw new TooMuchWorkException();
        }
        if (workDays < MIN_WORK_DAYS_PER_YEAR) {
            throw new NegativeWorkException();
        }
        vacationDays+= (workDays / VACATION_DAYS_PER_YEAR);
        if (vacationDays > VACATION_DAYS_PER_YEAR) {
            vacationDays = VACATION_DAYS_PER_YEAR;
        }
    }

    @Override
    public void takeVacation(float vacationDays) {

    }
}
