package com.company;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.Test;

public class DateAndTime {
    @Test
    public void timeZoneTest() {
        // get all the  timezones ids defined by TimeZone class
        String[] availableTimezones = TimeZone.getAvailableIDs();

        // Print Total no of TimeZones
        System.out.println("Total No of Time Zone Available");
        System.out.println(availableTimezones.length);

        // get all the  timezones  whose offset is
        // 7200000 milliseconds means 2 hour
        String[] timezones = TimeZone.getAvailableIDs(7200000);

        // Print Total no of TimeZones
        System.out.println("No of Time Zone having time offset 2 hour");
        System.out.println(timezones.length);

        // print all timezones names
        System.out.println("Timezone names having time offset 2 hour");
        for (String timezone : timezones) {
            System.out.println(timezone);
        }
    }

    @Test
    public void testDefaultTimeZone() {
        // Get your Local Time Zone Where this Program is Running.
        TimeZone timezone = TimeZone.getDefault();

        // Get the Name of Time Zone
        String LocalTimeZoneDisplayName = timezone.getDisplayName();

        // Print the Name of Time Zone
        System.out.println(LocalTimeZoneDisplayName + " \nAnd Id Is: " + timezone.getID());
    }

    @Test
    public void testDSTOfTimeZone() {
        // creating Timezone object whose id is Europe/Berlin
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        // printing the Display Name of this timezone object
        System.out.println("Display Name: " + timezone.getDisplayName());

        System.out.println("\nDST of Europe/Berlin is");
        System.out.println(timezone.getDSTSavings());
    }

    @Test
    public void testOffsetOfTimeZone() {
        // creating Timezone object whose id is Europe/Berlin
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        // printing offset value
        System.out.println("Offset value of Europe/Berlin: " + timezone.getOffset(Calendar.ZONE_OFFSET));
    }

    @Test
    public void testIfTheTimeZoneIsInDayAtTheMoment() {
        // creating Timezone object whose id is Europe/Berlin
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        // printing offset value
        System.out.println("Offset value of Europe/Berlin: " + timezone.getOffset(Calendar.ZONE_OFFSET));

        // create Date Object
        Date date = new Date(2017, Calendar.MAY, 16);

        System.out.println("The date is: " + date);

        // checking the date is in day light time of that Time Zone or not
        System.out
                .println("\nDate 16/04/2017 is in Day Light Time of TimeZone: " + timezone.getDisplayName() + " = " + timezone.inDaylightTime(date));
    }

    @Test
    public void changeIdOfTimeZone() {
        // My previous Default Time Zone is
        TimeZone DefaultTimeZone = TimeZone.getDefault();

        System.out.println("Current Default TimeZone: " + DefaultTimeZone.getDisplayName());

        // Setting  Europe/Berlin as your Default Time Zone
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        TimeZone.setDefault(timezone);
        TimeZone NewDefaultTimeZone = TimeZone.getDefault();
        System.out.println("\nNew Default TimeZone: " + NewDefaultTimeZone.getDisplayName());

        // change Id Europe/Berlin to Eur/Ber
        timezone.setID("Eur/Ber");

        System.out.println("\nNew Id of Europe/Berlin is: " + timezone.getID());
    }

    @Test
    public void cloneTimeZone() {
        TimeZone timezone = TimeZone.getTimeZone("Europe/Berlin");

        // create copy of a time zone
        System.out.println("\nOriginal TimeZone ID: " + timezone.getID());

        TimeZone clonedTimezone = (TimeZone) timezone.clone();
        System.out.println("Cloned TimeZone ID: " + clonedTimezone.getID());
    }

    @Test
    public void testCalculateDifferenceBetweenTimeInTwoZones() {
        // Using Id of First place find LocalDateTime of that place
        TimeZone timezone1 = TimeZone.getTimeZone("Europe/Berlin");

        LocalDateTime dateTime1 = getLocalDateTime(timezone1);

        // Using Id of Second place find LocalDateTime of that place
        TimeZone timezone2 = TimeZone.getTimeZone("Asia/Kolkata");

        LocalDateTime dateTime2 = getLocalDateTime(timezone2);

        // Print the Date and Time of Both TimeZones
        System.out.println(
                "Date and Time of place having Id Europe/Berlin" + "\nDate - " + dateTime1.toLocalDate() + "\nTime - " + dateTime1.toLocalTime());
        System.out.println(
                "Date and Time of place having Id Asia/Kolkata" + "\nDate - " + dateTime2.toLocalDate() + "\nTime - " + dateTime2.toLocalTime());

        // Find the Difference in terms of minutes between both places
        long diffInMinutes = java.time.Duration.between(dateTime1, dateTime2).toMinutes();
        System.out.println("\nDifference in Hour is " + Math.abs(diffInMinutes / 60));
        System.out.println("Difference in Minute is " + Math.abs(diffInMinutes % 60));
    }

    @Test
    public void testDate() {
        Timestamp timestamp= new Timestamp(System.currentTimeMillis());
        System.out.println(Date.from(timestamp.toInstant()));

        Date d1 = new Date(2000, Calendar.DECEMBER, 21);
        Date d2 = new Date();  // Current date
        Date d3 = new Date(2010, Calendar.FEBRUARY, 3);

        boolean a = d3.after(d1);
        System.out.println("Date d3 comes after date d2: " + a);

        boolean b = d3.before(d2);
        System.out.println("Date d3 comes before date d2: " + b);

        int c = d1.compareTo(d2);
        System.out.println(c);

        System.out.println("Milliseconds from Jan 1 1970 to date d1 is " + d1.getTime());

        System.out.println("Before setting " + d2);
        d2.setTime(204587433443L);
        System.out.println("After setting " + d2);
    }

    private LocalDateTime getLocalDateTime(TimeZone time) {

        // Using Time zone get calender object
        Calendar cal = new GregorianCalendar(time);

        // using calender object find the month, year, day, hour, minute
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        /*
         * construct LocalDateTime object
        using month, year, day, hour, minute
        */

        return LocalDateTime.of(year, month + 1, day, hour, minute);
    }
}
