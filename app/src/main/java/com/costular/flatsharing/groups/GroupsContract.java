package com.costular.flatsharing.groups;

/**
 * Created by diego on 7/12/15.
 */
public interface GroupsContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showAddGroup();

        void showGroupDetail(String groupId);
    }

    interface UserActionListener {

        void addNewGroup();

        void loadGroups(boolean forceUpdate);
    }
}
