package JavaTaskTracker.model;


import JavaTaskTracker.utils.NewComparator;

import java.time.LocalDateTime;
import java.util.*;

public class Epic extends Task {
    LocalDateTime endTime;
    private Map<Integer, Subtask> subtasks = new HashMap<>();

    public Epic(String title, String description) {
        super(title, description);
        setType(Type.EPIC);
    }

    @Override
    public int getDuration() {
        int duration = 0;
        for (Map.Entry<Integer, Subtask> subtask : subtasks.entrySet()) {
            duration += subtask.getValue().getDuration();
        }
        return duration;
    }

    @Override
    public LocalDateTime getStartTime() {
        List<Task> listOfSubtasks = new ArrayList<>();

        for (Map.Entry<Integer, Subtask> subtask : subtasks.entrySet()) {
            listOfSubtasks.add(subtask.getValue());
        }

        Collections.sort(listOfSubtasks, new NewComparator());
        if (listOfSubtasks.isEmpty()) {
            return null;
        } else {
            return listOfSubtasks.get(0).getStartTime();
        }
    }

    @Override
    public LocalDateTime getEndTime() {
        return getStartTime().plusMinutes(getDuration());
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
