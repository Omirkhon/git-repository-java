package time_tasks.task4;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Instant now = Instant.now();

        // укажите корректный формат вывода даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy; HH:mm:ss. ZZZZZ");

        // создайте экземпляр ZoneId для Кызылорды
        ZoneId qyzylordaZone = ZoneId.of("Asia/Qyzylorda");
        ZonedDateTime qyzylordaDateTime = ZonedDateTime.ofInstant(now, qyzylordaZone);

        printTime(formatter, qyzylordaDateTime, "Қызылорда");

        convertAndPrintTime(formatter, qyzylordaDateTime, "Осло", "Europe/Oslo");
        convertAndPrintTime(formatter, qyzylordaDateTime, "Чикаго", "America/Chicago");
        convertAndPrintTime(formatter, qyzylordaDateTime, "Шанхай", "Asia/Shanghai");
        convertAndPrintTime(formatter, qyzylordaDateTime, "Аддис-Абеба", "Africa/Addis_Ababa");
    }

    private static void convertAndPrintTime(DateTimeFormatter formatter, ZonedDateTime qyzylordaDateTime, String cityName, String region) {
        ZoneId newZone = ZoneId.of(region); // создайте ZoneId из region
        ZonedDateTime newDateTime = qyzylordaDateTime.withZoneSameInstant(newZone);

        printTime(formatter, newDateTime, cityName);
    }

    private static void printTime(DateTimeFormatter formatter, ZonedDateTime dateTime, String cityName) {
        System.out.println(cityName + ":");
        // выведите dateTime в указанном в formatter формате
        System.out.println(dateTime.format(formatter));
    }
}
