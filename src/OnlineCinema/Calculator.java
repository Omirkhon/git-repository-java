package OnlineCinema;

import java.util.List;

public class Calculator {
    private Calculator() {}

    public static double calculate(List<MediaItem> mediaItems) {
        double totalRuntime = 0;
        for (MediaItem mediaItem : mediaItems) {
            totalRuntime += mediaItem.getRuntime() ;
        }
        totalRuntime /= 1440;
        // Напишите реализацию метода, который будет возвращать общее количество дней,
        // потраченных на просмотр фильмов и сериалов
        return totalRuntime;
    }
}