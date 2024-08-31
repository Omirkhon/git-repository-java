package JavaTaskTracker;

public class Subtask extends Task {
    private Epic epic;

    public Subtask(String title, String description, Epic epic) {
        super(title, description);
        this.epic = epic;
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
