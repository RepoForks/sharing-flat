package com.costular.flatsharing.data;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego on 17/12/15.
 */
public class TasksFakeService implements TasksApiService{

    private Group group;

    public TasksFakeService(Group group) {
        this.group = group;
    }

    @Override
    public void getUserList(final TasksApiServiceListener<List<User>> responseCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                responseCallback.onDataLoaded(group.getMembers());
            }
        }, 1500);
    }

    @Override
    public void getUser(int id, TasksApiServiceListener<User> response) {
        for(User currentUser : group.getMembers()) {
            if(currentUser.getId() == id) {
                response.onDataLoaded(currentUser);
            }
        }
    }
}
