package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 11/12/15.
 */
public class GroupDataCached implements GroupDataSource{

    private GroupsApiService groupsApi;

    public GroupDataCached(GroupsApiService groupsApi) {
        this.groupsApi = groupsApi;
    }

    @Override
    public void getGroupLists(final Callback callback) {
        groupsApi.getGroups(new GroupsApiService.GroupsServiceListener<List<Group>>() {
            @Override
            public void onDataLoaded(List<Group> response) {
                callback.onGroupsLoaded(response);
            }

            @Override
            public void onError(String message) {
                callback.onError(message);
            }
        });
    }

    @Override
    public void addGroup(Group group, GroupsApiService.GroupsServiceListener<Boolean> response) {
        groupsApi.saveGroup(group, response);
    }

    @Override
    public void deleteGroup(Group group) {

    }

    @Override
    public void refreshData() {

    }
}
