/*
 * Copyright 2018 Yuxing Wang.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.swiftech.swifttime;

import java.util.*;

/**
 * Light weight extension of GregorianCalendar with more common time operation.
 * <ul>
 * <li>Retrieve single field of time, <code>getYear(), getMonth(), getDay(), getHour(), getMinute(), getSecond()</code>
 * <li>Truncate time at any field of time.
 * <li>Increase and decrease time at any time field.
 * <li><code>setToFirstDayOfCurrentWeek(), getFirstDayOfCurrentWeek(), setToLastDayOfCurrentWeek(), getLastDayOfCurrentWeek()</code>
 * <li><code>getDaysOfCurrentMonth()</code></li>
 * </ul>
 * Static Methods:
 * <ul>
 * <li>
 * <code>getDaysOfMonth()</code>
 * </li>
 * </ul>
 *
 * @author Yuxing Wang
 */
public class Time extends GregorianCalendar {
    static final int[] DAYS_OF_MONTH = new int[12];

    static {
        DAYS_OF_MONTH[0] = 31;
        DAYS_OF_MONTH[1] = 28;// 29 when leap year.
        DAYS_OF_MONTH[2] = 31;
        DAYS_OF_MONTH[3] = 30;
        DAYS_OF_MONTH[4] = 31;
        DAYS_OF_MONTH[5] = 30;
        DAYS_OF_MONTH[6] = 31;
        DAYS_OF_MONTH[7] = 31;
        DAYS_OF_MONTH[8] = 30;
        DAYS_OF_MONTH[9] = 31;
        DAYS_OF_MONTH[10] = 30;
        DAYS_OF_MONTH[11] = 31;
    }

    public Time(Calendar calendar) {
        this.setTime(calendar.getTime());
    }

    /**
     * @param year
     * @param month      Month starts from 1
     * @param dayOfMonth 1-31
     * @param hourOfDay  0-23
     * @param minute     0-59
     * @param second     0-59
     */
    public Time(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        super(year, month - 1, dayOfMonth, hourOfDay, minute, second);
    }

    /**
     *
     * @param year
     * @param month         Month starts from 1
     * @param dayOfMonth    1-31
     * @param hourOfDay     0-23
     * @param minute        0-59
     */
    public Time(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        super(year, month - 1, dayOfMonth, hourOfDay, minute);
    }

    /**
     *
     * @param year
     * @param month
     * @param dayOfMonth    1-31
     * @param hourOfDay     0-23
     */
    public Time(int year, int month, int dayOfMonth, int hourOfDay) {
        super(year, month - 1, dayOfMonth, hourOfDay, 0);
    }

    /**
     *
     * @param year
     * @param month
     * @param dayOfMonth    1-31
     */
    public Time(int year, int month, int dayOfMonth) {
        super(year, month - 1, dayOfMonth);
    }

    /**
     *
     * @param year
     * @param month
     */
    public Time(int year, int month) {
        super(year, month - 1, 1);
    }

    /**
     *
     * @param year
     */
    public Time(int year) {
        super(year, 0, 1);
    }

    /**
     *
     * @param zone
     * @param aLocale
     */
    public Time(TimeZone zone, Locale aLocale) {
        super(zone, aLocale);
    }

    /**
     *
     * @param aLocale
     */
    public Time(Locale aLocale) {
        super(aLocale);
    }

    /**
     *
     * @param zone
     */
    public Time(TimeZone zone) {
        super(zone);
    }

    /**
     *
     * @param date
     */
    public Time(Date date) {
        this.setTime(date);
    }

    /**
     *
     * @param timeInMillis
     */
    public Time(long timeInMillis) {
        this.setTimeInMillis(timeInMillis);
    }

    /**
     *
     * @param timeInMillis
     */
    public Time(Long timeInMillis) {
        if (timeInMillis == null) {
            this.setTimeInMillis(0);
        }
        else {
            this.setTimeInMillis(timeInMillis);
        }
    }

    public Time() {
    }

    @Override
    public Time clone() {
        return (Time) super.clone();
    }

    /**
     * Increase only years form current year.
     *
     * @param offset
     * @return
     */
    public Time increaseYears(int offset) {
        this.add(YEAR, offset);
        return this;
    }

    /**
     * Increase one year from current year.
     *
     * @return
     */
    public Time increaseYear() {
        return increaseYears(1);
    }

    /**
     * Increase months from current month.
     *
     * @param offset
     * @return
     */
    public Time increaseMonths(int offset) {
        this.add(MONTH, offset);
        return this;
    }

