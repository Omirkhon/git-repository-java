package JavaTaskTracker;

import JavaTaskTracker.model.*;
import JavaTaskTracker.service.*;
import JavaTaskTracker.utils.*;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();

        Task task = new Task("Приготовить кушать", " описание задачи 1",
                LocalDateTime.of(2024, 9, 9, 18, 30), 40);
        manager.createTask(task);

        Task taskTwo = new Task("Сделать домашку", " описание задачи 2",
                LocalDateTime.of(2024, 10, 12, 15, 0), 120);
        manager.createTask(taskTwo);

        Epic epic = new Epic("Убраться дома", " описание эпика 1");
        manager.createEpic(epic);

        Subtask subtask = new Subtask("Пропылесосить", " Описание подзадачи 1", epic,
                LocalDateTime.of(2024, 7, 18, 10, 30), 59);
        manager.createSubtask(subtask);
        subtask.setStatus(Status.IN_PROGRESS);

        Subtask subtaskTwo = new Subtask("Помыть посуду", " Описание подзадачи 2", epic,
                LocalDateTime.of(2024, 7, 18, 11, 30), 60);
        manager.createSubtask(subtaskTwo);
        subtaskTwo.setStatus(Status.NEW);

        Subtask subtaskThree = new Subtask("Помыть полы", " Описание подзадачи 3", epic,
                LocalDateTime.of(2024, 7, 18, 12, 45), 60);
        manager.createSubtask(subtaskThree);
        subtaskTwo.setStatus(Status.NEW);

        Epic epicTwo = new Epic("Сходить за покупками", " описание эпика 2");
        manager.createEpic(epicTwo);

//        System.out.println(manager.getTasks());
//        System.out.println(manager.getEpics());
//        System.out.println(manager.getSubtasks());
//        System.out.println(epic.getStatus());
//        System.out.println(manager.getTaskById(1));
//        System.out.println(manager.getSubtaskById(5));
//        System.out.println(manager.getTaskById(2));
//        System.out.println(manager.getEpicById(3));
//        System.out.println(manager.getSubtaskById(4));
//        System.out.println(manager.getEpicById(7));
//        System.out.println(manager.getSubtaskById(6));
//        System.out.println(manager.getHistory());

        System.out.println(manager.getPrioritizedTasks());
    }
}