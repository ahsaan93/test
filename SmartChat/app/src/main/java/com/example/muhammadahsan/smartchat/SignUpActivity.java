package com.example.muhammadahsan.smartchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class SignUpActivity extends AppCompatActivity {

    EditText phoneNo;
    Button next;
    ImageView send;

    static int randomKey,receivedKey;
    static String mobileNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initGedgets();
        gedgetsListners();
    }

    private void initGedgets() {
        MainActivity.currentActivity = "activity_sign_up";
        phoneNo = (EditText) findViewById(R.id.editText_mobileNo);
        next = (Button) findViewById(R.id.btn_next);
        send = (ImageView) findViewById(R.id.pic_send);
    }

    private void gedgetsListners() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phoneNo.getText().toString().length() < 11){
                    Toast.makeText(SignUpActivity.this, "Phone No is not valid, kindly try again", Toast.LENGTH_SHORT).show();
                }else{

                    randomKey = new GenerateKey().getKey();

                    Toast.makeText(SignUpActivity.this, "Register...", Toast.LENGTH_LONG).show();

                    SendSMS sendSMS = new SendSMS();
                    mobileNumber = phoneNo.getText().toString();
                    sendSMS.setPhoneNo(mobileNumber);
                    sendSMS.setMessage("Your registeration key is "+randomKey+"\nThanks\nSmartChart Team");
                    boolean result = sendSMS.sendMessage();

                    if (result==true){
                        Toast.makeText(SignUpActivity.this, "Confirmation key successfully sent", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, Confirm_KeyActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignUpActivity.this, "Confirmation key sending failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(MainActivity.currentActivity.equals("activity_sign_up")){
            super.onPause();
            //super.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }
}
