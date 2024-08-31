package JavaTaskTracker;

import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private int uniqueId = 1;
    public static HistoryManager historyManager = new InMemoryHistoryManager();

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
    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    @Override
    public Task getTaskById(int id) {
        if (tasks.containsKey(id) && !tasks.isEmpty()) {
            historyManager.add(tasks.get(id));
            return tasks.get(id);
        }
            return null;
    }

    @Override
    public Epic getEpicById(int id) {
        if (epics.containsKey(id) && !epics.isEmpty()) {
            historyManager.add(epics.get(id));
            return epics.get(id);
        }
        return null;
    }

    @Override
    public Subtask getSubtaskById(int id) {
        if (subtasks.containsKey(id) && !subtasks.isEmpty()) {
            historyManager.add(subtasks.get(id));
            return subtasks.get(id);
        }
        return null;
    }

    @Override
    public void update(int id, Task updatedTask) {
        if (tasks.containsKey(id)) {
            tasks.put(id, updatedTask);
            historyManager.add(updatedTask);
            return;
        }
        System.out.println("Не удалось обновить");
    }

    @Override
    public void removeTaskById(int id) {
        if (tasks.containsKey(id)) {
            historyManager.add(tasks.get(id));
            tasks.remove(id);
            return;
        }
        System.out.println("Не удалось удалить");
    }

    @Override
    public void removeEpicById(int id) {
        if (epics.containsKey(id)) {
            historyManager.add(epics.get(id));
            epics.remove(id);
            return;
        }
        System.out.println("Не удалось удалить");
    }

    @Override
    public void removeSubtasksById(int id) {
        if (subtasks.containsKey(id)) {
            historyManager.add(subtasks.get(id));
            subtasks.remove(id);
            return;
        }
        System.out.println("Не удалось удалить");
    }

    @Override
    public void createTask(Task task) {
        tasks.put(getUniqueId(), task);
        historyManager.add(task);
    }

    @Override
    public void createEpic(Epic epic) {
        epics.put(getUniqueId(), epic);
        historyManager.add(epic);
    }

    @Override
    public void createSubtask(Subtask subtask) {
        if(epics.containsValue(subtask.getEpic())) {
            subtasks.put(getUniqueId(), subtask);
            historyManager.add(subtask);
        }
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