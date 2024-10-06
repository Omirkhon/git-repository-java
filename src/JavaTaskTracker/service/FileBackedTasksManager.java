package JavaTaskTracker.service;

import JavaTaskTracker.utils.*;
import JavaTaskTracker.model.*;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileBackedTasksManager extends InMemoryTaskManager {


    private static final String FILE_PATH = "src/JavaTaskTracker/task_tracker_directory/tasks.csv";
    Path path;

    public FileBackedTasksManager(Path path, HistoryManager historyManager) {
        super(historyManager);
        this.path = path;
    }

    public static void main(String[] args) {
        FileBackedTasksManager fileBackedTasksManager = loadFromFile(Path.of(FILE_PATH));
        System.out.println(fileBackedTasksManager.tasks);
    }
    public void save() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            for (Map.Entry<Integer, Task> task : tasks.entrySet()) {
                fileWriter.write(toString(task.getValue()));
                fileWriter.write("\n");
            }
            for (Map.Entry<Integer, Epic> epic : epics.entrySet()) {
                fileWriter.write(toString(epic.getValue()));
                fileWriter.write("\n");
            }
            for (Map.Entry<Integer, Subtask> subtask : subtasks.entrySet()) {
                fileWriter.write(toString(subtask.getValue()));
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException exception) {
            throw new ManagerSaveException();
        }
    }

    public Task fromString(String value) {
        String[] split = value.split(",");
        Task task;
        if (split[1].equals(Type.TASK.name())) {
            task = new Task(split[2], split[4]);
            task.setType(Type.TASK);
        } else if (split[1].equals(Type.EPIC.name())) {
            task = new Epic(split[2], split[4]);
            task.setType(Type.EPIC);
        } else if (split[1].equals(Type.SUBTASK.name())) {
            task = new Subtask(split[2], split[4], getEpics().get(Integer.parseInt(split[5])));
            task.setType(Type.SUBTASK);
        } else {
            return null;
        }
        task.setId(Integer.parseInt(split[0]));
        task.setStatus(split[3].equals(Status.DONE.name()) ? Status.DONE : split[1].equals(Status.NEW.name()) ? Status.NEW : split[1].equals(Status.IN_PROGRESS.name()) ? Status.IN_PROGRESS : null);

        return task;
    }


    String toString(Task task) {
        return task.toString();
    }

    static FileBackedTasksManager loadFromFile(Path path) {
        FileBackedTasksManager file = new FileBackedTasksManager(path, Managers.getDefaultHistory());
        try {
            BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH));

            while (bf.ready()) {
                bf.readLine();
            }
            bf.close();

        } catch (IOException exception) {
            throw new ManagerSaveException();
        }
        return file;
    }

    static String historyToString(HistoryManager historyManager) {
        List<Task> history = historyManager.getHistory();
        StringBuilder builder = new StringBuilder();
        if (history.isEmpty()) {
            return "";
        } else {
            for (Task task : history) {
                builder.append(task);
            }
        }
        return builder.toString();
    }

    static List<Integer> historyFromString(String value) {
        List<Integer> history = new ArrayList<>();
        String[] split = value.split("\n");
        return history;
    }

    @Override
    public String createSubtask(Subtask subtask) {
        String message = super.createSubtask(subtask);
        save();
        return message;
    }

    @Override
    public String createTask(Task task) {
        String message = super.createTask(task);
        save();
        return message;
    }

    @Override
    public String createEpic(Epic epic) {
        String message = super.createEpic(epic);
        save();
        return message;
    }

    @Override
    public String update(int id, Task updatedTask) {
        String message = super.update(id, updatedTask);
        save();
        return message;
    }

    @Override
    public String removeTaskById(int id) {
        String message = super.removeTaskById(id);
        save();
        return message;
    }

    @Override
    public String removeEpicById(int id) {
        String message = super.removeEpicById(id);
        save();
        return message;
    }

    @Override
    public String removeSubtasksById(int id) {
        String message = super.removeSubtasksById(id);
        save();
        return message;
    }

    @Override
    public String removeAll() {
        String message = super.removeAll();
        save();
        return message;
    }
}