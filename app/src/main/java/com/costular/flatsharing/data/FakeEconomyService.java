package com.costular.flatsharing.data;

import android.os.Handler;

import com.costular.flatsharing.util.MathUtils;

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

        User payer = new User(1, "Diego F", "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAccAAAAJGVkZjkzMmNhLTU1YjQtNDgwMC04Mjc5LTI0NWQzZDIyZjJmYg.jpg", "diegooo.fc@gmail.com");
        User payerTwo = new User(2, "Diego R", "http://i.imgur.com/FA63bAp.jpg", "apdokwaopd@gmail.com");
        User payerReceiver = new User(2, "Todos", "", "");
        for(int i = 1; i <= size; i++) {
            String now = new SimpleDateFormat("dd/MM/yy").format(new Date());
            transactions.add(new Transaction(i, new User[] {payer}, MathUtils.randInt(i, 40), new User[] {payerReceiver}, "Subject " + i, now, false, ""));
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
