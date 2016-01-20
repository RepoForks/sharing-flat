package com.costular.flatsharing.group_detail.economy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.FakeEconomyService;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.data.Repository;
import com.costular.flatsharing.data.Transaction;
import com.costular.flatsharing.group_detail.GroupDetailActivity;
import com.costular.flatsharing.group_detail.economy.add_transaction.AddTransactionActivity;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by diego on 13/12/15.
 */
public class EconomyFragment extends Fragment implements EconomyContract.MyView{

    private static final int REQUEST_ADD_TRANSACTION = 1;
    public DrawerLayout drawerLayout;
    public LinearLayout drawerLayoutList;
    public ActionBarDrawerToggle drawerToggle;
    private FloatingActionButton addButton;
    @Bind(R.id.loading) ProgressBar loadingView;
    private RecyclerView recyclerView;
    private EconomyActivityAdapter adapter;

    private EconomyPresenter presenter;
    private Group group;

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
        drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        drawerLayoutList = (LinearLayout) getActivity().findViewById(R.id.drawer_layout_list);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new EconomyPresenter(this, Repository.getInMemoryRepoEconomyInstance(new FakeEconomyService(9)));
        group = getArguments().getParcelable(GroupDetailActivity.GROUP);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addTransaction();
            }
        });

        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.open, R.string.close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
        adapter = new EconomyActivityAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        /*recyclerView.addItemDecoration(
        new HorizontalDividerItemDecoration.Builder(getActivity())
                .colorResId(R.color.dividerColor)
                .marginResId(R.dimen.divider_left_margin, R.dimen.zero)
                .build()
        );*/
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadTransactions(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_activity:
                toggleDrawer();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            drawerLayout.openDrawer(GravityCompat.END);
        }
    }

    @Override
    public void setProgressIndicator(boolean active) {
        loadingView.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showAddTransaction() {
        Intent intent = new Intent(getActivity(), AddTransactionActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(GroupDetailActivity.GROUP, group);
        intent.putExtras(extras);
        startActivityForResult(intent, REQUEST_ADD_TRANSACTION);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // If a note was successfully added, show snackbar
        if (REQUEST_ADD_TRANSACTION == requestCode && Activity.RESULT_OK == resultCode) {
            Snackbar.make(getView(), getString(R.string.transaction_added_successfully),
                    Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showTransactions(List<Transaction> transactionList) {
        adapter.replaceAndUpdateData(transactionList);
    }

    @Override
    public void showTransactionsActivity() {

    }

    @Override
    public void showListOfGroups() {

    }

    @Override
    public void openSettings() {

    }

    @Override
    public void deleteTransaction() {

    }

    @Override
    public void confirmDeleteTransaction() {

    }

    @Override
    public void payTransaction() {

    }

    @Override
    public void openDetailTransaction() {

    }
}
