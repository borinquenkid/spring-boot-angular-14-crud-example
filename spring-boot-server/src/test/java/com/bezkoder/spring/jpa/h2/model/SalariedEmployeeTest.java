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
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(TooMuchWorkException.class, () -> {
            salariedEmployee.work(SalariedEmployee.MAX_WORK_DAYS_PER_YEAR + 1);
        });

        assertEquals("You are working too much", exception.getMessage());
    }

    @ParameterizedTest(name = "work {0} days, expect {1} vacation days")
    @CsvSource(textBlock = """
              0,  0f
             15,  1f
             30,  2f
             45,  3f
             60,  4f
             75,  5f
             90,  6f
            105,  7f
            120,  8f
            135,  9f
            150, 10f
            165, 11f
            180, 12f
            195, 13f
            210, 14f
            225, 15f
            230, 15f
            245, 15f
            260, 15f
            """
    )
    void workDays(int workDays, float expectedVacationDays) {
        salariedEmployee.work(workDays);
        assertEquals(expectedVacationDays, salariedEmployee.getVacationDays());
    }

}