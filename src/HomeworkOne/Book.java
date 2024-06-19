package HomeworkOne;

public class Book {
    String title;
    Status status;
    public Book(String title) {
        this.title = title;
    }

    public Status getStatus(Book book) {
        return book.status;
    }
}
