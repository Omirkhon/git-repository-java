package JavaTaskTracker.tests;

import JavaTaskTracker.model.Task;
import JavaTaskTracker.service.HistoryManager;
import JavaTaskTracker.service.InMemoryHistoryManager;
import JavaTaskTracker.service.InMemoryTaskManager;
import JavaTaskTracker.service.TaskManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryManagerTest {
    HistoryManager historyManager = new InMemoryHistoryManager();
    private final TaskManager manager = new InMemoryTaskManager(historyManager);
    @Test
    public void shouldAddWhenEverythingIsCorrect() {
        Task task = new Task(null, null);
        manager.createTask(task);

        historyManager.add(task);

        assertEquals(historyManager.getTasks().get(historyManager.getTasks().size()-1), task);
    }
}
