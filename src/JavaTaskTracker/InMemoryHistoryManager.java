package JavaTaskTracker;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    @Override
    public void add(Task task) {
        if (history.size()>10) {
            history.remove(0);
        }
        history.add(task);
    }

    @Override
    public List<Task> getHistory() {
        System.out.println("Недавно просмотренные задачи: ");
        return history;
    }
}
