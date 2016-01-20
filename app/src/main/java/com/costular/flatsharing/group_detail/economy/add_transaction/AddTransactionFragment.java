package com.costular.flatsharing.group_detail.economy.add_transaction;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.FakeEconomyService;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.data.Repository;
import com.costular.flatsharing.data.User;
import com.costular.flatsharing.group_detail.GroupDetailActivity;
import com.costular.flatsharing.util.AddTransactionSpinnerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by diego on 20/01/16.
 */
public class AddTransactionFragment extends Fragment implements AddTransactionContract.MyView{

    private AddTransactionPresenter presenter;
    private Group group;

    @Bind(R.id.add_transaction_spinner_who_pays) Spinner userPayerSpinner;
    @Bind(R.id.add_transaction_linear_layout) LinearLayout layout;

    public static Fragment newInstance(Group group) {
        Bundle extras = new Bundle();
        extras.putParcelable(GroupDetailActivity.GROUP, group);
        AddTransactionFragment fragment = new AddTransactionFragment();
        fragment.setArguments(extras);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_transaction,
                parent, false);
        setHasOptionsMenu(true);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new AddTransactionPresenter(this, Repository.getInMemoryRepoEconomyInstance(new FakeEconomyService(3)));
        group = getArguments().getParcelable(GroupDetailActivity.GROUP);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadUserSpinner();
        loadUserPayments();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.activity_add_transaction, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            saveTransactionAndCloseActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveTransactionAndCloseActivity() {
        presenter.saveTransaction(null);
    }

    @Override
    public void showListTransactions() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void loadUserSpinner() {
        AddTransactionSpinnerAdapter adapter = new AddTransactionSpinnerAdapter();
        adapter.addItems(group.getMembers());

        userPayerSpinner.setAdapter(adapter);
    }

    @Override
    public void loadUserPayments() {
        layout.removeAllViews();

        for(User user : group.getMembers()) {
            /*LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            layout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;*/

            TextView name = new TextView(getActivity());
            name.setText(user.getName());

            layout.addView(name, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG)
                .show();
    }
}
