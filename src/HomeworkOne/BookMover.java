package HomeworkOne;

public class BookMover {
    protected void moveToStatus(Book book, Status requestedStatus) {
        System.out.println("Moving status...");
        book.status = requestedStatus;
    }
}
