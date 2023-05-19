package com.bezkoder.spring.jpa.h2.model;

public interface IEmployee {

    float getVacationDays();

    int getWorkDays();

    void work(int workDays);

    void takeVacation(float vacationDays);
}
