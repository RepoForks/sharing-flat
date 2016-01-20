package com.costular.flatsharing.group_detail.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.data.TasksDataCached;
import com.costular.flatsharing.data.TasksFakeService;
import com.costular.flatsharing.data.User;
import com.costular.flatsharing.group_detail.GroupDetailActivity;
import com.costular.flatsharing.group_detail.tasks.tasks_list_detail.TaskListDetailActivity;
import com.costular.flatsharing.group_detail.tasks.tasks_list_detail.TaskListDetailFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by diego on 13/12/15.
 */
public class TasksFragment extends Fragment implements TasksContract.MyView{

    private FloatingActionButton addButton;
    private Group group;

    public static TasksFragment newInstance(Group group) {
        Bundle extras = new Bundle();
        extras.putParcelable(GroupDetailActivity.GROUP, group);
        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(extras);
        return fragment;
    }

    @Bind(R.id.tasks_recycler_view) RecyclerView recyclerView;
    @Bind(R.id.loading_view) ProgressBar loadingView;

    private TasksPresenter presenter;
    private UserTasksAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_group_detail_tasks, container, false);
        ButterKnife.bind(this, root);
        addButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        group = getArguments().getParcelable(GroupDetailActivity.GROUP);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new TasksPresenter(this, new TasksDataCached(new TasksFakeService(group)));

        adapter = new UserTasksAdapter(new UserTasksAdapter.TaskUserClicked() {
            @Override
            public void onTaskUserClicked(User user) {
                presenter.openUserDetail(user);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadUsers(false);
    }

    @Override
    public void showUsers(List<User> userList) {
        adapter.replaceAndUpdateData(userList);
    }

    @Override
    public void setProgressIndicators(boolean visible) {
        loadingView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showAddTask() {

    }

    @Override
    public void openUserDetail(User user) {
        Intent intent = new Intent(getActivity(), TaskListDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(TaskListDetailFragment.ARGUMENT_USER, user);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
