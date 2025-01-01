package TaskManagementSystem.SearchTask;

import TaskManagementSystem.Task.Task;

public interface SearchTaskStrategy {
    public Task search(String searchParam);
}
