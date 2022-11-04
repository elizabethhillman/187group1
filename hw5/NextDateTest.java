package hw5;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NextDateTest {

    //Test 1: Given the date February 28th, it should return the correct next date whether the year is a leap year or not
    @Test
    void returnNextDateLeapYear() {
        NextDate.date = "02/28/1988";
        assertEquals("02/29/1988", NextDate.returnNextDate(NextDate.date));

        NextDate.date = "02/28/1989";
        assertEquals("03/01/1989", NextDate.returnNextDate(NextDate.date));
    }

    //Test 2: Given a date with the last day of a month, it should return the first day of the next month
    @Test
    void returnNextDateChangeMonth() {
        NextDate.date = "06/30/1988";
        assertEquals("07/01/1988", NextDate.returnNextDate(NextDate.date));
    }

    //Test 3: Given a date with the last day of a year, it should return the first day of the next year
    @Test
    void returnNextDateChangeYear() {
        NextDate.date = "12/31/1988";
        assertEquals("01/01/1989", NextDate.returnNextDate(NextDate.date));
    }

    //Test 4: Given a date with a day that is not the last day of a month, it should return the next day of that month and year
    @Test
    void returnNextDateChangeDay() {
        NextDate.date = "05/12/1988";
        assertEquals("05/13/1988", NextDate.returnNextDate(NextDate.date));
    }

    //Test 5: Checks that the given day (X) is within the range a < X < b; where 'a' is the first day of the month and 'b' is the last day of the month
    @Test
    void checkDayEP() {
        //partition 1: invalid (day < 1)
        NextDate.date = "03/00/1988";
        assertFalse(NextDate.checkDay(NextDate.date));

        //partition 2: valid
        NextDate.date = "03/15/1988";
        assertTrue(NextDate.checkDay(NextDate.date));

        //partition 3: invalid (day > 31)
        NextDate.date = "03/32/1988";
        assertFalse(NextDate.checkDay(NextDate.date));
    }

    //Test 6: Checks that the boundary points for a given day is within the range
    @Test
    void checkDayBVA()
    {
        //minimum
        NextDate.date = "03/01/1988";
        assertTrue(NextDate.checkDay(NextDate.date));

        //just above the minimum
        NextDate.date = "03/03/1988";
        assertTrue(NextDate.checkDay(NextDate.date));

        //a nominal value
        NextDate.date = "03/16/1988";
        assertTrue(NextDate.checkDay(NextDate.date));

        //just below the maximum
        NextDate.date = "03/29/1988";
        assertTrue(NextDate.checkDay(NextDate.date));

        //maximum
        NextDate.date = "03/31/1988";
        assertTrue(NextDate.checkDay(NextDate.date));
    }

    //Test 7: Given any random day in a month within the input domain, the day is valid
    @Test
    void checkDayRandom()
    {
        //random number 1-31
        Random random = new Random();

        //random day 1-the number of days in the random given month
        int day = random.nextInt(1, 31);
        NextDate.date ="03/"+String.format("%02d", day)+"/1910";
        assertTrue(NextDate.checkDay(NextDate.date));
    }

    //Test 8: Checks that the given month (X) is within the range a < X < b; where 'a' is the first month(1) and 'b' is the last month(12)
    @Test
    void checkMonthEP() {
        //partition 1: invalid (month < 1)
        NextDate.date = "00/01/1910";
        assertFalse(NextDate.checkMonth(NextDate.date));

        //partition 2: valid
        NextDate.date = "07/01/1910";
        assertTrue(NextDate.checkMonth(NextDate.date));

        //partition 3: invalid (month > 12)
        NextDate.date = "13/01/1910";
        assertFalse(NextDate.checkMonth(NextDate.date));
    }

    //Test 9: Checks that the boundary points for a given month is within the range
    @Test
    void checkMonthBVA() {
        //minimum
        NextDate.date = "01/01/1910";
        assertTrue(NextDate.checkMonth(NextDate.date));

        //just above the minimum
        NextDate.date = "03/01/1910";
        assertTrue(NextDate.checkMonth(NextDate.date));

        //a nominal value
        NextDate.date = "08/01/1910";
        assertTrue(NextDate.checkMonth(NextDate.date));

        //just below the maximum
        NextDate.date = "10/01/1910";
        assertTrue(NextDate.checkMonth(NextDate.date));

        //maximum
        NextDate.date = "12/01/1910";
        assertTrue(NextDate.checkMonth(NextDate.date));
    }

    //Test 10: Given any random month within the input domain, the month is valid
    @Test
    void checkMonthRandom() {
        //random month 1-12
        Random random = new Random();
        int month = random.nextInt(1,12);
        NextDate.date = String.format("%02d", month)+"/01/1910";
        assertTrue(NextDate.checkMonth(NextDate.date));
    }

    //Test 11: Checks that the given year (X) is within the range a < X < b; where 'a' is 1900 and 'b' is 2099
    @Test
    void checkYearEP() {
        //partition 1: invalid (month < 1)
        NextDate.date = "01/01/1899";
        assertFalse(NextDate.checkYear(NextDate.date));

        //partition 2: valid
        NextDate.date = "01/01/2000";
        assertTrue(NextDate.checkYear(NextDate.date));

        //partition 3: invalid (month > 12)
        NextDate.date = "01/01/2100";
        assertFalse(NextDate.checkYear(NextDate.date));
    }

    //Test 12: Checks that the boundary points for a given year is within the range
    @Test
    void checkYearBVA() {
        //minimum
        NextDate.date = "01/01/1900";
        assertTrue(NextDate.checkYear(NextDate.date));

        //just above the minimum
        NextDate.date = "01/01/1910";
        assertTrue(NextDate.checkYear(NextDate.date));

        //a nominal value
        NextDate.date = "01/01/1990";
        assertTrue(NextDate.checkYear(NextDate.date));

        //just below the maximum
        NextDate.date = "01/01/2089";
        assertTrue(NextDate.checkYear(NextDate.date));

        //maximum
        NextDate.date = "01/01/2099";
        assertTrue(NextDate.checkYear(NextDate.date));
    }

    //Test 13: Given any random year within the input domain, the year is valid
    @Test
    void checkYearRandom() {
        //random year 1900-2099
        Random random = new Random();
        int year = random.nextInt(1900,2099);
        NextDate.date = "01/01/"+year;
        assertTrue(NextDate.checkYear(NextDate.date));
    }
}