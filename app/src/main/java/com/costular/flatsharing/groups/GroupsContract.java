package com.costular.flatsharing.groups;

import com.costular.flatsharing.data.Group;

/**
 * Created by diego on 7/12/15.
 */
public interface GroupsContract {

    interface MyView {

        void setProgressIndicator(boolean active);

        void showAddGroup();

        void showGroupDetail(String groupId);
    }

    interface UserActionListener {

        void addNewGroup();

        void loadGroups(boolean forceUpdate);

        void openGroupDetail(Group group);
    }
}
