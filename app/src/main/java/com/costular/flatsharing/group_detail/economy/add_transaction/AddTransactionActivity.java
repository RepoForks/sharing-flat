package com.costular.flatsharing.group_detail.economy.add_transaction;

import android.os.Bundle;
import android.view.Menu;

import com.costular.flatsharing.BaseActivity;
import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.group_detail.GroupDetailActivity;

/**
 * Created by diego on 20/01/16.
 */
public class AddTransactionActivity extends BaseActivity{

    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        setUpToolbar(true);
        setToolbarTitle(getString(R.string.add_transaction_toolbar_title));
        group = getIntent().getParcelableExtra(GroupDetailActivity.GROUP);
        loadFragment();
    }

    private void loadFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, AddTransactionFragment.newInstance(group))
                .commit();
    }
}
