package com.costular.flatsharing.group_detail.settings;

import com.costular.flatsharing.data.User;

import java.util.List;

/**
 * Created by diego on 8/02/16.
 */
public interface GroupSettingsContract {

    public interface MyView {

        void setLoading(boolean isLoading);

        void showMembers(List<User> members);

        void closeSettings();

        void showSuccessMessage(String message);

        void showSuccessMessageWithUndoButton(String message, String undoText);

        void showErrorMessage(String message);
    }

    public interface UserActionListener {

        void loadMembers(boolean forceToUpdate);

        void addMember();

        void changeAvatarButtonClicked();

        void changeGroupName(String name);

        void deleteGroup();
    }
}
