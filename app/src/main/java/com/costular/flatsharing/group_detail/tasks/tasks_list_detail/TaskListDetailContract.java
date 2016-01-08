package com.costular.flatsharing.group_detail.tasks.tasks_list_detail;

import com.costular.flatsharing.data.Task;
import com.costular.flatsharing.data.User;

import java.util.List;

/**
 * Created by diego on 19/12/15.
 */
public interface TaskListDetailContract {

    public interface MyView {

        void showTasks(List<Task> taskList);
    }

    public interface UserActionListener {
        void openUserTask(User user);
    }
}
