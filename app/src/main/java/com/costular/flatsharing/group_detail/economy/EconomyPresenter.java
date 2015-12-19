package com.costular.flatsharing.group_detail.economy;

import com.costular.flatsharing.data.EconomyDataCached;
import com.costular.flatsharing.data.EconomyDataSource;
import com.costular.flatsharing.data.Transaction;

import java.util.List;

/**
 * Created by diego on 13/12/15.
 */
public class EconomyPresenter implements EconomyContract.UserActionListener{

    private EconomyContract.MyView view;
    private EconomyDataSource economyApi;

    public EconomyPresenter(EconomyContract.MyView view, EconomyDataSource economyApi) {
        this.economyApi = economyApi;
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
        economyApi.getActivityTransactions(new EconomyDataSource.Callback() {
            @Override
            public void onActivityLoaded(List<Transaction> transactionList) {
                view.showTransactions(transactionList);
            }

            @Override
            public void onError(String errorMessage) {
                view.showErrorMessage(errorMessage);
            }
        });
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
}
