package com.bezkoder.spring.jpa.h2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalariedEmployeeTest {

    private SalariedEmployee salariedEmployee;

    @BeforeEach
    void setup() {
        salariedEmployee = new SalariedEmployee();
    }

    @Test
    void getDefault() {
        assertEquals(0f, salariedEmployee.getVacationDays());
        assertEquals(0, salariedEmployee.getWorkDays());
    }

}