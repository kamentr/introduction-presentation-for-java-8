package introduction.java.features.presentation.datetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * The new Time API provides better (in essentially any way)
 * solutions for keeping time and date
 * <p>
 * Main benefits are:
 * 1. Ease of use
 * 2. Thread safety
 * 3. Immutability (every class inside java.time is immutable)
 * <p>
 * "Date is obsolete and should no longer be used in new code."
 * - Effective Java Item 17
 */
@SuppressWarnings("ALL")
public class DateAndTimeApi {
    public static void main(String[] args) {
        howToUseLocalDateTimeApi();
    }

    private static void howToUseLocalDateTimeApi() {
        // Current date
        LocalDate date = LocalDate.now();
        System.out.println("the current date is " +
                date);


        // Current time
        LocalTime time = LocalTime.now();
        System.out.println("the current time is " +
                time);


        // Current time and date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : " +
                current);


        // Particular format
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = current.format(format);

        System.out.println("in formatted manner " +
                formattedDateTime);

        // Tomorrow
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow);

        // Subtracts one month (you can choose a different ChronoUnit)
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println(previousMonthSameDay);

        // Is the year leap year
        boolean leapYear = LocalDate.now().isLeapYear();

        // Is after or before another date
        boolean isBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));

        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));

        // Printing months days and seconds
        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println("Month : " + month + " day : " +
                day + " seconds : " + seconds);

        // Printing some specified date
        LocalDate date2 = LocalDate.of(1950, 1, 26);
        System.out.println("the republic day :" + date2);

        // Printing date with current time.
        LocalDateTime specificDate =
                current.withDayOfMonth(24).withYear(2016);

        System.out.println("specific date with " +
                "current time : " + specificDate);
    }
}
