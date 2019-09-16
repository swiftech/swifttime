package com.github.swiftech.swifttime;

import org.junit.Test;

/**
 * @author Allen 2018-02-25
 **/
public class TZTimeSpanTest {

    @Test
    public void testSetTime() {
        TZTimeSpan tzTimeSpan = new TZTimeSpan(1, 30, 2, 40);

        System.out.println(tzTimeSpan);

        tzTimeSpan.setTime("11:40", "12:50");
        System.out.println(tzTimeSpan);
    }
}
