package com.costular.flatsharing.group_detail.tasks;

import com.costular.flatsharing.data.TasksDataSource;
import com.costular.flatsharing.data.User;

import java.util.List;

/**
 * Created by diego on 19/12/15.
 */
public class TasksPresenter implements TasksContract.UserActionListener{

    private TasksContract.MyView view;
    private TasksDataSource apiService;

    public TasksPresenter(TasksContract.MyView view, TasksDataSource apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void loadUsers(boolean forceUpload) {
        apiService.getUsers(new TasksDataSource.UsersCallback() {
            @Override
            public void onUsersLoaded(List<User> userList) {
                view.setProgressIndicators(false);
                view.showUsers(userList);
            }

            @Override
            public void onErrorLoadingUsers(String message) {
                view.showErrorMessage(message);
            }
        });
    }

    @Override
    public void addTransaction() {

    }

    @Override
    public void openUserDetail() {

    }
}
