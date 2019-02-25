package com.github.swiftech.swifttime;

import org.junit.*;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Test Time class
 *
 * @author Wang Yuxing
 */
public class TimeTest {

    public TimeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of clone method, of class Time.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Time instance = new Time();
        Time result = instance.clone();
        assertEquals(instance, result);
        result.add(Time.YEAR, 1);
        assertFalse(result.equals(instance));
    }

    /**
     * Test of increaseYears method, of class Time.
     */
    @Test
    public void testIncreaseYears() {
        System.out.println("increaseYears");
        int offset = 2;
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.YEAR, offset);
        Time result = instance.increaseYears(offset);
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseYear method, of class Time.
     */
    @Test
    public void testIncreaseYear() {
        System.out.println("increaseYear");
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.YEAR, 1);
        Time result = instance.increaseYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseMonths method, of class Time.
     */
    @Test
    public void testIncreaseMonths() {
        System.out.println("increaseMonths");
        int offset = 2;
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.MONTH, offset);
        Time result = instance.increaseMonths(offset);
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseMonth method, of class Time.
     */
    @Test
    public void testIncreaseMonth() {
        System.out.println("increaseMonth");
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.MONTH, 1);
        Time result = instance.increaseMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseWeeks method, of class Time.
     */
    @Test
    public void testIncreaseWeeks() {
        System.out.println("increaseWeeks");
        int offset = 3;
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.DATE, offset * 7);
        Time result = instance.increaseWeeks(offset);
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseWeek method, of class Time.
     */
    @Test
    public void testIncreaseWeek() {
        System.out.println("increaseWeek");
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.DATE, 7);
        Time result = instance.increaseWeek();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseDates method, of class Time.
     */
    @Test
    public void testIncreaseDates() {
        System.out.println("increaseDates");
        int offset = 3;
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.DATE, offset);
        Time result = instance.increaseDates(offset);
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseDate method, of class Time.
     */
    @Test
    public void testIncreaseDate() {
        System.out.println("increaseDate");
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.DATE, 1);
        Time result = instance.increaseDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseHours method, of class Time.
     */
    @Test
    public void testIncreaseHours() {
        System.out.println("increaseHours");
        int offset = 5;
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.HOUR, offset);
        Time result = instance.increaseHours(offset);
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseHour method, of class Time.
     */
    @Test
    public void testIncreaseHour() {
        System.out.println("increaseHour");
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.HOUR, 1);
        Time result = instance.increaseHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseMinutes method, of class Time.
     */
    @Test
    public void testIncreaseMinutes() {
        System.out.println("increaseMinutes");
        int offset = 2;
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.MINUTE, offset);
        Time result = instance.increaseMinutes(offset);
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseMinute method, of class Time.
     */
    @Test
    public void testIncreaseMinute() {
        System.out.println("increaseMinute");
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.MINUTE, 1);
        Time result = instance.increaseMinute();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseSeconds method, of class Time.
     */
    @Test
    public void testIncreaseSeconds() {
        System.out.println("increaseSeconds");
        int offset = 6;
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.SECOND, offset);
        Time result = instance.increaseSeconds(offset);
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseSecond method, of class Time.
     */
    @Test
    public void testIncreaseSecond() {
        System.out.println("increaseSecond");
        Time instance = new Time();
        Time expResult = new Time();
        expResult.add(Calendar.SECOND, 1);
        Time result = instance.increaseSecond();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetToFirstDayOfThisWeek() {
        System.out.println("setToFirstDayOfThisWeek");
        Time instance = new Time(2009, 1, 6);
        Time expResult = new Time(2009, 1, 4);
        instance.setToFirstDayOfCurrentWeek();
        assertEquals(expResult, instance);

        instance = new Time(2012, 12, 2, 6, 0, 0);
        expResult = new Time(2012, 11, 26, 6, 0, 0);
        instance.setToFirstDayOfCurrentWeek();
        assertEquals(expResult, instance);
    }

    /**
     * Test of getFirstDayOfThisWeek method, of class Time.
     */
    @Test
    public void testGetFirstDayOfThisWeek() {
        System.out.println("getFirstDayOfThisWeek");
        Time instance = new Time(2009, 1, 6);
        Time expResult = new Time(2009, 1, 4);
        Time result = instance.getFirstDayOfCurrentWeek();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetToLastDayOfThisWeek() {
        System.out.println("setToLastDayOfThisWeek");
        Time instance = new Time(2009, 1, 6);
        Time expResult = new Time(2009, 1, 10);
        instance.setToLastDayOfCurrentWeek();
        assertEquals(expResult, instance);

        instance = new Time(2012, 12, 2);
        expResult = new Time(2012, 12, 2);
        instance.setToLastDayOfCurrentWeek();
        assertEquals(expResult, instance);
    }

    /**
     * Test of getLastDayOfThisWeek method, of class Time.
     */
    @Test
    public void testGetLastDayOfThisWeek() {
        System.out.println("getLastDayOfThisWeek");
        Time instance = new Time(2009, 1, 6);
        Time expResult = new Time(2009, 1, 10);
        Time result = instance.getLastDayOfCurrentWeek();
        assertEquals(expResult, result);
    }

    /**
     * Test of isWorkingDay method, of class Time.
     */
    @Test
    public void testIsWorkingDay() {
        System.out.println("isWorkingDay");
        Time instance = new Time(2009, 1, 4);
        assertFalse(instance.getTime().toString(), instance.isWorkingDay());
        assertTrue(instance.getTime().toString(), instance.increaseDate().isWorkingDay());
        assertTrue(instance.getTime().toString(), instance.increaseDate().isWorkingDay());
        assertTrue(instance.getTime().toString(), instance.increaseDate().isWorkingDay());
        assertTrue(instance.getTime().toString(), instance.increaseDate().isWorkingDay());
        assertTrue(instance.getTime().toString(), instance.increaseDate().isWorkingDay());
        assertFalse(instance.getTime().toString(), instance.increaseDate().isWorkingDay());
    }

    /**
     * Test of isRestDay method, of class Time.
     */
    @Test
    public void testIsRestDay() {
        System.out.println("isRestDay");
        Time instance = new Time(2009, 1, 4);
        assertTrue(instance.getTime().toString(), instance.isRestDay());
        assertFalse(instance.getTime().toString(), instance.increaseDate().isRestDay());
        assertFalse(instance.getTime().toString(), instance.increaseDate().isRestDay());
        assertFalse(instance.getTime().toString(), instance.increaseDate().isRestDay());
        assertFalse(instance.getTime().toString(), instance.increaseDate().isRestDay());
        assertFalse(instance.getTime().toString(), instance.increaseDate().isRestDay());
        assertTrue(instance.getTime().toString(), instance.increaseDate().isRestDay());
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        int result = instance.getYear();
        assertEquals(2009, result);
    }

    /**
     * Test of setYear method, of class Time.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        int year = 2010;
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        instance.setYear(year);
        assertEquals(year, instance.getYear());
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        int result = instance.getMonth();
        assertEquals(1, result);
    }

    /**
     * Test of setMonth method, of class Time.
     */
    @Test
    public void testSetMonth() {
        System.out.println("setMonth");
        int month = 5;
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        instance.setMonth(month);
        assertEquals(month, instance.getMonth());
    }

    /**
     * Test of getDate method, of class Time.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        int result = instance.getDate();
        assertEquals(10, result);
    }

    /**
     * Test of setDate method, of class Time.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        int date = 20;
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        instance.setDate(date);
        assertEquals(date, instance.getDate());
    }

    /**
     * Test of getHour method, of class Time.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        int result = instance.getHour();
        assertEquals(23, result);
    }

    /**
     * Test of setHour method, of class Time.
     */
    @Test
    public void testSetHour() {
        System.out.println("setHour");
        int hour = 2;
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        instance.setHour(hour);
        assertEquals(hour, instance.getHour());
    }

    /**
     * Test of getMinute method, of class Time.
     */
    @Test
    public void testGetMinute() {
        System.out.println("getMinute");
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        int result = instance.getMinute();
        assertEquals(56, result);
    }

    /**
     * Test of setMinute method, of class Time.
     */
    @Test
    public void testSetMinute() {
        System.out.println("setMinute");
        int minute = 45;
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        instance.setMinute(minute);
        assertEquals(minute, instance.getMinute());
    }

    /**
     * Test of getSecond method, of class Time.
     */
    @Test
    public void testGetSecond() {
        System.out.println("getSecond");
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        int result = instance.getSecond();
        assertEquals(26, result);
    }

    /**
     * Test of setSecond method, of class Time.
     */
    @Test
    public void testSetSecond() {
        System.out.println("setSecond");
        int second = 30;
        Time instance = new Time(2009, 1, 10, 23, 56, 26);
        instance.setSecond(second);
        assertEquals(second, instance.getSecond());
    }

    /**
     * Test of truncateAtYear method, of class Time.
     */
    @Test
    public void testTruncateAtYear() {
        System.out.println("truncateAtYear");
        Time instance = new Time(2009, 2, 10, 23, 56, 26);
        Time result = instance.truncateAtYear();
        assertEquals(2009, result.getYear());
        assertEquals(1, result.getMonth());
        assertEquals(1, result.getDate());
        assertEquals(0, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    /**
     * Test of truncateAtMonth method, of class Time.
     */
    @Test
    public void testTruncateAtMonth() {
        System.out.println("truncateAtMonth");
        Time instance = new Time(2009, 2, 10, 23, 56, 26);
        Time result = instance.truncateAtMonth();
        assertEquals(2009, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(1, result.getDate());
        assertEquals(0, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    /**
     * Test of truncateAtWeek method, of class Time.
     */
    @Test
    public void testTruncateAtWeek() {
        System.out.println("truncateAtWeek");
        Time instance = new Time(2009, 2, 10, 23, 56, 26);
        Time result = instance.truncateAtWeek();
        assertEquals(2009, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(8, result.getDate());// 2009-2-8 is Sunday of this week
        assertEquals(0, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    /**
     * Test of truncateAtDate method, of class Time.
     */
    @Test
    public void testTruncateAtDate() {
        System.out.println("truncateAtDate");
        Time instance = new Time(2009, 2, 10, 23, 56, 26);
        Time result = instance.truncateAtDate();
        assertEquals(2009, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(10, result.getDate());
        assertEquals(0, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    /**
     * Test of truncateAtHour method, of class Time.
     */
    @Test
    public void testTruncateAtHour() {
        System.out.println("truncateAtHour");
        Time instance = new Time(2009, 2, 10, 23, 56, 26);
        Time result = instance.truncateAtHour();
        assertEquals(2009, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(10, result.getDate());
        assertEquals(23, result.getHour());
        assertEquals(0, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    /**
     * Test of truncateAtMinute method, of class Time.
     */
    @Test
    public void testTruncateAtMinute() {
        System.out.println("truncateAtMinute");
        Time instance = new Time(2009, 2, 10, 23, 56, 26);
        Time result = instance.truncateAtMinute();
        assertEquals(2009, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(10, result.getDate());
        assertEquals(23, result.getHour());
        assertEquals(56, result.getMinute());
        assertEquals(0, result.getSecond());
    }

    /**
     * Test of truncateAtSecond method, of class Time.
     */
    @Test
    public void testTruncateAtSecond() {
        System.out.println("truncateAtSecond");
        Time instance = new Time(2009, 2, 10, 23, 56, 26);
        Time result = instance.truncateAtSecond();
        assertEquals(2009, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(10, result.getDate());
        assertEquals(23, result.getHour());
        assertEquals(56, result.getMinute());
        assertEquals(26, result.getSecond());
    }

    /**
     * Test of getYearIntervalFrom method, of class Time.
     */
    @Test
    public void testGetYearIntervalFrom() {
        System.out.println("getYearIntervalFrom");
        Time time = new Time(2009);
        Time instance = new Time(2010);
        int result = instance.getYearIntervalFrom(time);
        assertEquals(1, result);
    }

    /**
     * Test of getMonthIntervalFrom method, of class Time.
     */
    @Test
    public void testGetMonthIntervalFrom() {
        System.out.println("getMonthIntervalFrom");
        Time time = new Time(2009, 2);
        Time instance = new Time(2010, 1);
        int result = instance.getMonthIntervalFrom(time);
        assertEquals(11, result);
    }


    /**
     * Test of getDayIntervalFrom method, of class Time.
     */
    @Test
    public void testGetDayIntervalFrom() {
        System.out.println("getDayIntervalFrom");
        Time time = new Time(2009, 2, 28);
        Time instance = new Time(2010, 1, 2);
        int result = instance.getDayIntervalFrom(time);
        assertEquals(308, result);
    }

    /**
     * Test of getHourIntervalFrom method, of class Time.
     */
    @Test
    public void testGetHourIntervalFrom() {
        System.out.println("getHourIntervalFrom");
        Time time = new Time(2009, 2, 28, 12);
        Time instance = new Time(2010, 1, 2, 12);
        int result = instance.getHourIntervalFrom(time);
        assertEquals(7392, result);
    }

    /**
     * Test of getMinuteIntervalFrom method, of class Time.
     */
    @Test
    public void testGetMinuteIntervalFrom() {
        System.out.println("getMinuteIntervalFrom");
        Time time = new Time(2009, 2, 28, 12, 15);
        Time instance = new Time(2010, 1, 2, 12, 30);
        int result = instance.getMinuteIntervalFrom(time);
        assertEquals(443535, result);
    }

    /**
     * Test of getSecondIntervalFrom method, of class Time.
     */
    @Test
    public void testGetSecondIntervalFrom() {
        System.out.println("getSecondIntervalFrom");
        Time time = new Time(2009, 2, 28, 12, 15, 30);
        Time instance = new Time(2010, 1, 2, 12, 30, 45);
        int result = instance.getSecondIntervalFrom(time);
        assertEquals(26612115, result);
    }

    /**
     * Test of getWeekIntervalFrom method, of class Time.
     */
    @Test
    public void testGetWeekIntervalFrom() {
        System.out.println("getWeekIntervalFrom");
        Time time = new Time(2009, 1, 28);
        Time inst = new Time(2009, 2, 23);
        int result = inst.getWeekIntervalFrom(time);
        assertEquals(4, result);

        // Within a week
        time = new Time(2009, 1, 5, 12, 0);
        inst = new Time(2009, 1, 10, 12, 0);
        assertEquals(0, inst.getWeekIntervalFrom(time));
        // from a week to next week but not a full circle
        time = new Time(2009, 1, 5, 12, 0, 0);
        inst = new Time(2009, 1, 11, 11, 59, 59);
        assertEquals(1, inst.getWeekIntervalFrom(time));
        // from a week to next week plus 1 second
        time = new Time(2009, 1, 8, 12, 0, 0);
        inst = new Time(2009, 1, 12, 12, 0, 1);
        assertEquals(1, inst.getWeekIntervalFrom(time));

    }
}