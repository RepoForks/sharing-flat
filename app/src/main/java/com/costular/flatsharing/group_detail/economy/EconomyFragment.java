package com.costular.flatsharing.group_detail.economy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.group_detail.GroupDetailActivity;

import butterknife.ButterKnife;

/**
 * Created by diego on 13/12/15.
 */
public class EconomyFragment extends Fragment {

    FloatingActionButton addButton;

    public static EconomyFragment newInstance(Group group) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(GroupDetailActivity.GROUP, group);
        EconomyFragment fragment = new EconomyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_group_detail_economy, container, false);
        ButterKnife.bind(this, root);
        addButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.group_detail_economy, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_activity:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
