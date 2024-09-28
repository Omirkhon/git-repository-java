package JavaTaskTracker.tests;

import JavaTaskTracker.model.Epic;
import JavaTaskTracker.model.Subtask;
import JavaTaskTracker.service.TaskManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import JavaTaskTracker.model.Task;

public abstract class TaskManagerTest<T extends TaskManager> {
    private final T manager;

    public TaskManagerTest(T manager) {
        this.manager = manager;
    }

    @Test
    void createTaskTest() {
        Task task = new Task(null, null);

        manager.createTask(task);

        Assertions.assertEquals(1, manager.getTasks().size());
    }

    @Test
    void createSubtaskTest() {
        Epic epic = new Epic(null, null);
        Subtask subtask = new Subtask(null, null, epic);

        manager.createSubtask(subtask);

        Assertions.assertEquals(1, manager.getSubtasks().size());
    }

    @Test
    void ShouldNotCreateSubtaskWhenNoEpic() {
        Subtask subtask = new Subtask(null, null, null);

        manager.createSubtask(subtask);
    }

    @Test
    void createEpicTest() {
        Epic epic = new Epic(null, null);

        manager.createEpic(epic);

        Assertions.assertEquals(1, manager.getEpics().size());
    }

    @Test
    void shouldNotRemoveTaskWhenGivenNotCorrectID() {
        int id = 0;

        manager.removeTaskById(id);
    }
}
