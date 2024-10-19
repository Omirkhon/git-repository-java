package JavaTaskTracker.tests;

import JavaTaskTracker.service.InMemoryTaskManager;
import JavaTaskTracker.utils.Managers;

public class InMemoryTaskManagerTest extends TaskManagerTest<InMemoryTaskManager> {
    public InMemoryTaskManagerTest() {
        super(new InMemoryTaskManager(Managers.getDefaultHistory()));
    }
}
