package com.costular.flatsharing.groups;

import com.costular.flatsharing.data.Group;

import java.util.List;

/**
 * Created by diego on 7/12/15.
 */
public interface GroupsContract {

    interface MyView {

        void setProgressIndicator(boolean active);

        void showAddGroup();

        void showErrorMessage(String message);

        void showGroups(List<Group> groupList);

        void showGroupDetail(Group group);
    }

    interface UserActionListener {

        void addNewGroup();

        void loadGroups(boolean forceUpdate);

        void openGroupDetail(Group group);
    }
}
