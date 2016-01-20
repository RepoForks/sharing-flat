package com.costular.flatsharing.group_detail.economy.add_transaction;

import com.costular.flatsharing.data.Transaction;

/**
 * Created by diego on 20/01/16.
 */
public interface AddTransactionContract {

    public interface MyView {

        void showListTransactions();

        void loadUserSpinner();

        void loadUserPayments();

        void showError(String message);

    }

    public interface UserActionListener {

        void saveTransaction(Transaction transaction);

    }
}
