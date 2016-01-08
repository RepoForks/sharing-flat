package com.costular.flatsharing.group_detail.tasks.tasks_list_detail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.costular.flatsharing.BaseActivity;
import com.costular.flatsharing.R;
import com.costular.flatsharing.data.User;
import com.costular.flatsharing.util.ToolbarSpinnerAdapter;

public class TaskListDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list_detail);
        setUpToolbar(true);

        User user = getIntent().getExtras().getParcelable(TaskListDetailFragment.ARGUMENT_USER);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, TaskListDetailFragment.newInstance(user))
                .commit();

        Toolbar toolbar = getToolbar();
        View spinnerContainer = LayoutInflater.from(this).inflate(R.layout.toolbar_spinner,
                toolbar, false);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        toolbar.addView(spinnerContainer, lp);

        ToolbarSpinnerAdapter spinnerAdapter = new ToolbarSpinnerAdapter();
        spinnerAdapter.addItem(user);
        spinnerAdapter.addItem(user);
        spinnerAdapter.addItem(user);

        Spinner spinner = (Spinner) spinnerContainer.findViewById(R.id.toolbar_spinner);
        spinner.setAdapter(spinnerAdapter);
    }

}
