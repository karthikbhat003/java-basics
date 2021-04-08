package com.company;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.function.Consumer;
import org.junit.Test;
import com.google.common.base.Strings;

public class TimeTest {
    @Test
    public void convertTimestamp() {
        System.out.println(TimeZone.getDefault());
        /*
          toInstant will return the time of UTC.
          So have to convert it back to the required zone
         */
        System.out.println(new Timestamp(System.currentTimeMillis()).toInstant().atZone(TimeZone.getDefault().toZoneId()));

        System.out.println(new Timestamp(System.currentTimeMillis()).toLocalDateTime());

        System.out.println(new Timestamp(System.currentTimeMillis()).toInstant().atZone(ZoneId
                .of(Arrays.stream(TimeZone.getAvailableIDs()).findFirst().orElse(""))).toLocalTime());

        System.out.println(new Timestamp(System.currentTimeMillis()).toInstant().atZone(ZoneId.of("Asia/Jakarta")).toLocalTime());

        System.out.println(getZonedTime(TimeZone.getTimeZone("Asia/Jakarta"), new Timestamp(System.currentTimeMillis())));

        System.out.println(Timestamp.from(Instant.now()));

    }

    public static Timestamp getZonedTime(final TimeZone timeZone, final Timestamp startTimeStamp) {
        System.out.println(Timestamp.valueOf(startTimeStamp.toInstant().atZone(timeZone.toZoneId()).toLocalDateTime()));
        return Timestamp.from(startTimeStamp.toInstant().atZone(timeZone.toZoneId()).toInstant());
    }

    @Test
    public void dateTest() {
        final LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.toInstant(ZoneId.of("Asia/Jakarta").getRules().getOffset(localDateTime)));
        System.out.println(localDateTime.atZone(ZoneId.of("Asia/Jakarta")));
    }

    @Test
    public void testToInstant() {
        final ZonedDateTime indianZonedTime = new Timestamp(System.currentTimeMillis()).toInstant()
                                                                                       .atZone(TimeZone.getTimeZone("Asia/Kolkata").toZoneId());

        System.out.println(indianZonedTime);
        final ZonedDateTime jakartaZonedTime = new Timestamp(System.currentTimeMillis()).toInstant()
                                                                                        .atZone(TimeZone.getTimeZone("Asia/Jakarta").toZoneId());

        System.out.println(jakartaZonedTime);
        System.out.println("To instant indian zone time: " + indianZonedTime.toInstant());
        System.out.println("To instant jakarta zone time: " + jakartaZonedTime.toInstant());
        System.out.println(indianZonedTime.toInstant().atZone(TimeZone.getTimeZone("America/Chicago").toZoneId()).toInstant());
        System.out.println(jakartaZonedTime.toInstant().atZone(TimeZone.getTimeZone("America/Chicago").toZoneId()).toInstant());
    }

    @Test
    public void testIt(){
        checkIfEmpty("", System.out::println);
        checkIfEmpty("test", System.out::println);
    }

    private void checkIfEmpty(final String value, final Consumer<String> function){
        if(!Strings.isNullOrEmpty(value)){
            function.accept(value);
        }
    }
}
