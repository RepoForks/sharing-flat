package com.costular.flatsharing.data;

import java.util.Date;
import java.util.List;

/**
 * Created by diego on 19/12/15.
 */
public class Task {

    private int id;
    private String title;
    private String description;
    private List<User> usersHaveToDoIt;
    private Date limitDate;
    private boolean isImportant;
    private int color;

    public Task(int id, String title, String description, List<User> usersHaveToDoIt, Date limitDate, boolean isImportant, int color) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.usersHaveToDoIt = usersHaveToDoIt;
        this.limitDate = limitDate;
        this.isImportant = isImportant;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsersHaveToDoIt() {
        return usersHaveToDoIt;
    }

    public void setUsersHaveToDoIt(List<User> usersHaveToDoIt) {
        this.usersHaveToDoIt = usersHaveToDoIt;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
