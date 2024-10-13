package JavaTaskTracker.model;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
    private Type type;
    private LocalDateTime startTime;
    private int duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
        setType(Type.TASK);
    }

    public Task(String title, String description, LocalDateTime startTime, int duration) {
        this.title = title;
        this.description = description;
        this.status = Status.NEW;
        setType(Type.TASK);
        this.startTime = startTime;
        this.duration = duration;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getEndTime() {
        return startTime.plusMinutes(duration);
    }

    @Override
    public String toString() {
        return getId()+", "+getType()+", "+getTitle()+", "+getStatus()+", Description"+getDescription();
    }
}