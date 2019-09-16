package com.github.swiftech.swifttime;


import java.util.TimeZone;

/**
 * TBD
 * 简化初始化
 */
public class TZTimeSpan extends TimeSpan {

    /**
     * 设置时间段，以当前时区为准。时间段必须在同一天内（跨天用时区控制）
     *
     * @param hourf
     * @param minutef
     * @param hourt
     * @param minutet
     */
    public TZTimeSpan(int hourf, int minutef, int hourt, int minutet) {
        super();
        super.from = new Time();
        super.from.setHour(hourf);
        super.from.setMinute(minutef);
        super.to = super.from.clone();
        super.to.setHour(hourt);
        super.to.setMinute(minutet);
    }

    /**
     * 带时区的时间段。时间段必须在同一天内（跨天用时区控制）
     *
     * @param timeZone
     * @param hourf
     * @param minutef
     * @param hourt
     * @param minutet
     */
    public TZTimeSpan(TimeZone timeZone, int hourf, int minutef, int hourt, int minutet) {
        super();
        super.from = new Time();
        super.to = super.from.clone();
        super.from.setTimeZone(timeZone);
        super.to.setTimeZone(timeZone);
        super.from.setHour(hourf);
        super.to.setHour(hourt);
        super.from.setMinute(minutef);
        super.to.setMinute(minutet);
    }


    /**
     * 设置时间段，以当前时区为准。时间段必须在同一天内（跨天用时区控制）
     *
     * @param from
     * @param to
     */
    public TZTimeSpan(String from, String to) {
        super();
        if (isBlank(from) || isBlank(to)) {
            throw new IllegalArgumentException();
        }
        setTime(from, to);
    }

    /**
     * 带时区的时间段。时间段必须在同一天内（跨天用时区控制）
     *
     * @param timeZone
     * @param from
     * @param to
     */
    public TZTimeSpan(TimeZone timeZone, String from, String to) {
        super();
        if (timeZone == null || isBlank(from) || isBlank(to)) {
            throw new IllegalArgumentException("非法的日期，此时间段将无效");
        }
        setTime(timeZone, from, to);
    }

    /**
     * Internal use
     *
     * @param from
     * @param to
     */
    private TZTimeSpan(Time from, Time to) {
        super.from = from;
        super.to = to;
    }

    private Time parse(TimeZone tz, String hourMinute) {
        Time t = new Time();
        String[] afrom = hourMinute.split(":");
        if (afrom == null || afrom.length == 0) {
            return null;
        }
        if (tz != null) {
            t.setTimeZone(tz);
        }
        t.setHour(Integer.parseInt(afrom[0]));
        t.setMinute(Integer.parseInt(afrom[1]));
        return t;
    }

    /**
     * 设置时间，如果保留原值，则留空
     *
     * @param from
     * @param to
     */
    public void setTime(String from, String to) {
        Time tfrom = parse(null, from);
        Time tto = parse(null, to);
        super.from = tfrom == null ? super.from : tfrom;
        super.to = tto == null ? super.from : tto;
        super.from.truncateAtMinute();
        super.to.truncateAtMinute();
    }

    public void setTime(TimeZone timeZone, String from, String to) {
        Time tfrom = parse(timeZone, from);
        Time tto = parse(timeZone, to);
        if (tfrom != null) {
            //			tfrom.setTimeZone(timeZone);
            super.from = tfrom;
            super.from.truncateAtMinute();
        }
        if (tto != null) {
            //			tto.setTimeZone(timeZone);
            super.to = tto;
            super.to.truncateAtMinute();
        }
    }

    @Override
    protected TZTimeSpan clone() throws CloneNotSupportedException {
        TZTimeSpan vts = new TZTimeSpan(this.getFrom().clone(), this.getTo().clone());
        return vts;
    }

    public void setTimeZone(TimeZone timeZone) {
        int offset = timeZone.getOffset(super.from.getTimeInMillis());
        super.from.setTimeZone(timeZone);
        super.to.setTimeZone(timeZone);
        super.from.setTimeInMillis(super.from.getTimeInMillis() + offset);
        super.to.setTimeInMillis(super.to.getTimeInMillis() + offset);
    }

    public int[] getHourMinute() {
        return new int[]{super.from.getHour(), super.from.getMinute(), super.to.getHour(), super.to.getMinute()};
    }

    public int[] getHourMinuteLocal() {
//		if (super.from == null || super.to == null) {
//			return null;
//		}
        Time fromLocal = super.from.clone();
        Time toLocal = super.to.clone();
        fromLocal.setTimeZone(TimeZone.getDefault());
        toLocal.setTimeZone(TimeZone.getDefault());
        return new int[]{fromLocal.getHour(), fromLocal.getMinute(), toLocal.getHour(), toLocal.getMinute()};
    }

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
