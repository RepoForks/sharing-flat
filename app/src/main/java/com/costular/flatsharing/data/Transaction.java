package com.costular.flatsharing.data;

import android.content.Context;

import com.costular.flatsharing.R;

/**
 * Created by diego on 13/12/15.
 */
public class Transaction {

    public static final String PAYMENT = "payment";
    public static final String DEBT_PAYMENT = "debt_payment";


    private int id;
    private User[] payer;
    private int amount;
    private User[] payFor;
    private String subject;
    private String dateTime;
    private boolean hasImage;
    private String imageURL;

    public Transaction(int id, User[] payer, int amount, User[] payFor, String subject, String dateTime, boolean hasImage, String imageURL) {
        this.id = id;
        this.payer = payer;
        this.amount = amount;
        this.payFor = payFor;
        this.subject = subject;
        this.dateTime = dateTime;
        this.hasImage = hasImage;
        this.imageURL = imageURL;
    }

    public String getTitleOfTransaction(Context context) {
        if(payer.length > 0) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < payer.length; i++) {
                builder.append(payer[i].getName());
                if(i == payer.length - 1) {
                    continue;
                }
                builder.append(", ");
            }
            int resource = payer.length > 1 ? R.string.economy_activity_plural_payment_title
                    : R.string.economy_activity_singular_payment_title;
            return String.format(context.getString(resource), builder.toString(), getAmount());
        }
        return "";
    }

    public String getDescriptionOfTransaction(Context context) {
        if(payFor.length > 0) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < payFor.length; i++) {
                builder.append(payFor[i].getName());
                if(i == payFor.length - 1) {
                    continue;
                }
                builder.append(", ");
            }

            return String.format(context.getString(R.string.economy_activity_payment_to), builder.toString());
        }
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User[] getPayer() {
        return payer;
    }

    public void setPayer(User[] payer) {
        this.payer = payer;
    }

    public User[] getPayFor() {
        return payFor;
    }

    public void setPayFor(User[] payFor) {
        this.payFor = payFor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
