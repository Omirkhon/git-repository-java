package JavaTaskTracker.tests;

import JavaTaskTracker.service.FileBackedTasksManager;

public class FileBackedTasksManagerTest extends TaskManagerTest<FileBackedTasksManager> {
    public FileBackedTasksManagerTest() {
        super(new FileBackedTasksManager(null, null));
    }
}
