package JavaTaskTracker.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Epic extends Task {
    LocalDateTime endTime;
    private Map<Integer, Subtask> subtasks = new HashMap<>();

    public Epic(String title, String description) {
        super(title, description);
        setType(Type.EPIC);
    }

    public void setDuration() {
        this.duration = getStartTime().until(getEndTime(), ChronoUnit.MINUTES);
    }

    @Override
    public void setStartTime(LocalDateTime startTime) {
        if (this.startTime == null || startTime.isBefore(this.startTime)) {
            this.startTime = startTime;
        }
    }

    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        if (this.endTime == null || endTime.isAfter(this.endTime)) {
            this.endTime = endTime;
        }
    }

    public Map<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(Subtask subtask) {
        setStartTime(subtask.getStartTime());
        setEndTime(subtask.getEndTime());
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
