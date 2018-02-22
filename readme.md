## SwiftTime 

SwiftTime is a very light weight extension of Java GregorianCalendar class. 
Provides more common operation for you to easily manipulating time but no any other dependencies needed.


## Features
* Easily increase or decrease single fields of time.
* Truncating time.
* Month starts with 1 not 0 by GregorianCalendar default.


## Tutorial

#### Construct
You can construct your new time simply by:
```java
// t is just current time whose value is the same to System.currentTimeMillis().
Time t = new Time();
```

or from other time objects:
```java
java.util.Date date = new java.util.Date();
...
Time t = new Time(date);
```

of course by fields of time:
```java
Time t = new Time(2018, 02, 13, 22, 06, 30);
```
> if the hour, minute, second fields is not given, their default value will be 0.
> if the dayOfMonth is not given, the default value is 1
> if the month is not given, the default value is 1, which means January.

#### Increase or decrease single field of time
Increase or decrease time become more simple and straightforward:
```java
// Increase 3 years
t.increaseYears(3);

// Decrease 8 hours
t.increaseHours(-8);
```


#### Truncate time
Usually you need to get the precise second of a imprecise time, for example:
Get the first day of this month but hour, minute and second be truncated to 00:00:00 .
It is easy to do so now:
```java
Time t = new Time(); //current time is 2018-02-13 22:06:30 for example
t.truncateAtMonth();
System.out.println(t);
> Thu Feb 01 00:00:00 CST 2018

```

#### Interval for fields
Calculate time interval by single time field is tedious because you have to consider the carry of time field.
By SwiftTime you can easily get interval from one Time to another for any single field of time:
```java
Time t1 = new Time(2018);
Time t2 = new Time(2000);
t1.getYearIntervalFrom(t2);
System.out.println(t);
> 18
```
of course other fields of time can be done as well.


#### Set time
* Set time to the first day of this week
```java
t.setToFirstDayOfThisWeek();
```

* Set time to the last day of this week
```java
t.setToLastDayOfThisWeek();
```


#### Combination
You can use methods of Time combined to get useful effect, eg:

```java

// get the first second of specified day of month
t.setDate(3).truncateAtHour();

// get the first second of the first day of this week
t.setToFirstDayOfThisWeek().truncateAtHour();
```


#### Misc
```java
// get days of month
Time.getDaysOfThisMonth(t);


```