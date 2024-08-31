package JavaTaskTracker;


import java.util.HashMap;
import java.util.Map;

public class Epic extends Task {
    private Map<Integer, Subtask> subtasks = new HashMap<>();

    public Epic(String title, String description) {
        super(title, description);
        setType(Type.EPIC);
    }

    public Map<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void status(Epic epic) {
        int newCount = 0;
        int doneCount = 0;
        if (subtasks.isEmpty()) {
            epic.setStatus(Status.NEW);
        } else {
            for (Subtask subtask : subtasks.values()) {
                if (subtask.getStatus() == Status.NEW) {
                    newCount++;
                } else if (subtask.getStatus() == Status.DONE) {
                    doneCount++;
                }
            }
            if (newCount == subtasks.size()) {
                epic.setStatus(Status.NEW);
            } else if (doneCount == subtasks.size()) {
                epic.setStatus(Status.DONE);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
    }
}
