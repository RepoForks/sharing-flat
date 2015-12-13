package com.costular.flatsharing.data;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by diego on 11/12/15.
 */
public class FakeApiService implements GroupsApiService {

    private List<Group> groupList;

    public List<Group> getList() {
        return groupList;
    }

    public FakeApiService(int size) {
        groupList = new ArrayList<>();
        for(int i = 1; i <= size; i++) {
            groupList.add(new Group(i, "Title " + i, "Description " + i, "https://www.wonderplugin.com/wp-content/plugins/wonderplugin-lightbox/images/demo-image0.jpg"));
        }
        reverseList();
    }

    private void reverseList() {
        Collections.reverse(groupList);
    }

    @Override
    public void getGroups(final GroupsServiceListener<List<Group>> responseCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                responseCallback.onDataLoaded(groupList);
            }
        }, 2000);

    }

    @Override
    public void getGroup(int id, GroupsServiceListener<Group> responseCallback) {
        for(Group group : groupList) {
            if(group.getId() == id) {
                responseCallback.onDataLoaded(group);
            }
        }
        responseCallback.onError("No existe ningún grupo con esta id");
    }

    @Override
    public void saveGroup(Group group, GroupsServiceListener<Boolean> responseCallback) {
        groupList.add(group);
        reverseList();
        responseCallback.onDataLoaded(true);
    }

    @Override
    public void deleteGroup(String id, GroupsServiceListener<Boolean> responseCallback) {

    }
}
