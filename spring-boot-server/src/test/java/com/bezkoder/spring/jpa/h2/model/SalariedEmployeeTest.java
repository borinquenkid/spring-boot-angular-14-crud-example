package com.bezkoder.spring.jpa.h2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "work {0} days, expect {1} vacation days")
    @CsvSource(textBlock = """
            0,0f
            """
    )
    void workDays(int workDays, float expectedVacationDays) {
        salariedEmployee.work(workDays);
        assertEquals(expectedVacationDays, salariedEmployee.getVacationDays());
    }

}