    /**
     * Increase one month from current month.
     *
     * @return
     */
    public Time increaseMonth() {
        return this.increaseMonths(1);
    }

    /**
     * Increase weeks from current week.
     *
     * @param offset
     * @return
     */
    public Time increaseWeeks(int offset) {
        this.add(DATE, offset * 7);
        return this;
    }

    /**
     * Increase one week from current week.
     *
     * @return
     */
    public Time increaseWeek() {
        return increaseWeeks(1);
    }

    /**
     * Increase days from current day of month.
     *
     * @param offset
     * @return
     */
    public Time increaseDates(int offset) {
        this.add(DATE, offset);
        return this;
    }

    /**
     * Increase one day from current day of month.
     *
     * @return
     */
    public Time increaseDate() {
        return this.increaseDates(1);
    }

    /**
     * Increase hours from current hour.
     *
     * @param offset
     * @return
     */
    public Time increaseHours(int offset) {
        this.add(HOUR_OF_DAY, offset);
        return this;
    }

    /**
     * Increase one hours from current hour.
     *
     * @return
     */
    public Time increaseHour() {
        return this.increaseHours(1);
    }

    /**
     * Increase minutes from current minute.
     *
     * @param offset
     * @return
     */
    public Time increaseMinutes(int offset) {
        this.add(MINUTE, offset);
        return this;
    }

    /**
     * Increase one minute from current minute.
     *
     * @return
     */
    public Time increaseMinute() {
        return this.increaseMinutes(1);
    }

    /**
     * Increase seconds from current second.
     *
     * @param offset
     * @return
     */
    public Time increaseSeconds(int offset) {
        this.add(SECOND, offset);
        return this;
    }

    /**
     * Increase one second from current second.
     *
     * @return
     */
    public Time increaseSecond() {
        return this.increaseSeconds(1);
    }

    /**
     * Set to the first day of current week.
     *
     * @return
     */
    public Time setToFirstDayOfCurrentWeek() {
        this.increaseDates(SUNDAY - this.get(DAY_OF_WEEK));
        return this;
    }

    /**
     * Get the first day of current week.
     *
     * @return
     */
    public Time getFirstDayOfCurrentWeek() {
        return this.clone().setToFirstDayOfCurrentWeek();
    }

    /**
     * Set to the last day of current week.
     *
     * @return
     */
    public Time setToLastDayOfCurrentWeek() {
        this.increaseDates(SATURDAY - this.get(DAY_OF_WEEK));
        return this;
    }

    /**
     * Get the last day of current week.
     *
     * @return
     */
    public Time getLastDayOfCurrentWeek() {
        return this.clone().setToLastDayOfCurrentWeek();
    }

    /**
     * Check if it is working day in a week.
     *
     * @return
     */
    public boolean isWorkingDay() {
        int dayOfWeek = this.get(DAY_OF_WEEK);
        return dayOfWeek > 1 && dayOfWeek < 7;
    }

    /**
     * Check if it is NOT working day in a week.
     *
     * @return
     */
    public boolean isRestDay() {
        return !isWorkingDay();
    }

    /**
     * Truncate time at year field.
     *
     * @return
     */
    public Time truncateAtYear() {
        this.truncateTime(this, YEAR);
        return this;
    }

    /**
     * Truncate time at month field.
     *
     * @return
     */
    public Time truncateAtMonth() {
        this.truncateTime(this, MONTH);
        return this;
    }

    /**
     * Truncate time at week field.
     *
     * @return
     */
    public Time truncateAtWeek() {
        this.truncateTimeByWeek(this);
        return this;
    }

    /**
     * Truncate time at date of month field.
     *
     * @return
     */
    public Time truncateAtDate() {
        this.truncateTime(this, DAY_OF_MONTH);
        return this;
    }

    /**
     * Truncate time at hour field.
     *
     * @return
     */
    public Time truncateAtHour() {
        this.truncateTime(this, HOUR_OF_DAY);
        return this;
    }

    /**
     * Truncate time at minute field.
     *
     * @return
     */
    public Time truncateAtMinute() {
        this.truncateTime(this, MINUTE);
        return this;
    }

    /**
     * Truncate time at second field.
     *
     * @return
     */
    public Time truncateAtSecond() {
        this.truncateTime(this, SECOND);
        return this;
    }

