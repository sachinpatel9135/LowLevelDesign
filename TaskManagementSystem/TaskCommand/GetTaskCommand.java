package TaskManagementSystem.TaskCommand;

import TaskManagementSystem.Task.Task;
import TaskManagementSystem.Task.TaskService;

public class GetTaskCommand implements Command{
    private TaskService taskService;
    private String taskId;
    private Task task;

    public GetTaskCommand(TaskService taskService, String taskId) {
        this.taskService = taskService;
        this.taskId = taskId;
    }

    @Override
    public void execute() {
        task = taskService.getTask(taskId);
    }
    
    public Task getRetrivedTask() {
        return task;
    }
}
