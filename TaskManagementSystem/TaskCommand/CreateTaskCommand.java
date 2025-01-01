package TaskManagementSystem.TaskCommand;

import TaskManagementSystem.Task.Task;
import TaskManagementSystem.Task.TaskService;

public class CreateTaskCommand implements Command{
    private TaskService taskService;
    private Task task;

    public CreateTaskCommand(TaskService taskService, Task task) {
        this.taskService = taskService;
        this.task = task;
    }

    @Override
    public void execute() {
        taskService.createTask(task);
    }
}
