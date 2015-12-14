package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 14/12/15.
 */
public interface EconomyApiService {

    public interface ApiServiceListener<T> {
        void onDataLoaded(T data);
        void onErrorMessage(String message);
    }

    void getListOfTransactions(ApiServiceListener<List<Transaction>> responseCallback);

    void getTransaction(int id, ApiServiceListener<Transaction> transaction);

    void saveTransaction(Transaction transaction);

    void deleteTransaction(Transaction transaction);

    void refreshData();
}
