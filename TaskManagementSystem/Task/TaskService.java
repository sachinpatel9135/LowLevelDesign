package TaskManagementSystem.Task;

import java.util.HashMap;

import TaskManagementSystem.Account.User;

public class TaskService {
    private HashMap<String, Task> tasks = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();

    public TaskService(HashMap<String, User> users) {
        this.users = users;
    }

    public void createTask(Task task) {
        if(tasks.containsKey(task.getId())) throw new IllegalArgumentException("Task with this id aready exists!");
        tasks.put(task.getId(), task);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void deleteTask(String id) {
        tasks.remove(id);
    }
    
    public Task getTask(String id) {
        return tasks.get(id);
    }

    public void assignTask(String taskId, String userId) {
        tasks.get(taskId).setAssigneeId(userId);
        users.get(userId).addTaskHistory(taskId);
    }

    public void setTaskStatus(String taskId, TaskStatus taskStatus) {
        tasks.get(taskId).setTaskStatus(taskStatus);
    }
}
