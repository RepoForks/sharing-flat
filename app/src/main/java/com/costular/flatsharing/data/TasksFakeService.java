package com.costular.flatsharing.data;

import android.os.Handler;

import java.util.List;

/**
 * Created by diego on 17/12/15.
 */
public class TasksFakeService implements TasksApiService{

    private String[] fakeNames = {"Diego F", "Diego R", "Eusebio"};
    private String[] fakeAvatars = {"https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAccAAAAJGVkZjkzMmNhLTU1YjQtNDgwMC04Mjc5LTI0NWQzZDIyZjJmYg.jpg",
            "http://i.imgur.com/FA63bAp.jpg",
            "http://cd00.epimg.net/cincodias/imagenes/2013/02/15/economia/1361168906_740215_0000000001_noticia_normal.jpg"};
    private List<User> userList;

    public TasksFakeService(int size) {
        for(int i = 1; i <= size; i++) {
            userList.add(new User(i, fakeNames[i -1], fakeAvatars[i -1], "email@email.com"));
        }
    }

    @Override
    public void getUserList(final TasksApiServiceListener<List<User>> responseCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                responseCallback.onDataLoaded(userList);
            }
        }, 1500);
    }

    @Override
    public void getUser(int id, TasksApiServiceListener<User> user) {

    }
}
