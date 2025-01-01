package TaskManagementSystem.TaskCommand;

import TaskManagementSystem.Task.TaskService;

public class DeleteTaskCommand implements Command{
    private TaskService taskService;
    private String taskId;

    public DeleteTaskCommand(TaskService taskService, String taskId) {
        this.taskService = taskService;
        this.taskId = taskId;
    }

    @Override
    public void execute() {
        taskService.deleteTask(taskId);
    }
}
