package com.costular.flatsharing.group_detail.economy;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by diego on 13/12/15.
 */
public class EconomyFragment extends Fragment implements EconomyContract.MyView{

    public DrawerLayout drawerLayout;
    public LinearLayout drawerLayoutList;
    public ActionBarDrawerToggle drawerToggle;
    private FloatingActionButton addButton;
    @Bind(R.id.loading) ProgressBar loadingView;


    private EconomyPresenter presenter;

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
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new EconomyPresenter(this, Repository.getInMemoryRepoEconomyInstance(new FakeEconomyService(9)));

        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.open, R.string.close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
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

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showTransactions(List<Transaction> transactionList) {
        //setProgressIndicator(false);

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
