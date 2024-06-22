package tech.patricknicezi.Spring.Store.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String parseOffsetDateTimeToString(java.time.OffsetDateTime date) {
        final var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return date.format(formatter);
    }

    public static OffsetDateTime parseStringDateTimeToOffsetDateTime(String string) {
        final var dateTime = LocalDateTime.parse(string);
        return OffsetDateTime.of(dateTime, ZoneOffset.UTC);
    }
}
