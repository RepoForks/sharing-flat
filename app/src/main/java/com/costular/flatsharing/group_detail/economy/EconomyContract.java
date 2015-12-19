package com.costular.flatsharing.group_detail.economy;

import com.costular.flatsharing.data.Transaction;

import java.util.List;

/**
 * Created by diego on 13/12/15.
 */
public class EconomyContract {

    public interface MyView {

        void setProgressIndicator(boolean active);

        void showAddTransaction();

        void showErrorMessage(String message);

        void showTransactions(List<Transaction> transactionList);

        void showTransactionsActivity();

        void showListOfGroups();

        void openSettings();

        void deleteTransaction();

        void confirmDeleteTransaction();

        void payTransaction();

        void openDetailTransaction();
    }

    public interface UserActionListener {

        void addTransaction();

        void showActivity();

        void leaveGroup();

        void openSettings();

        void openDetailTransaction();

        void loadTransactions(boolean forceUpdate);

        void deleteTransaction();

        void confirmDeleteTransaction();

        void payTransaction();
    }
}
