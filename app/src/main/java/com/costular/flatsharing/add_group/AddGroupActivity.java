package com.costular.flatsharing.add_group;

import android.os.Bundle;
import android.view.Menu;

import com.costular.flatsharing.BaseActivity;
import com.costular.flatsharing.R;

/**
 * Created by diego on 7/12/15.
 */
public class AddGroupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        setUpToolbar(true);
        loadFragmentIntoContainer();
    }

    private void loadFragmentIntoContainer() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, AddGroupFragment.newInstance())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_add_group, menu);
        return true;
    }
}
