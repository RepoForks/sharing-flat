package com.costular.flatsharing.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Created by diego on 7/12/15.
 */
public class Group implements Parcelable{

    private int id;
    private String title;
    private String description;
    private String imageURL;
    private String[] members;

    public Group(int id, String title, @Nullable String description,
                 @Nullable String imageURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Group(Parcel parcel) {
        readFromParcel(parcel);
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

    public static final Parcelable.Creator<Group> CREATOR
            = new Parcelable.Creator<Group>() {
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description == null ? "" : description);
        dest.writeString(imageURL);
    }

    private void readFromParcel(Parcel in) {
        setId(in.readInt());
        setTitle(in.readString());
        setDescription(in.readString());
        setImageURL(in.readString());
    }
}
