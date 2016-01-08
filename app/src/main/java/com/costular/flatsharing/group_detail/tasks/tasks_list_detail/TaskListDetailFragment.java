package com.costular.flatsharing.group_detail.tasks.tasks_list_detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Task;
import com.costular.flatsharing.data.User;

import java.util.List;

import butterknife.ButterKnife;

public class TaskListDetailFragment extends Fragment implements TaskListDetailContract.MyView{

    public static final String ARGUMENT_USER = "user";

    private User user;

    public static Fragment newInstance(User user) {
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        args.putParcelable(ARGUMENT_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    public TaskListDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getParcelable(ARGUMENT_USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_task_list_detail, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void showTasks(List<Task> taskList) {

    }
}
