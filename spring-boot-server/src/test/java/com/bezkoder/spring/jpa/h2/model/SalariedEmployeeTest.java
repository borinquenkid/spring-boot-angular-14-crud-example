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
    public void whenGreaterThanMaxDays_tooMuchException() {
        Exception exception = assertThrows(TooMuchWorkException.class, () -> salariedEmployee.work(IEmployee.MAX_WORK_DAYS_PER_YEAR + 1));

        assertEquals("You are working too much", exception.getMessage());
    }

    @Test
    public void whenLessThanZeroDays_tooLittleException() {
        Exception exception = assertThrows(NegativeWorkException.class, () -> salariedEmployee.work(IEmployee.MIN_WORK_DAYS_PER_YEAR - 1));

        assertEquals("You can not work negative days", exception.getMessage());
    }

    @ParameterizedTest(name = "work {0} days, expect {1} vacation days")
    @CsvSource(textBlock = """
              0,  0f
             52,  3f
             104,  6f
             156,  9f
             208,  12f
             260,  15f
            """
    )
    void workDays(int workDays, float expectedVacationDays) {
        salariedEmployee.work(workDays);
        assertEquals(expectedVacationDays, salariedEmployee.getVacationDays());
    }

}