package com.costular.flatsharing.group_detail.economy;

/**
 * Created by diego on 13/12/15.
 */
public class EconomyPresenter implements EconomyContract.UserActionListener{

    EconomyContract.MyView view;

    public EconomyPresenter(EconomyContract.MyView view) {
        this.view = view;
    }

    @Override
    public void addTransaction() {

    }

    @Override
    public void showActivity() {

    }

    @Override
    public void leaveGroup() {

    }

    @Override
    public void openSettings() {

    }

    @Override
    public void openDetailTransaction() {

    }

    @Override
    public void loadTransactions(boolean forceUpdate) {
        view.showTransactions();
    }

    @Override
    public void deleteFransaction() {

    }

    @Override
    public void confirmDeleteTransaction() {

    }

    @Override
    public void payTransaction() {

    }
}
