package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 11/12/15.
 */
public interface GroupsApiService {

    public interface GroupsServiceListener<T> {
        void onDataLoaded(T response);
        void onError(String message);
    }

    void getGroups(GroupsServiceListener<List<Group>> responseCallback);

    void getGroup(int id, GroupsServiceListener<Group> responseCallback);

    void saveGroup(Group group, GroupsServiceListener<Boolean> responseCallback);

    void deleteGroup(String id, GroupsServiceListener<Boolean> responseCallback);
}
