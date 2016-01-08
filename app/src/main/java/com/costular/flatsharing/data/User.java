package com.costular.flatsharing.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by diego on 17/12/15.
 */
public class User implements Parcelable {

    int id;
    String name;
    String avatarURL;
    String email;

    public User(int id, String name, String avatarURL, String email) {
        this.id = id;
        this.name = name;
        this.avatarURL = avatarURL;
        this.email = email;
    }

    public User(Parcel parcel) {
        readFromParcel(parcel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(avatarURL);
        dest.writeString(email);
    }

    private void readFromParcel(Parcel in) {
        setId(in.readInt());
        setName(in.readString());
        setAvatarURL(in.readString());
        setEmail(in.readString());
    }
}
