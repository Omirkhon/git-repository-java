package JavaTaskTracker;

public class Test {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task = new Task("Приготовить кушать", "описание задачи 1");
        manager.createTask(task);

        Epic epic = new Epic("Убраться дома", "описание эпика 1");
        manager.createEpic(epic);

        Subtask subtask = new Subtask("Пропылесосить", "Описание", epic);
        manager.createSubtask(subtask);
        subtask.setStatus(Status.IN_PROGRESS);

        Subtask subtaskTwo = new Subtask("Помыть посуду", "Описание", epic);
        manager.createSubtask(subtaskTwo);
        subtaskTwo.setStatus(Status.NEW);

        System.out.println(manager.getTasks());
        System.out.println(manager.getEpics());
        System.out.println(manager.getSubtasks());
        System.out.println(epic.getStatus());
        System.out.println(manager.getTaskById(1));
        System.out.println(manager.getEpicById(2));
        System.out.println(manager.getSubtaskById(3));
    }
}