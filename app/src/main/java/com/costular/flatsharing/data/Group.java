package com.costular.flatsharing.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego on 7/12/15.
 */
public class Group implements Parcelable{

    private int id;
    private String title;
    private String description;
    private String imageURL;
    private List<User> members;

    private void addMembers() {
        members = new ArrayList<>();
        members.add(new User(1, "Diego F", "https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAccAAAAJGVkZjkzMmNhLTU1YjQtNDgwMC04Mjc5LTI0NWQzZDIyZjJmYg.jpg",
                "diegooo.fc@gmail.com"));
        members.add(new User(2, "Diego R", "http://i.imgur.com/FA63bAp.jpg", "esferca13@gmail.com"));
        members.add(new User(3, "Eusebio", "http://cd00.epimg.net/cincodias/imagenes/2013/02/15/economia/1361168906_740215_0000000001_noticia_normal.jpg",
                "euse@gmail.com"));
    }

    public Group(int id, String title, @Nullable String description,
                 @Nullable String imageURL) {
        addMembers();
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
    }

    public Group(Parcel parcel) {
        addMembers();
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

    public List<User> getMembers() {
        return members;
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
