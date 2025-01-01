package TaskManagementSystem;

import java.util.HashMap;

import TaskManagementSystem.Account.User;
import TaskManagementSystem.Task.Task;
import TaskManagementSystem.Task.TaskPriority;
import TaskManagementSystem.Task.TaskService;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("task1", "titleTask1", "first task", TaskPriority.MEDIUM);
        User user1 = new User("user1", "user1name");
        HashMap<String, User> users = new HashMap<>();
        users.put(user1.getId(), user1);
        
        TaskService taskService = new TaskService(users);
        taskService.createTask(task);

        taskService.assignTask(task.getId(), user1.getId());

        Task taskFromTaskService = taskService.getTask(task.getId());

        System.out.println(taskFromTaskService.getId());
        String newTaskId = user1.getTaskHistory().get(0);
        Task newTask = taskService.getTask(newTaskId);
        System.out.println(newTask.getId() + " " + newTask.getTitle());
    }
}
