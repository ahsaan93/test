package com.example.muhammadahsan.smartchat;

import android.telephony.SmsManager;

public class SendSMS {
    private String phoneNo;
    private String message;

    public SendSMS(String phoneNo, String message) {
        this.phoneNo = phoneNo;
        this.message = message;
    }

    public SendSMS() {
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean sendMessage(){
        boolean val = false;
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(this.phoneNo, null, this.message, null, null);
            val = true;
        } catch (Exception e) {
            e.printStackTrace();
            val = false;
        }
        return val;
    }
}
