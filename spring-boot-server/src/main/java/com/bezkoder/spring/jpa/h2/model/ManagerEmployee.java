package com.bezkoder.spring.jpa.h2.model;

public class ManagerEmployee extends SalariedEmployee {

    public ManagerEmployee(String name, int id) {
        super(name, id);
        vacationDays = 0f;
        vacationDaysPerYear = 30f;
    }

}
