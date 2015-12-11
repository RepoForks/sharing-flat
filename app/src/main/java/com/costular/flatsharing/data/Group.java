package com.costular.flatsharing.data;

import android.support.annotation.Nullable;

/**
 * Created by diego on 7/12/15.
 */
public class Group {

    private int id;
    private String title;
    private String description;
    private String imageURL;
    private String[] members;

    public Group(int id, @Nullable String title, @Nullable String description,
                 @Nullable String imageURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Group(@Nullable String title, @Nullable String description, String[] members) {
        this.title = title;
        this.description = description;
        this.members = members;
    }

    public boolean isTitleEmpty() {
        if(title == null || title.isEmpty()) {
            return true;
        }
        return false;
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

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
