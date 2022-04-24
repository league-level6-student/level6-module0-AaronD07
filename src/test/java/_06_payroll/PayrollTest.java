package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
double hourlyWage = 16.5;
int numHours = 45;
double expected = 742.5;
        //when
double actual = payroll.calculatePaycheck(hourlyWage, numHours);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
int milesTraveled = 40;
double expected = 23.00;
        //when
double actual = payroll.calculateMileageReimbursement(milesTraveled);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
String employeeName = "Dave";
double hourlyWage = 16.5;
String expected = "Hello Dave, We are pleased to offer you an hourly wage of 16.5";
        //when
String actual = payroll.createOfferLetter(employeeName, hourlyWage);
        //then
        assertEquals(expected, actual);
    }

}