package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 11/12/15.
 */
public interface GroupDataSource {

    public interface Callback {
        void onGroupsLoaded(List<Group> groupList);
        void onError(String message);
    }

    void getGroupLists(Callback callback);

    void addGroup(Group group, GroupsApiService.GroupsServiceListener<Boolean> response);

    void deleteGroup(Group group);

    void refreshData();
}
