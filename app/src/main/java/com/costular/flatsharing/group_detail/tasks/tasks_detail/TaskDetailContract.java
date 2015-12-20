package com.costular.flatsharing.group_detail.tasks.tasks_detail;

import com.costular.flatsharing.data.Task;

import java.util.List;

/**
 * Created by diego on 19/12/15.
 */
public interface TaskDetailContract {

    public interface MyView {

        void showTasks(List<Task> taskList);
    }

    public interface UserActionListener {

    }
}
