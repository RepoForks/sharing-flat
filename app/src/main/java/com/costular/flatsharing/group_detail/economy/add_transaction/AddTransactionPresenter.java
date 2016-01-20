package com.costular.flatsharing.group_detail.economy.add_transaction;

import com.costular.flatsharing.data.EconomyApiService;
import com.costular.flatsharing.data.EconomyDataSource;
import com.costular.flatsharing.data.Transaction;

/**
 * Created by diego on 20/01/16.
 */
public class AddTransactionPresenter implements AddTransactionContract.UserActionListener {

    private AddTransactionContract.MyView view;
    private EconomyDataSource economyDataSource;

    public AddTransactionPresenter(AddTransactionContract.MyView view, EconomyDataSource economyDataSource) {
        this.view = view;
        this.economyDataSource = economyDataSource;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        if (transaction != null) {
            economyDataSource.addTransaction(transaction, new EconomyApiService.ApiServiceListener<Boolean>() {
                @Override
                public void onDataLoaded(Boolean data) {
                    view.showListTransactions();
                }

                @Override
                public void onErrorMessage(String message) {
                    view.showError(message);
                }
            });
        } else {
            view.showError("Hubo un error al guardar");
        }
    }
}