    /**
     * Truncate time at specified Calender field
     *
     * @param time  Time to be truncated
     * @param field Calendar field: YEAR, MONTH, DAYS_OF_MONTH, HOUR, HOUR_OF_DAY, MINUTE, SECOND
     */
    protected void truncateTime(Calendar time, int field) {
        switch (field) {
            case YEAR:
                time.set(MONTH, 0);
            case MONTH:
                time.set(DAY_OF_MONTH, 1);
            case DAY_OF_MONTH:
                time.set(HOUR_OF_DAY, 0);
            case HOUR:
            case HOUR_OF_DAY:
                time.set(MINUTE, 0);
            case MINUTE:
                time.set(SECOND, 0);
            case SECOND:
                time.set(MILLISECOND, 0);
        }
    }

    /**
     * Week is different, so truncate it separately.
     *
     * @param time
     */
    protected void truncateTimeByWeek(Calendar time) {
        time.getTime();// This must be called, otherwise following statement will not be available. Maybe this is a bug.
        time.set(DAY_OF_WEEK, SUNDAY);
        time.set(HOUR_OF_DAY, 0);
        time.set(MINUTE, 0);
        time.set(SECOND, 0);
        time.set(MILLISECOND, 0);
    }

    /**
     * Get year interval from specified time to current time.
     *
     * @param time
     * @return
     */
    public int getYearIntervalFrom(Time time) {
        if (time == null) return 0;
        return this.get(YEAR) - time.get(YEAR);
    }

    /**
     * Get year interval from current time to specified time.
     *
     * @param time
     * @return
     */
    public int getYearIntervalTo(Time time) {
        return 0 - getYearIntervalFrom(time);
    }

    /**
     * Get month interval from specified time to current time.
     *
     * @param time
     * @return
     */
    public int getMonthIntervalFrom(Time time) {
        int yearInterval = getYearIntervalFrom(time);
        return (this.get(MONTH) - time.get(MONTH)) + yearInterval * 12;
    }

    /**
     * Get month interval from current time to specified time.
     *
     * @param time
     * @return
     */
    public int getMonthIntervalTo(Time time) {
        return 0 - getMonthIntervalFrom(time);
    }

    /**
     * Get week interval from specified time to current time.
     *
     * @param time
     * @return
     */
    public int getWeekIntervalFrom(Time time) {
        if (time == null) {
            return 0;
        }
        Calendar s = time.clone().truncateAtWeek();
        Calendar e = this.clone().truncateAtWeek();
        long timeInMillis = e.getTimeInMillis() - s.getTimeInMillis();
        int weekInterval = (int) (timeInMillis / (7 * 24 * 60 * 60 * 1000));
        return weekInterval;
    }

    /**
     * Get week interval from current time to specified time.
     *
     * @param time
     * @return
     */
    public int getWeekIntervalTo(Time time) {
        return 0 - getWeekIntervalFrom(time);
    }

    /**
     * Get day interval from specified time to current time.
     *
     * @param time
     * @return
     */
    public int getDayIntervalFrom(Time time) {
        if (time == null) {
            return 0;
        }
        Calendar s = time.clone().truncateAtDate();
        Calendar e = this.clone().truncateAtDate();
        long timeInMillis = e.getTimeInMillis() - s.getTimeInMillis();
        int millisOfDay = 24 * 60 * 60 * 1000;
        long intervalInDate = timeInMillis / millisOfDay;
        return (int) intervalInDate;
    }

    /**
     * Get day interval from current time to specified time.
     *
     * @param time
     * @return
     */
    public int getDayIntervalTo(Time time) {
        return 0 - getDayIntervalFrom(time);
    }

    /**
     * Get hour interval from specified time to current time.
     *
     * @param time
     * @return
     */
    public int getHourIntervalFrom(Time time) {
        if (time == null) {
            return 0;
        }
        Calendar s = time.clone().truncateAtHour();
        Calendar e = this.clone().truncateAtHour();
        long timeInMillis = e.getTimeInMillis() - s.getTimeInMillis();
        long intervalInHour = timeInMillis / (60 * 60 * 1000);
        return (int) intervalInHour;
    }

    /**
     * Get hour interval from current time to specified time.
     *
     * @param time
     * @return
     */
    public int getHourIntervalTo(Time time) {
        return 0 - getHourIntervalFrom(time);
    }

    /**
     * Get minute interval from specified time to current time.
     *
     * @param time
     * @return
     */
    public int getMinuteIntervalFrom(Time time) {
        if (time == null) {
            return 0;
        }
        Calendar s = time.clone().truncateAtMinute();
        Calendar e = this.clone().truncateAtMinute();
        long timeInMillis = e.getTimeInMillis() - s.getTimeInMillis();
        long ret = timeInMillis / (60 * 1000);
        return (int) ret;
    }

