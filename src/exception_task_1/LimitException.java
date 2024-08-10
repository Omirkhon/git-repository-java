package exception_task_1;

public class LimitException extends RuntimeException {
    public LimitException (String message) {
        super(message);
    }
}
