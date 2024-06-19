package HomeworkOne;

public class FromOverduedStatusMover extends BookMover{
    @Override
    protected void moveToStatus(Book book, Status requestedStatus) {
        if(requestedStatus != Status.BORROWED) {
            super.moveToStatus(book, requestedStatus);
        } else {
            System.out.println("Unavailable");
        }
    }
}
