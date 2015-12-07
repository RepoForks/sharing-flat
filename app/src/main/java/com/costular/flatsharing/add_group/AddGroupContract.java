package com.costular.flatsharing.add_group;

import com.costular.flatsharing.data.Group;

import java.io.IOException;

/**
 * Created by diego on 7/12/15.
 */
public interface AddGroupContract {

    interface View {

        void showEmptyGroupError();

        void openCamera(String whereSave);

        void showImageError();

        void setDefaultPicture();
    }

    interface UserActionListener {

        void saveGroup(Group group);

        void takePicture() throws IOException;

        void selectPictureFromGallery() throws IOException;

        void deletePicture();
    }
}
