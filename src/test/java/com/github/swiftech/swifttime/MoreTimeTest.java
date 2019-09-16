package com.github.swiftech.swifttime;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Allen 2018-02-13
 **/
public class MoreTimeTest {

    @Test
    public void testNull() {
        Long tnull = null;
        Time t = new Time(tnull);

        long t1 = 0;
        Time tt2 = new Time(t1);
    }

    @Test
    public void testInterval() {
        Time t = new Time(2018, 02, 13, 22, 06, 30);
        t.truncateAtMonth();
        System.out.println(t);

        t.setDate(3);

        Time t1 = new Time(2018);
        Time t2 = new Time(2000);
        int yearIntervalFrom = t1.getYearIntervalFrom(t2);
        Assert.assertEquals("", 18, yearIntervalFrom);
    }

    @Test
    public void testObject() {
        Time t1 = new Time();
        Time t2 = new Time(t1.getTimeInMillis());
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testLong() {
        Long l = null;
        Time t = new Time(l);
        System.out.println(t);
        l = new Long(9999);
        t = new Time(l);
        System.out.println(t);
    }


}
