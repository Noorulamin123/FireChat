package com.example.android.myapplication;



public class FriendlyMessage {

    private String text;
    private String name;
    private String photoUrl;
    private String key;


    public FriendlyMessage(){}

    public FriendlyMessage(String text, String name, String photoUrl, String key) {
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}