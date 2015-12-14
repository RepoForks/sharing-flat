package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 14/12/15.
 */
public interface EconomyDataSource {

    public interface Callback {
        void onActivityLoaded(List<Transaction> transactionList);
        void onError(String errorMessage);
    }

    void getActivityTransactions(Callback callback);

    void addTransaction(Transaction transaction);

    void deleteTransaction(Transaction transaction);

    void refreshData();
}
