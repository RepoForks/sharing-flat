package com.costular.flatsharing.group_detail.economy.add_transaction;

import android.os.Bundle;
import android.view.Menu;

import com.costular.flatsharing.BaseActivity;
import com.costular.flatsharing.R;

/**
 * Created by diego on 20/01/16.
 */
public class AddTransactionActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        setUpToolbar(true);
        loadFragment();
    }

    private void loadFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new AddTransactionFragment())
                .commit();
    }
}
