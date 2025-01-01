package TaskManagementSystem.TaskCommand;

import TaskManagementSystem.Task.TaskService;

public class AssignTaskCommand implements Command{
    TaskService taskService;
    String taskId;
    String assigneeId;

    public AssignTaskCommand(TaskService taskService, String taskId, String assigneeId) {
        this.taskService = taskService;
        this.taskId = taskId;
        this.assigneeId = assigneeId;
    }

    @Override
    public void execute() {
        taskService.assignTask(taskId, assigneeId);
    }
}
