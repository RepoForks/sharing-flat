package com.costular.flatsharing.groups;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.costular.flatsharing.R;
import com.costular.flatsharing.add_group.AddGroupActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by diego on 7/12/15.
 */
public class GroupsFragment extends Fragment implements GroupsContract.MyView {

    public static final int REQUEST_ADD_GROUP = 1;

    private GroupsPresenter groupsPresenter;
    private FloatingActionButton fabAddGroup;

    @Bind(R.id.loading) ProgressBar loadingProgressBar;

    public static GroupsFragment newInstance() {
        return new GroupsFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_groups, container, false);
        ButterKnife.bind(this, root);
        fabAddGroup = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_group);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        groupsPresenter = new GroupsPresenter(this);

        fabAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupsPresenter.addNewGroup();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // If a note was successfully added, show snackbar
        if (REQUEST_ADD_GROUP == requestCode && Activity.RESULT_OK == resultCode) {
            Snackbar.make(getView(), getString(R.string.group_added_successfully),
                    Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setProgressIndicator(boolean active) {
        loadingProgressBar.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showAddGroup() {
        Intent intent = new Intent(getActivity(), AddGroupActivity.class);
        startActivityForResult(intent, REQUEST_ADD_GROUP);
    }

    @Override
    public void showGroupDetail(String groupId) {

    }
}
