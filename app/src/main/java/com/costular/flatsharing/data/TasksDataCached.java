package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 17/12/15.
 */
public class TasksDataCached implements TasksDataSource{

    private TasksApiService apiService;

    public TasksDataCached(TasksApiService tasksApiService) {
        apiService = tasksApiService;
    }

    @Override
    public void getUsers(final UsersCallback callback) {
        apiService.getUserList(new TasksApiService.TasksApiServiceListener<List<User>>() {
            @Override
            public void onDataLoaded(List<User> response) {
                callback.onUsersLoaded(response);
            }

            @Override
            public void onError(String message) {
                callback.onErrorLoadingUsers(message);
            }
        });
    }

    @Override
    public void getTasksByUser(User user) {

    }
}
