package com.costular.flatsharing.add_group;

import android.view.View;

import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.data.GroupDataSource;
import com.costular.flatsharing.data.GroupsApiService;
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
    private GroupDataSource groupDataSource;

    public AddGroupPresenter(AddGroupContract.MyView view, ImageFile imageFile, GroupDataSource dataSource) {
        this.view = view;
        this.imageFile = imageFile;
        this.groupDataSource = dataSource;
    }

    @Override
    public void saveGroup(Group group) {
        if(group == null || group.isTitleEmpty()) {
            view.showEmptyGroupTitleError();
        } else {
            groupDataSource.addGroup(group, new GroupsApiService.GroupsServiceListener<Boolean>() {
                @Override
                public void onDataLoaded(Boolean response) {
                    view.showGroupsList();
                }

                @Override
                public void onError(String message) {
                    view.showError("Error al crear grupo");
                }
            });

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
