package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 17/12/15.
 */
public interface TasksDataSource {

    public interface UsersCallback {
        void onUsersLoaded(List<User> userList);
        void onErrorLoadingUsers(String message);
    }

    void getTasksByUser(User user);

    void getUsers(UsersCallback callback);

}
