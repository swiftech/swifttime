package com.github.swiftech.swifttime;

import java.util.TimeZone;

/**
 * Time span
 */
public class TimeSpan {
	protected Time from;
	protected Time to;

	public TimeSpan() {
	}

	/**
	 * @param from
	 * @param to
	 */
	public TimeSpan(Time from, Time to) {
		this.from = from;
		this.to = to;
	}

	/**
	 * Set to same date
	 *
	 * @param date
	 */
	public void setDate(int date) {
		if (this.from == null || this.to == null) {
			return;
		}
		this.from.setDate(date);
		this.to.setDate(date);
	}

    /**
     * Whether contains a time
     * @param t
     * @return
     */
	public boolean contains(Time t) {
		if (from == null || to == null) {
			return false;
		}
		return t.getTimeInMillis() >= from.getTimeInMillis() && t.getTimeInMillis() <= to.getTimeInMillis();
	}

	@Override
	protected TimeSpan clone() throws CloneNotSupportedException {
		if (from == null || to == null) {
			return null; // 未验证
		}
		TimeSpan newTs = new TimeSpan();
		newTs.setFrom(this.getFrom().clone());
		newTs.setTo(this.getTo().clone());
		return newTs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TimeSpan timeSpan = (TimeSpan) o;

		if (!from.equals(timeSpan.from))
			return false;
		return to.equals(timeSpan.to);
	}

	@Override
	public int hashCode() {
		int result = from.hashCode();
		result = 37 * result + to.hashCode();
		return result;
	}

	@Override
	public String toString() {
		if (from == null || to == null) {
			return "N/A";
		}
		return String.format("{gmt=%s, from=%d:%d, to=%d:%d}", from.getTimeZone().getID(), from.getHour(), from.getMinute(), to.getHour(), to.getMinute());
	}

	public String toStringLocal() {
		if (from == null || to == null) {
			return "N/A";
		}
		Time fromLocal = from.clone();
		Time toLocal = to.clone();
		fromLocal.setTimeZone(TimeZone.getDefault());
		toLocal.setTimeZone(TimeZone.getDefault());
		return String.format("{gmt=%s, from=%d:%d, to=%d:%d}", fromLocal.getTimeZone().getID(), fromLocal.getHour(), fromLocal.getMinute(), toLocal.getHour(), toLocal.getMinute());
	}

	public Time getFrom() {
		return from;
	}

	public void setFrom(Time from) {
		this.from = from;
	}

	public Time getTo() {
		return to;
	}

	public void setTo(Time to) {
		this.to = to;
	}
}
