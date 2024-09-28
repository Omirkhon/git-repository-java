package JavaTaskTracker.service;

import JavaTaskTracker.model.Epic;
import JavaTaskTracker.model.Subtask;
import JavaTaskTracker.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface TaskManager {
    public void removeAll();
    public Map<Integer, Task> getTasks();
    public Map<Integer, Epic> getEpics();
    public Map<Integer, Subtask> getSubtasks();

    public Task getTaskById(int id);

    public Epic getEpicById(int id);

    public Subtask getSubtaskById(int id);

    public void update(int id, Task updatedTask);

    public void removeTaskById(int id);

    public void removeEpicById(int id);

    public void removeSubtasksById(int id);

    public void createTask(Task task);

    public void createEpic(Epic epic);

    public void createSubtask(Subtask subtask);

    public Map<Integer, Subtask> getSubtasksByEpic(Epic epic);

    public int getUniqueId();
    List<Task> getHistory();
}
