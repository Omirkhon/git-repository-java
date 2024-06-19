package HomeworkOne;

public class FromAvailableStatusMover extends BookMover {
    @Override
    protected void moveToStatus(Book book, Status requestedStatus) {
        if(requestedStatus != Status.OVERDUED) {
            super.moveToStatus(book, requestedStatus);
        } else {
            System.out.println("Unavailable");
        }
    }
}
