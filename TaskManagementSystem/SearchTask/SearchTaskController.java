package TaskManagementSystem.SearchTask;

import TaskManagementSystem.Task.Task;

public class SearchTaskController {
    private SearchTaskStrategy searchTaskStrategy;

    public SearchTaskController(SearchTaskStrategy searchTaskStrategy) {
        this.searchTaskStrategy = searchTaskStrategy;
    }

    public Task search(String searchParam) {
        return searchTaskStrategy.search(searchParam);
    }
}
