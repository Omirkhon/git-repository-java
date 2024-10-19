package JavaTaskTracker.service;

import JavaTaskTracker.model.*;
import JavaTaskTracker.utils.StartTimeComparator;

import java.util.*;

public class InMemoryTaskManager implements TaskManager {
    public Map<Integer, Task> tasks = new HashMap<>();
    public Map<Integer, Epic> epics = new HashMap<>();
    public Map<Integer, Subtask> subtasks = new HashMap<>();
    private int uniqueId = 1;
    public HistoryManager historyManager;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    public List<Task> getPrioritizedTasks() {
        List<Task> listOfTasks = new ArrayList<>();

        listOfTasks.addAll(tasks.values());
        listOfTasks.addAll(epics.values());
        listOfTasks.addAll(subtasks.values());

        Collections.sort(listOfTasks, new StartTimeComparator());
        return listOfTasks;
    }

    public boolean checkIfIntersects(Task task) {
        boolean isIntersection = true;
        List<Task> prioritizedTasks = getPrioritizedTasks();

        if (prioritizedTasks.isEmpty()) {
            return false;
        } else {
            for (Task taskOfTheList : prioritizedTasks) {
                if (task.getStartTime() == null) {
                    isIntersection = false;
                    break;
                }
                if (taskOfTheList.getStartTime() == null) {
                    isIntersection = false;
                    continue;
                }
                if (task.getType() == Type.EPIC || taskOfTheList.getType() == Type.EPIC) {
                    isIntersection = false;
                    continue;
                }
                if (task.getStartTime().isAfter(taskOfTheList.getEndTime())
                        || task.getEndTime().isBefore(taskOfTheList.getStartTime())) {
                    isIntersection = false;
                } else {
                    return true;
                }
            }
        }
        return isIntersection;
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
    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
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
    public void update(int id, Task updatedTask) {
        if (tasks.containsKey(id)) {
            tasks.put(id, updatedTask);
        }
        getPrioritizedTasks();
    }

    @Override
    public void removeTaskById(int id) {
        tasks.remove(id);
    }

    @Override
    public void removeEpicById(int id) {
        epics.remove(id);
    }

    @Override
    public void removeSubtasksById(int id) {
        subtasks.remove(id);
    }

    @Override
    public void createTask(Task task) {
        task.setId(getUniqueId());
        if (!checkIfIntersects(task)) {
            tasks.put(task.getId(), task);
        }
    }

    @Override
    public void createEpic(Epic epic) {
        epic.setId(getUniqueId());

        if (!checkIfIntersects(epic)) {
            epics.put(epic.getId(), epic);
        }
    }

    @Override
    public void createSubtask(Subtask subtask) {
        subtask.setId(getUniqueId());

        if(epics.containsValue(subtask.getEpic())) {
            if (!checkIfIntersects(subtask)) {
                subtasks.put(subtask.getId(), subtask);
            }
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