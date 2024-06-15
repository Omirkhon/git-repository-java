package JavaTaskTracker;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(String title, String description) {
        super(title, description);
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void status(Epic epic) {
        int newCount = 0;
        int doneCount = 0;
        if (subtasks.isEmpty()) {
            epic.setStatus("NEW");
        } else {
            for (Subtask subtask : subtasks) {
                if (subtask.getStatus().equals("NEW")) {
                    newCount++;
                } else if (subtask.getStatus().equals("DONE")) {
                    doneCount++;
                }
            }
            if (newCount == subtasks.size()) {
                epic.setStatus("NEW");
            } else if (doneCount == subtasks.size()) {
                epic.setStatus("DONE");
            } else {
                epic.setStatus("IN_PROGRESS");
            }
        }
    }
}
