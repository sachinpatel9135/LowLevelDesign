package TaskManagementSystem.TaskCommand;

import TaskManagementSystem.Task.Task;
import TaskManagementSystem.Task.TaskService;

public class UpdateTaskCommand implements Command{
    private TaskService taskService;
    private Task task;

    public UpdateTaskCommand(TaskService taskService, Task task) {
        this.taskService = taskService;
        this.task = task;
    }

    @Override
    public void execute() {
        taskService.updateTask(task);
    }
    
}
