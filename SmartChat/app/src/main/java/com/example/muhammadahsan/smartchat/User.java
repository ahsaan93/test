package com.example.muhammadahsan.smartchat;

/**
 * Created by Muhammad Ahsan on 2/5/2017.
 */

public class User {
    private String id;
    private String name;
    private String mobileNo;
    private String picUri;

    public User(String id, String name, String mobileNo, String picUri) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.picUri = picUri;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPicUri() {
        return picUri;
    }

    public void setPicUri(String picUri) {
        this.picUri = picUri;
    }
    

}
