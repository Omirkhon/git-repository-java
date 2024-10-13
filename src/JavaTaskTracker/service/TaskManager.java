package JavaTaskTracker.service;

import JavaTaskTracker.model.Epic;
import JavaTaskTracker.model.Subtask;
import JavaTaskTracker.model.Task;

import java.util.List;
import java.util.Map;

public interface TaskManager {
    void compareTasks();
    void removeAll();
    Map<Integer, Task> getTasks();
    Map<Integer, Epic> getEpics();
    Map<Integer, Subtask> getSubtasks();

    Task getTaskById(int id);

    Epic getEpicById(int id);

    Subtask getSubtaskById(int id);

    void update(int id, Task updatedTask);

    void removeTaskById(int id);

    void removeEpicById(int id);

    void removeSubtasksById(int id);

    void createTask(Task task);

    void createEpic(Epic epic);

    void createSubtask(Subtask subtask);

    Map<Integer, Subtask> getSubtasksByEpic(Epic epic);

    int getUniqueId();
    List<Task> getHistory();
}
