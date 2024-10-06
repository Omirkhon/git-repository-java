package JavaTaskTracker.tests;

import JavaTaskTracker.model.Epic;
import JavaTaskTracker.model.Subtask;
import JavaTaskTracker.service.TaskManager;
import org.junit.jupiter.api.Test;
import JavaTaskTracker.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Subtask subtask = new Subtask(null, null, epic);

        manager.createSubtask(subtask);

        assertEquals(1, manager.getSubtasks().size());
    }

    @Test
    void ShouldNotCreateSubtaskWhenNoEpic() {
        Subtask subtask = new Subtask(null, null, null);

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
        String message = manager.removeTaskById(task.getId());

        assertEquals("Задача удалена", message);
    }

    @Test
    void shouldRemoveEpicWhenEverythingIsCorrect() {
        Epic epic = new Epic(null, null);
        manager.createTask(epic);
        String message = manager.removeTaskById(epic.getId());

        assertEquals("Задача удалена", message);
    }

    @Test
    void shouldRemoveTaskWhenGivenNotCorrectID() {
        int id = 0;

        String message = manager.removeTaskById(id);

        assertEquals("Не удалось удалить", message);
    }
}
