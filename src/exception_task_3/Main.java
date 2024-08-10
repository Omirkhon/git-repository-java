package exception_task_3;

public class Main {
    public static void main(String[] args) {
        for (Event event: getMovies()) {
            validEvent(event);
        }
        for (Event event: getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события корректны");
    }
    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Начало", 2010, 16),
                new Movie("Побег из Шоушенка", 1994, 18),
                new Movie("Побег в неизвестность", 2017, 16),
                new Movie("Побег из курятника", 2000, 6)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Анна Каренина", 2017, 16),
                new Theatre("Герой нашего времени", 2017, 16),
                new Theatre("АААА", 2011, 16)
        };
    }

    public static void validEvent(Event event) {
        if (event.title == null || event.releaseYear == 0 || event.age == 0) {
            System.out.println(event);
            throw new RuntimeException();
        }
    }
}
