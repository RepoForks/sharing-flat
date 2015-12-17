package com.costular.flatsharing.data;

/**
 * Created by diego on 17/12/15.
 */
public class User {

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
}
