package com.costular.flatsharing.data;

import android.support.annotation.Nullable;

/**
 * Created by diego on 7/12/15.
 */
public class Group {

    private String title;
    private String description;
    private String[] members;

    public Group(@Nullable String title, @Nullable String description) {
        this.title = title;
        this.description = description;
    }

    public Group(@Nullable String title, @Nullable String description, String[] members) {

    }

    public boolean isTitleEmpty() {
        if(title == null || title.isEmpty()) {
            return true;
        }
        return false;
    }
}
