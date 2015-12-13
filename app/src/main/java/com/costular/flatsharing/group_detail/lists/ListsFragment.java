package com.costular.flatsharing.group_detail.lists;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;

import butterknife.ButterKnife;

/**
 * Created by diego on 13/12/15.
 */
public class ListsFragment extends Fragment {

    private FloatingActionButton addButton;

    public static ListsFragment newInstance(Group group) {
        return new ListsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_group_detail_lists, container, false);
        addButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
