package com.bezkoder.spring.jpa.h2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagerEmployeeTest {

    private ManagerEmployee managerEmployee;

    @BeforeEach
    void setup() {
        managerEmployee = new ManagerEmployee();
    }

    @Test
    void getDefault() {
        assertEquals(0f, managerEmployee.getVacationDays());
    }

    @Test
    public void whenGreaterThanMaxDays_tooMuchException() {
        Exception exception = assertThrows(TooMuchWorkException.class, () -> managerEmployee.work(IEmployee.MAX_WORK_DAYS_PER_YEAR + 1));

        assertEquals("You are working too much", exception.getMessage());
    }

    @Test
    public void whenLessThanZeroDays_tooLittleException() {
        Exception exception = assertThrows(NegativeWorkException.class, () -> managerEmployee.work(IEmployee.MIN_WORK_DAYS_PER_YEAR - 1));

        assertEquals("You can not work negative days", exception.getMessage());
    }

    @ParameterizedTest(name = "work {0} days, expect {1} vacation days")
    @CsvSource(textBlock = """
               0,  0f
              26,  3f
              52,  6f
              78,  9f
             104, 12f
             130, 15f
             156, 18f
             182, 21f
             208, 24f
             234, 27f
             260, 30f
            """
    )
    void workDays(int workDays, float expectedVacationDays) {
        managerEmployee.work(workDays);
        assertEquals(expectedVacationDays, managerEmployee.getVacationDays());
    }

}