    /**
     * Get minute interval from current time to specified time.
     *
     * @param time
     * @return
     */
    public int getMinuteIntervalTo(Time time) {
        return 0 - getMinuteIntervalFrom(time);
    }

    /**
     * Get second interval from specified time to current time.
     *
     * @param time
     * @return
     */
    public int getSecondIntervalFrom(Time time) {
        if (time == null) {
            return 0;
        }
        Calendar s = time.clone().truncateAtSecond();
        Calendar e = this.clone().truncateAtSecond();
        long timeInMillis = e.getTimeInMillis() - s.getTimeInMillis();
        long ret = timeInMillis / 1000;
        return (int) ret;
    }

    /**
     * Get second interval from current time to specified time.
     *
     * @param time
     * @return
     */
    public int getSecondIntervalTo(Time time) {
        return 0 - getSecondIntervalFrom(time);
    }

    /**
     * Use this method to set time instead of 'set' method of Calendar
     *
     * @param year
     * @param month
     * @param date
     * @param hour
     * @param minute
     * @param second
     */
    public void setTime(int year, int month, int date, int hour, int minute, int second) {
        super.set(year, month, date, hour, minute, second);
    }

    /**
     * Use this method to set time instead of 'set' method of Calendar
     *
     * @param year
     * @param month
     * @param date
     */
    public void setTime(int year, int month, int date) {
        super.set(year, month - 1, date);
    }

    /**
     * Get year of time.
     *
     * @return
     */
    public int getYear() {
        return this.get(YEAR);
    }

    /**
     * Set year of time.
     *
     * @param year
     */
    public void setYear(int year) {
        this.set(YEAR, year);
    }

    /**
     * Get month of time, starts from 1, not 0.
     *
     * @return
     */
    public int getMonth() {
        return this.get(MONTH) + 1;
    }

    /**
     * Set month of time.
     *
     * @param month
     */
    public void setMonth(int month) {
        this.set(MONTH, month - 1);
    }

    /**
     * Get day of time
     *
     * @return
     */
    public int getDate() {
        return this.get(DATE);
    }

    /**
     * Set day of time.
     *
     * @param date
     */
    public void setDate(int date) {
        this.set(DATE, date);
    }

    /**
     * Get hour of time.
     *
     * @return
     */
    public int getHour() {
        return this.get(HOUR_OF_DAY);
    }

    /**
     * Set hour of time.
     *
     * @param hour
     */
    public void setHour(int hour) {
        this.set(HOUR_OF_DAY, hour);
    }

    /**
     * Get minute of time.
     *
     * @return
     */
    public int getMinute() {
        return this.get(MINUTE);
    }

    /**
     * Set minute of time.
     *
     * @param minute
     */
    public void setMinute(int minute) {
        this.set(MINUTE, minute);
    }

    /**
     * Get second of time.
     *
     * @return
     */
    public int getSecond() {
        return this.get(SECOND);
    }

    /**
     * Set second of time.
     *
     * @param second
     */
    public void setSecond(int second) {
        this.set(SECOND, second);
    }

    /**
     * Get the number indicating the day of week.
     * The return value is at the range of
     * <code>SUNDAY</code>,<code>MONDAY</code>, <code>TUESDAY</code>, <code>WEDNESDAY</code>,<code>THURSDAY</code>, <code>FRIDAY</code>, and <code>SATURDAY</code>.
     *
     * @return
     */
    public int getDayOfWeek() {
        return this.get(DAY_OF_WEEK);
    }

    /**
     * Get days of current month.
     * The return value is at the range of
     * <code>SUNDAY</code>,<code>MONDAY</code>, <code>TUESDAY</code>, <code>WEDNESDAY</code>,<code>THURSDAY</code>, <code>FRIDAY</code>, and <code>SATURDAY</code>.
     *
     * @return
     */
    public int getDaysOfCurrentMonth() {
        return getDaysOfMonth(this);
    }

    /**
     * Get days of month for specified time.
     *
     * @param time
     * @return
     */
    public static int getDaysOfMonth(Time time) {
        int year = time.getYear();
        int month = time.getMonth();
        if (month == 2 && time.isLeapYear(year)) {
            return 29;
        }
        return DAYS_OF_MONTH[month];
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + super.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.getTime().toString();
    }
}


