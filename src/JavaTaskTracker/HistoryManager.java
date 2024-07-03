package JavaTaskTracker;

import java.util.ArrayList;
import java.util.List;

public interface HistoryManager {
    List<Task> history = new ArrayList<>();

    public void add(Task task);
    List<Task> getHistory();
}
