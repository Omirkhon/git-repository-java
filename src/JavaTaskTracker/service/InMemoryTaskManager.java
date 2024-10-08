package JavaTaskTracker.service;

import JavaTaskTracker.model.Epic;
import JavaTaskTracker.model.Subtask;
import JavaTaskTracker.model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    public Map<Integer, Task> tasks = new HashMap<>();
    public Map<Integer, Epic> epics = new HashMap<>();
    public Map<Integer, Subtask> subtasks = new HashMap<>();
    private int uniqueId = 1;
    public HistoryManager historyManager;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public Map<Integer, Epic> getEpics() {
        return epics;
    }

    @Override
    public Map<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public String removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
        return "Все задачи успешно удалены";
    }

    @Override
    public Task getTaskById(int id) {
        if (tasks.containsKey(id)) {
            historyManager.add(tasks.get(id));
            return tasks.get(id);
        }
            return null;
    }

    @Override
    public Epic getEpicById(int id) {
        if (!epics.isEmpty() && epics.containsKey(id)) {
            historyManager.add(epics.get(id));
            return epics.get(id);
        }
        return null;
    }

    @Override
    public Subtask getSubtaskById(int id) {
        if (!subtasks.isEmpty() && subtasks.containsKey(id)) {
            historyManager.add(subtasks.get(id));
            return subtasks.get(id);
        }
        return null;
    }

    @Override
    public String update(int id, Task updatedTask) {
        if (tasks.containsKey(id)) {
            tasks.put(id, updatedTask);
            return "Задача обновлена";
        }
        return "Не удалось обновить";
    }

    @Override
    public String removeTaskById(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return "Задача удалена";
        }
        return "Не удалось удалить";
    }

    @Override
    public String removeEpicById(int id) {
        if (epics.containsKey(id)) {
            epics.remove(id);
            return "Задача удалена";
        }
        return "Не удалось удалить";
    }

    @Override
    public String removeSubtasksById(int id) {
        if (subtasks.containsKey(id)) {
            subtasks.remove(id);
            return "Задача удалена";
        }
        return "Не удалось удалить";
    }

    @Override
    public String createTask(Task task) {
        task.setId(getUniqueId());
        tasks.put(task.getId(), task);
        return "Задача создана";
    }

    @Override
    public String createEpic(Epic epic) {
        epic.setId(getUniqueId());
        epics.put(epic.getId(), epic);
        return "Задача создана";
    }

    @Override
    public String createSubtask(Subtask subtask) {
        subtask.setId(getUniqueId());
        if(epics.containsValue(subtask.getEpic())) {
            subtasks.put(subtask.getId(), subtask);
            return "Задача создана";
        }
        return "Не удалось создать";
    }

    @Override
    public Map<Integer, Subtask> getSubtasksByEpic(Epic epic) {
        return epic.getSubtasks();
    }

    @Override
    public int getUniqueId() {
        return uniqueId++;
    }

    @Override
    public List<Task> getHistory() {
        return historyManager.getHistory();
    }
}