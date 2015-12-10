package com.costular.flatsharing.add_group;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.util.AndroidImageFile;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by diego on 7/12/15.
 */
@RuntimePermissions
public class AddGroupFragment extends Fragment implements AddGroupContract.MyView {
    
    @Bind(R.id.add_group_title_layout)
    TextInputLayout addGroupTitleInputLayout;
    @Bind(R.id.add_group_title)
    EditText addGroupTitleEditText;
    @Bind(R.id.add_group_description)
    EditText addGroupDescriptionEditText;

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
        presenter = new AddGroupPresenter(this, AndroidImageFile.newInstance());
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_add_group_picture, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.context_add_group_gallery:
                try {
                    presenter.selectPictureFromGallery();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.context_add_group_camera:
                takePictureWithPermissions();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void takePictureWithPermissions() {
        try {
            presenter.takePicture();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void openCamera(String whereSave) {

    }

    @Override
    public void showImageError() {

    }

    @Override
    public void setDefaultPicture() {

    }

    @Override
    public void selectPictureFromGallery() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_done) {
            if(presenter != null) {
                presenter.saveGroup(new Group(addGroupTitleEditText.getText().toString(),
                        addGroupDescriptionEditText.getText().toString()));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
