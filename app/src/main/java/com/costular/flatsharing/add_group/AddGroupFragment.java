package com.costular.flatsharing.add_group;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.costular.flatsharing.R;

import butterknife.ButterKnife;

/**
 * Created by diego on 7/12/15.
 */
public class AddGroupFragment extends Fragment {

    public static AddGroupFragment newInstance() {
        return new AddGroupFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_group, container, false);
        ButterKnife.inject(this, root);
        return root;
    }
}
