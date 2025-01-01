package TaskManagementSystem.Task;

import java.sql.Date;

public class Task {
    private final String id;
    private String title;
    private String description;
    private Date dueDate;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private String assigneeId;

    Task(String id, String title, String description, TaskPriority taskPriority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskPriority = taskPriority;
        this.taskStatus = TaskStatus.NEW;
    }

    public String getId() {
        return id;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}