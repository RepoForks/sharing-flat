package com.costular.flatsharing.data;

import java.util.List;

/**
 * Created by diego on 14/12/15.
 */
public class EconomyDataCached implements EconomyDataSource{

    private EconomyApiService apiService;

    public EconomyDataCached(EconomyApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getActivityTransactions(final Callback callback) {
        apiService.getListOfTransactions(new EconomyApiService.ApiServiceListener<List<Transaction>>() {
            @Override
            public void onDataLoaded(List<Transaction> data) {
                callback.onActivityLoaded(data);
            }

            @Override
            public void onErrorMessage(String message) {
                callback.onError(message);
            }
        });
    }

    @Override
    public void addTransaction(Transaction transaction, EconomyApiService.ApiServiceListener<Boolean> response) {
        response.onErrorMessage("Aún no está implementado");
    }

    @Override
    public void deleteTransaction(Transaction transaction) {

    }

    @Override
    public void refreshData() {

    }
}
