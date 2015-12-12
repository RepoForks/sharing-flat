package com.costular.flatsharing.add_group;

import com.costular.flatsharing.data.Group;
import android.view.View;

import java.io.IOException;

/**
 * Created by diego on 7/12/15.
 */
public interface AddGroupContract {

    interface MyView {

        void showGroupsList();

        void showEmptyGroupTitleError();

        void showSelectImageInputDialog(android.view.View view);

        void openCamera(String whereSave);

        void showImageError();

        void setDefaultPicture();

        void selectPictureFromGallery();

        void showError(String message);
    }

    interface UserActionListener {

        void saveGroup(Group group);

        void addPicture(View v);

        void takePicture() throws IOException;

        void selectPictureFromGallery() throws IOException;

        void deletePicture() throws IOException;
    }
}
