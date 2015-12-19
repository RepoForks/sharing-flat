package com.costular.flatsharing.group_detail.tasks;

import com.costular.flatsharing.data.User;

import java.util.List;

/**
 * Created by diego on 19/12/15.
 */
public interface TasksContract {

    public interface MyView {

        void showUsers(List<User> userList);

        void setProgressIndicators(boolean visible);

        void showErrorMessage(String message);

        void showAddTask();

        void openUserDetail();
    }

    public interface UserActionListener {

        void loadUsers(boolean forceUpload);

        void addTransaction();

        void openUserDetail();
    }
}
