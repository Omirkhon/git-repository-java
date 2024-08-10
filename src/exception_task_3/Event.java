package exception_task_3;

public abstract class Event {
    String title;
    int releaseYear;
    int age;
    public Event (String title, int releaseYear, int age) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.age = age;
    }

    @Override
    public String toString () {
        return "title: " + title + ", releaseYear" + releaseYear + "age: " + age;
    }
}
