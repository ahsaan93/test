package com.example.muhammadahsan.smartchat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Message {

    private String time;/// = new SimpleDateFormat("HH:mm a").format(Calendar.getInstance().getTime());
    private String message;
    private String key;

    public Message() {
    }

    public Message(String time, String message, String key) {
        this.time = time;
        this.message = message;
        this.key = key;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
