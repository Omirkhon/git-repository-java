package JavaTaskTracker.model;

import java.time.LocalDateTime;

public class Subtask extends Task {
    private Epic epic;

    public Subtask(String title, String description, Epic epic) {
        super(title, description);
        this.epic = epic;
        epic.addSubtask(this);
        epic.getSubtasks().put(getId(),this);
        setType(Type.SUBTASK);
    }

    public Subtask(String title, String description, Epic epic, LocalDateTime startTime, int duration) {
        super(title, description, startTime, duration);
        this.epic = epic;
        epic.addSubtask(this);
        epic.getSubtasks().put(getId(),this);
        setType(Type.SUBTASK);
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        epic.status(epic);
    }
}
