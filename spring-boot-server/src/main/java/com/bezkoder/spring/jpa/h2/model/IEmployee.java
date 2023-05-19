package com.bezkoder.spring.jpa.h2.model;

public interface IEmployee {

    float getVacationDays();


    void work(int workDays);

    void takeVacation(float vacationDays);
}
