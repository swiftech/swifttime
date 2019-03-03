package com.github.swiftech.swifttime;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yuxing on 14-7-22.
 */
public class TimeFormatBuilderTest {

    private long time;


    @Before
    public void setUp() throws Exception {
        time = new Time(2014, 7, 22, 1, 2, 3).getTimeInMillis();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNormal() {


        Assert.assertEquals("2014-07-22", TimeFormatBuilder.TIME_FORMAT_BUILDER_DATE_MINUS.format(time));

        Assert.assertEquals("2014-07-22 01:02", TimeFormatBuilder.TIME_FORMAT_BUILDER_DATE_TIME_MINUS.format(time));

        Assert.assertEquals("2014-07-22 01:02:03", TimeFormatBuilder.TIME_FORMAT_BUILDER_DATE_TIME_MINUS.colon().second().format(time));

        Assert.assertEquals("2014_0722_0102", TimeFormatBuilder.TIME_FORMAT_BUILDER_TIME_STAMP.format(time));
    }

    @Test
    public void test() {
        TimeFormatBuilder format
                = new TimeFormatBuilder().year().separator("年").month().separator("月").day().separator("日")
                .hour().separator("时").minute().separator("分").second().separator("秒");
        Assert.assertEquals("2014年07月22日01时02分03秒", format.format(time));
    }
}
