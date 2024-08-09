package JavaTaskTracker;

import java.util.ArrayList;
import java.util.List;

public interface HistoryManager {
    List<Task> history = new ArrayList<>();
    public void linkLast(Task task);
    public List<Task> getTasks();
    public void removeNode(Node node);
    void remove(int id);
    public void add(Task task);
    List<Task> getHistory();
}
