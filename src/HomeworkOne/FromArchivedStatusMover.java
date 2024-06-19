package HomeworkOne;

public class FromArchivedStatusMover extends BookMover {
    @Override
    protected void moveToStatus(Book book, Status requestedStatus) {
        if(requestedStatus != Status.OVERDUED & requestedStatus != Status.BORROWED) {
            super.moveToStatus(book, requestedStatus);
        } else {
            System.out.println("Unavailable");
        }
    }
}
