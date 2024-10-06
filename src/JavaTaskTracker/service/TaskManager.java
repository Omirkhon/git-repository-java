package JavaTaskTracker.service;

import JavaTaskTracker.model.Epic;
import JavaTaskTracker.model.Subtask;
import JavaTaskTracker.model.Task;

import java.util.List;
import java.util.Map;

public interface TaskManager {
    String removeAll();
    Map<Integer, Task> getTasks();
    Map<Integer, Epic> getEpics();
    Map<Integer, Subtask> getSubtasks();

    Task getTaskById(int id);

    Epic getEpicById(int id);

    Subtask getSubtaskById(int id);

    String update(int id, Task updatedTask);

    String removeTaskById(int id);

    String removeEpicById(int id);

    String removeSubtasksById(int id);

    String createTask(Task task);

    String createEpic(Epic epic);

    String createSubtask(Subtask subtask);

    Map<Integer, Subtask> getSubtasksByEpic(Epic epic);

    int getUniqueId();
    List<Task> getHistory();
}
