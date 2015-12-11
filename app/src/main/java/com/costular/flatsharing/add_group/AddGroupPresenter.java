package com.costular.flatsharing.add_group;

import android.view.View;

import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.util.ImageFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diego on 7/12/15.
 */
public class AddGroupPresenter implements AddGroupContract.UserActionListener{

    private AddGroupContract.MyView view;
    private ImageFile imageFile;

    public AddGroupPresenter(AddGroupContract.MyView view, ImageFile imageFile) {
        this.view = view;
        this.imageFile = imageFile;
    }

    @Override
    public void saveGroup(Group group) {
        if(group == null || group.isTitleEmpty()) {
            view.showEmptyGroupTitleError();
        } else {
            view.showGroupsList();
        }
    }

    public ImageFile getImageFile() {
        return imageFile;
    }

    @Override
    public void addPicture(View v) {
        view.showSelectImageInputDialog(v);
    }

    @Override
    public void takePicture() throws IOException {
        createFileByDatetime();
        view.openCamera(imageFile.getPath());
    }

    private void createFileByDatetime() throws IOException {
        String dateTimeFormat = new SimpleDateFormat("ddMMyyy_HHmmss").format(new Date());
        String fileName = "JPEG_".concat(dateTimeFormat).concat("_");
        imageFile.create(fileName, ".jpg");
    }

    @Override
    public void selectPictureFromGallery() throws IOException {
        view.selectPictureFromGallery();
    }

    @Override
    public void deletePicture() throws IOException {
        imageFile.delete();
        view.setDefaultPicture();
    }
}
