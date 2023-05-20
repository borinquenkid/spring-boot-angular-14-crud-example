package com.bezkoder.spring.jpa.h2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HourlyEmployeeTest {

    private HourlyEmployee hourlyEmployee;

    @BeforeEach
    void setup() {
        hourlyEmployee = new HourlyEmployee();
    }

    @Test
    void getDefault() {
        assertEquals(0f, hourlyEmployee.getVacationDays());
    }

    @Test
    public void whenGreaterThanMaxDays_tooMuchException() {
        Exception exception = assertThrows(TooMuchWorkException.class, () -> hourlyEmployee.work(IEmployee.MAX_WORK_DAYS_PER_YEAR + 1));

        assertEquals("You are working too much", exception.getMessage());
    }

    @Test
    public void whenLessThanZeroDays_tooLittleException() {
        Exception exception = assertThrows(NegativeWorkException.class, () -> hourlyEmployee.work(IEmployee.MIN_WORK_DAYS_PER_YEAR - 1));

        assertEquals("You can not work negative days", exception.getMessage());
    }

    @ParameterizedTest(name = "work {0} days, expect {1} vacation days")
    @CsvSource(textBlock = """
              0,  0f
             10,  1f
             20,  2f
             30,  3f
             40,  4f
             50,  5f
             60,  6f
             70,  7f
             80,  8f
             90,  9f
            100, 10f
            110, 10f
            260, 10f
            """
    )
    void workDays(int workDays, float expectedVacationDays) {
        hourlyEmployee.work(workDays);
        assertEquals(expectedVacationDays, hourlyEmployee.getVacationDays());
    }

}