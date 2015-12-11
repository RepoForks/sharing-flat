package com.costular.flatsharing.groups;

import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.data.GroupDataSource;

import java.util.List;

/**
 * Created by diego on 7/12/15.
 */
public class GroupsPresenter implements GroupsContract.UserActionListener{

    private GroupsContract.MyView groupsView;
    private GroupDataSource dataSource;

    public GroupsPresenter(GroupsContract.MyView groupsView, GroupDataSource dataSource) {
        this.groupsView = groupsView;
        this.dataSource = dataSource;
    }

    @Override
    public void addNewGroup() {
        groupsView.showAddGroup();
    }

    @Override
    public void loadGroups(boolean forceUpdate) {
        dataSource.getGroupLists(new GroupDataSource.Callback() {
            @Override
            public void onGroupsLoaded(List<Group> groupList) {
                groupsView.setProgressIndicator(false);
                groupsView.showGroups(groupList);
            }

            @Override
            public void onError(String message) {
                groupsView.showErrorMessage(message);
            }
        });
    }

    @Override
    public void openGroupDetail(Group group) {

    }
}
