package com.costular.flatsharing.groups;

import com.costular.flatsharing.data.Group;

/**
 * Created by diego on 7/12/15.
 */
public class GroupsPresenter implements GroupsContract.UserActionListener{

    private GroupsContract.MyView groupsView;

    public GroupsPresenter(GroupsContract.MyView groupsView) {
        this.groupsView = groupsView;
    }

    @Override
    public void addNewGroup() {
        groupsView.showAddGroup();
    }

    @Override
    public void loadGroups(boolean forceUpdate) {

    }

    @Override
    public void openGroupDetail(Group group) {

    }
}
