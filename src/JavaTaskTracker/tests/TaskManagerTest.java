package JavaTaskTracker.tests;

import JavaTaskTracker.model.Epic;
import JavaTaskTracker.model.Subtask;
import JavaTaskTracker.service.HistoryManager;
import JavaTaskTracker.service.InMemoryHistoryManager;
import JavaTaskTracker.service.InMemoryTaskManager;
import JavaTaskTracker.service.TaskManager;
import org.junit.jupiter.api.Test;
import JavaTaskTracker.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class TaskManagerTest<T extends TaskManager> {
    private final T manager;

    public TaskManagerTest(T manager) {
        this.manager = manager;
    }

    @Test
    void createTaskTest() {
        Task task = new Task(null, null);

        manager.createTask(task);

        assertEquals(1, manager.getTasks().size());
    }

    @Test
    void createSubtaskTest() {
        Epic epic = new Epic(null, null);
        manager.createEpic(epic);

        Subtask subtask = new Subtask(null, null, epic);
        manager.createSubtask(subtask);

        assertEquals(1, manager.getSubtasks().size());
    }

    @Test
    void ShouldNotCreateSubtaskWhenNoEpic() {
        Epic epic = new Epic(null, null);

        Subtask subtask = new Subtask(null, null, epic);

        manager.createSubtask(subtask);

        assertEquals(0, manager.getSubtasks().size());
    }

    @Test
    void createEpicTest() {
        Epic epic = new Epic(null, null);

        manager.createEpic(epic);

        assertEquals(1, manager.getEpics().size());
    }

    @Test
    void shouldRemoveTaskWhenEverythingIsCorrect() {
        Task task = new Task(null, null);
        manager.createTask(task);

        manager.removeTaskById(1);

        assertEquals(0, manager.getTasks().size());
    }

    @Test
    void shouldNotRemoveTaskWhenGivenNotCorrectID() {
        Task task = new Task(null, null);
        manager.createTask(task);

        manager.removeTaskById(2);

        assertEquals(1, manager.getTasks().size());
    }

    @Test
    void shouldRemoveEpicWhenEverythingIsCorrect() {
        Epic epic = new Epic(null, null);
        manager.createEpic(epic);

        manager.removeEpicById(1);

        assertEquals(0, manager.getEpics().size());
    }

    @Test
    void shouldNotRemoveEpicWhenGivenNotCorrectID() {
        Epic epic = new Epic(null, null);
        manager.createEpic(epic);

        manager.removeEpicById(2);

        assertEquals(1, manager.getEpics().size());
    }

    @Test
    void shouldRemoveSubtaskWhenEverythingIsCorrect() {
        Epic epic = new Epic(null, null);
        manager.createEpic(epic);

        Subtask subtask = new Subtask(null, null, epic);
        manager.createSubtask(subtask);

        manager.removeSubtasksById(2);

        assertEquals(0, manager.getSubtasks().size());
    }

    @Test
    void shouldNotRemoveSubtaskWhenGivenNotCorrectID() {
        Epic epic = new Epic(null, null);
        manager.createEpic(epic);

        Subtask subtask = new Subtask(null, null, epic);
        manager.createSubtask(subtask);

        manager.removeSubtasksById(4);

        assertEquals(1, manager.getSubtasks().size());
    }

    @Test
    void shouldReturnTaskWhenEverythingIsCorrect() {
        HistoryManager historyManager = new InMemoryHistoryManager();

        TaskManager newManager = new InMemoryTaskManager(historyManager);

        Task task = new Task(null, null);
        newManager.createTask(task);

        assertEquals(task, newManager.getTaskById(1));
    }

    @Test
    void shouldReturnNullWhenTaskNotFound() {
        assertNull(manager.getTaskById(1));
    }

    @Test
    void shouldReturnEpicWhenEverythingIsCorrect() {
        HistoryManager historyManager = new InMemoryHistoryManager();

        TaskManager newManager = new InMemoryTaskManager(historyManager);

        Epic epic = new Epic(null, null);
        newManager.createEpic(epic);

        assertEquals(epic, newManager.getEpicById(1));
    }

    @Test
    void shouldReturnNullWhenEpicNotFound() {
        assertNull(manager.getEpicById(1));
    }

    @Test
    void shouldReturnSubtaskWhenEverythingIsCorrect() {
        HistoryManager historyManager = new InMemoryHistoryManager();

        TaskManager newManager = new InMemoryTaskManager(historyManager);

        Epic epic = new Epic(null, null);
        Subtask subtask = new Subtask(null, null, epic);
        newManager.createSubtask(subtask);

        assertEquals(subtask, newManager.getSubtaskById(1));
    }

    @Test
    void shouldReturnNullWhenSubtaskNotFound() {
        assertNull(manager.getSubtaskById(1));
    }

    @Test
    void shouldUpdateWhenEverythingIsCorrect() {
        Task task = new Task(null, null);
        manager.createTask(task);

        Task updatedTask = new Task("aaa", "uuu");
        manager.update(task.getId(), updatedTask);

        assertEquals(updatedTask, manager.getTasks().get(task.getId()));
    }
}
