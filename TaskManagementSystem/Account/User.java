package TaskManagementSystem.Account;

import java.util.HashMap;
import java.util.HashSet;

import TaskManagementSystem.TaskCommand.Command;

public class User{
    private String id;
    private String name;
    private HashSet<String> taskHistory = new HashSet<String>();

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTaskHistory(String taskId) {
        taskHistory.add(taskId);
    }
}
