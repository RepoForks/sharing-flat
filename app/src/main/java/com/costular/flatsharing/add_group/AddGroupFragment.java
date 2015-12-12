package com.costular.flatsharing.add_group;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.FakeApiService;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.data.Repository;
import com.costular.flatsharing.util.AndroidImageFile;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.EmptyPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by diego on 7/12/15.
 */
public class AddGroupFragment extends Fragment implements AddGroupContract.MyView {

    public static final int REQUEST_TAKE_CAMERA_IMAGE = 1;
    public static final int REQUEST_PICK_IMAGE = 2;

    @Bind(R.id.header_image) ImageView headerImage;
    @Bind(R.id.add_group_title_layout) TextInputLayout addGroupTitleInputLayout;
    @Bind(R.id.add_group_title) EditText addGroupTitleEditText;
    @Bind(R.id.add_group_description) EditText addGroupDescriptionEditText;

    @Bind(R.id.fab_add_picture) FloatingActionButton addPictureFab;

    private AddGroupPresenter presenter;

    public static AddGroupFragment newInstance() {
        return new AddGroupFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceInstate) {
        super.onCreate(savedInstanceInstate);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_group, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addPictureFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addPicture(v);
            }
        });
        presenter = new AddGroupPresenter(this, AndroidImageFile.newInstance(), Repository.getInMemoryRepoInstance(new FakeApiService(9)));
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_add_group_picture, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.context_add_group_gallery:
                pickPictureFromGallery();
                return true;
            case R.id.context_add_group_camera:
                takePictureWithPermissions();
                return true;
            case R.id.context_default_picture:
                deletePicture();
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deletePicture() {
        try {
            presenter.deletePicture();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pickPictureFromGallery() {
        if(Build.VERSION.SDK_INT >= 23) {
            selectPictureFromGalleryWithPermissions();
        }else {
            selectPictureFromGalleryWithoutPermissions();
        }
    }

    private void selectPictureFromGalleryWithPermissions() {
        PermissionListener permissionListener = new EmptyPermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                try{
                    presenter.selectPictureFromGallery();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Snackbar.make(getView(), R.string.we_need_file_permission,
                        Snackbar.LENGTH_LONG).show();
            }
        };
        Dexter.checkPermission(permissionListener, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    private void selectPictureFromGalleryWithoutPermissions() {
        try{
            presenter.selectPictureFromGallery();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void takePictureWithPermissions() {
        PermissionListener permissionListener = new EmptyPermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                try {
                    presenter.takePicture();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Snackbar.make(getView(), R.string.we_need_file_permission,
                        Snackbar.LENGTH_LONG).show();
            }
        };
        Dexter.checkPermission(permissionListener, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    @Override
    public void showGroupsList() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void showEmptyGroupTitleError() {
        addGroupTitleInputLayout.setError(getString(R.string.error_add_group_title_empty));
    }

    @Override
    public void showSelectImageInputDialog(View view) {
        registerForContextMenu(view);
        getActivity().openContextMenu(view);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_TAKE_CAMERA_IMAGE:
                    String path = presenter.getImageFile().getPath();
                    loadImageSelectedIntoViewByPath(path);
                    break;
                case REQUEST_PICK_IMAGE:
                    if(data != null) {
                        Uri currentUri = data.getData();
                        String realPath = getRealPathFromURI(currentUri);
                        loadImageSelectedIntoViewByPath("file://"+realPath);
                    }
                    break;
            }
        }
    }

    private String getRealPathFromURI(Uri contentUri) {

        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query( contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }

    private void loadImageSelectedIntoViewByPath(String whereIs) {
        Picasso.with(getActivity())
                .load(Uri.parse(whereIs))
                .fit()
                .centerCrop()
                .into(headerImage);
    }

    private void loadImageSelectedintoViewByDrawable(int drawable) {
        Picasso.with(getActivity())
                .load(drawable)
                .fit()
                .centerCrop()
                .into(headerImage);
    }

    @Override
    public void openCamera(String whereSave) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse(whereSave));
            startActivityForResult(takePictureIntent, REQUEST_TAKE_CAMERA_IMAGE);
        }
    }

    @Override
    public void showImageError() {
        Snackbar.make(getView(), R.string.add_group_error_adding_image,
                Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setDefaultPicture() {
        loadImageSelectedintoViewByDrawable(R.drawable.group_placeholder);
    }

    @Override
    public void selectPictureFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_any_picture)), REQUEST_PICK_IMAGE);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_done) {
            if(presenter != null) {
                presenter.saveGroup(new Group(-1, addGroupTitleEditText.getText().toString(),
                        addGroupDescriptionEditText.getText().toString(), presenter.getImageFile().getPath()));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
