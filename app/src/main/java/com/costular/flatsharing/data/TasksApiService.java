package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 17/12/15.
 */
public interface TasksApiService {

    public interface TasksApiServiceListener<T> {
        void onDataLoaded(T response);
        void onError(String message);
    }

    void getUserList(TasksApiServiceListener<List<User>> responseCallback);

    void getUser(int id, TasksApiServiceListener<User> user);
}
