package JavaTaskTracker;

import java.util.List;
import java.util.ArrayList;

public class InMemoryTaskManager implements TaskManager{
    private int uniqueId = 1;
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Epic> epics = new ArrayList<>();
    private ArrayList<Subtask> subtasks = new ArrayList<>();
    private HistoryManager historyManager;

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Epic> getEpics() {
        return epics;
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void removeAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (id == task.getId()) {
                historyManager.add(task);
                return task;
            }
        }
        return null;
    }

    public Epic getEpicById(int id) {
        for (Epic epic : epics) {
            if (id == epic.getId()) {
                historyManager.add(epic);
                return epic;
            }
        }
        return null;
    }

    public Subtask getSubtaskById(int id) {
        for (Subtask subtask : subtasks) {
            if (id == subtask.getId()) {
                historyManager.add(subtask);
                return subtask;
            }
        }
        return null;
    }

    public void update(int id, Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id){
                task = updatedTask;
                return;
            }
        }
    }

    public void removeTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                return;
            }
        }
    }

    public void removeEpicById(int id) {
        for (Subtask subtask : subtasks) {
            if (subtask.getEpic() == epics.get(id)) {
                subtasks.remove(subtask);
                return;
            }
        }
        for (Epic epic : epics) {
            if (epic.getId() == id) {
                epics.remove(epic);
                return;
            }
        }
    }

    public void removeSubtasksById(int id) {
        for (Subtask subtask : subtasks)  {
            if (subtask.getId() == id) {
                subtasks.remove(subtask);
                return;
            }
        }
    }

    public void createTask(Task task) {
        task.setId(getUniqueId());
        tasks.add(task);
    }

    public void createEpic(Epic epic) {
        epic.setId(getUniqueId());
        epics.add(epic);
    }

    public void createSubtask(Subtask subtask) {
        if(epics.contains(subtask.getEpic())) {
            subtask.setId(getUniqueId());
            subtasks.add(subtask);
        }
    }

    public ArrayList<Subtask> getSubtasksByEpic(Epic epic) {
        return epic.getSubtasks();
    }

    private int getUniqueId() {
        return uniqueId++;
    }

    @Override
    public List<Task> getHistory() {
        System.out.println("Недавно просмотренные задачи: ");
        return history;
    }
}
