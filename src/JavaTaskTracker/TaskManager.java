package JavaTaskTracker;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    List<Task> history = new ArrayList<>();
    List<Task> getHistory();
}
