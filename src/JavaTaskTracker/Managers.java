package JavaTaskTracker;

import java.nio.file.Paths;
import java.nio.file.Path;

public class Managers {
    private static final String FILE_PATH = "task_tracker_directory/tasks.csv";

    private Managers() {

    }

    public static TaskManager getDefault() {
        return new FileBackedTasksManager(getPath());
    }
    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
    public static Path getPath() {
        return Paths.get(FILE_PATH);
    }
}
