package TaskManagementSystem.TaskCommand;

import TaskManagementSystem.Task.TaskService;
import TaskManagementSystem.Task.TaskStatus;

public class CompleteTaskCommand implements Command{
    TaskService taskService;
    String taskId;
    TaskStatus taskStatus;

    public CompleteTaskCommand(TaskService taskService, String taskId, TaskStatus taskStatus) {
        this.taskService = taskService;
        this.taskId = taskId;
        this.taskStatus = taskStatus;
    }

    @Override
    public void execute() {
        taskService.setTaskStatus(taskId, taskStatus);
    }
    
}
