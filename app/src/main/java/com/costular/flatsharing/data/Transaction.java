package com.costular.flatsharing.data;

/**
 * Created by diego on 13/12/15.
 */
public class Transaction {

    private int id;
    private String[] payer;
    private int amount;
    private String[] payFor;
    private String subject;
    private String dateTime;
    private boolean hasImage;
    private String imageURL;

    public Transaction(int id, String[] payer, int amount, String[] payFor, String subject, String dateTime, boolean hasImage, String imageURL) {
        this.id = id;
        this.payer = payer;
        this.amount = amount;
        this.payFor = payFor;
        this.subject = subject;
        this.dateTime = dateTime;
        this.hasImage = hasImage;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getPayer() {
        return payer;
    }

    public void setPayer(String[] payer) {
        this.payer = payer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String[] getPayFor() {
        return payFor;
    }

    public void setPayFor(String[] payFor) {
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
