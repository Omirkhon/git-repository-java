package time_tasks.task3;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Watch watch = new Watch();

        watch.changeTimeZone();
        watch.changeTimeZone();

        watch.addTenHours();

        for (int i = 0; i < 8; i++) {
            watch.addHour();
        }

        watch.addTenMinutes();
        watch.addTenMinutes();

        for (int i = 0; i < 6; i++) {
            watch.addMinute();
        }

        System.out.println(watch.getCurrentTime());
    }
}

class Watch {
    private ZonedDateTime currentTime;
    private int numOfZone;
    private final List<String> zones = Arrays.asList("America/New_York", "Asia/Qyzylorda", "Asia/Atyrau");

    public Watch() {
        numOfZone = 0;
        ZoneId zone = ZoneId.of(zones.get(numOfZone));
        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 12, 0, 0);
        currentTime = ZonedDateTime.of(dateTime, zone);
    }

    public void changeTimeZone() {
        numOfZone = (numOfZone + 1) % 3;
        ZoneId newZone = ZoneId.of(zones.get(numOfZone));
        currentTime = currentTime.withZoneSameLocal(newZone);
    }

    public void addTenHours() {
        currentTime = ZonedDateTime.of(currentTime.toLocalDateTime().plusHours(10), currentTime.getZone());
    }

    public void addHour() {
        currentTime = ZonedDateTime.of(currentTime.toLocalDateTime().plusHours(1), currentTime.getZone());
    }

    public void addTenMinutes() {
        currentTime = ZonedDateTime.of(currentTime.toLocalDateTime().plusMinutes(10), currentTime.getZone());
    }

    public void addMinute() {
        currentTime = ZonedDateTime.of(currentTime.toLocalDateTime().plusMinutes(1), currentTime.getZone());
    }

    public ZonedDateTime getCurrentTime() {
        return currentTime;
    }
}
