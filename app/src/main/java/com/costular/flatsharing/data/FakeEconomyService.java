package com.costular.flatsharing.data;

import android.os.Handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by diego on 14/12/15.
 */
public class FakeEconomyService implements EconomyApiService{

    private List<Transaction> transactions;

    public FakeEconomyService(int size) {
        transactions = new ArrayList<>();
        for(int i = 1; i <= size; i++) {
            String now = new SimpleDateFormat("dd/MM/yyyy HH:mm:sss").format(new Date());
            transactions.add(new Transaction(i, null, i+20, null, "Subject " + i, now, false, ""));
        }
        Collections.reverse(transactions);
    }

    @Override
    public void getListOfTransactions(final ApiServiceListener<List<Transaction>> responseCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                responseCallback.onDataLoaded(transactions);
            }
        }, 2000);
    }

    @Override
    public void getTransaction(int id, ApiServiceListener<Transaction> transaction) {
        transaction.onDataLoaded(transactions.get(id));
    }

    @Override
    public void saveTransaction(Transaction transaction) {

    }

    @Override
    public void deleteTransaction(Transaction transaction) {

    }

    @Override
    public void refreshData() {

    }
}
