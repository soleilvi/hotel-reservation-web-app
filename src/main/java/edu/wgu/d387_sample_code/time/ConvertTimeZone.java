package edu.wgu.d387_sample_code.time;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

public class ConvertTimeZone {
    private String code = "";
    private LocalDateTime dateTimeAtTimeZone;

    public ConvertTimeZone(String code) {
        this.code = code;
        setTimeZone();
    }

    private void setTimeZone() {
        ZoneId zoneId = switch (code) {
            case "MT" -> ZoneId.of("America/Denver");
            case "ET" -> ZoneId.of("America/New_York");
            case "UTC" -> ZoneId.of("Europe/London");
            default -> throw new IllegalArgumentException("Invalid code: " + code);
        };

        ZoneId localId = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(localId);

        ZonedDateTime zonedDateTimeElsewhere = zonedDateTime.withZoneSameInstant(zoneId);
        dateTimeAtTimeZone = zonedDateTimeElsewhere.toLocalDateTime();
    }

    public String getHourAtTimeZone() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        return dateTimeAtTimeZone.format(formatter);
    }

    public String getMinutesAtTimeZone() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm");
        return dateTimeAtTimeZone.format(formatter);
    }

    public String getHourAtSpecificLocalTime(int desiredLocalHour) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        LocalDateTime localDateTime = LocalDateTime.now();
        int localHour = parseInt(localDateTime.format(formatter));

        int difference;

        if (localHour <= desiredLocalHour) {
            difference = desiredLocalHour - localHour;
        }
        else {
            difference = 24 - localHour + desiredLocalHour;
        }

        return dateTimeAtTimeZone.plusHours(difference).format(formatter);
    }

    public String getCode() { return this.code; }
}
