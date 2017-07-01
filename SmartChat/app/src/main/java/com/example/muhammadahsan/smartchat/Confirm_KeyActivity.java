package com.example.muhammadahsan.smartchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm_KeyActivity extends AppCompatActivity {

    Button confirm,resend;
    TextView key;
    EditText receivedKey;
    int randomKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_key);

        initGedgets();
        gedgetsListners();
    }

    private void initGedgets() {
        MainActivity.currentActivity = "activity_confirm_key";
        key = (TextView) findViewById(R.id.tv_key);
        randomKey = SignUpActivity.randomKey;
        key.setText(String.valueOf(randomKey));
        receivedKey = (EditText) findViewById(R.id.ed_receivedKey);
        confirm = (Button) findViewById(R.id.btn_confirm);
        resend = (Button) findViewById(R.id.btn_resend);
    }

    private void gedgetsListners() {
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(randomKey).equals(receivedKey.getText().toString())){
                    Intent intent = new Intent(Confirm_KeyActivity.this, NameActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Confirm_KeyActivity.this, "Key does not matched", Toast.LENGTH_SHORT).show();
                }
            }
        });
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendSMS sendSMS = new SendSMS();
                sendSMS.setPhoneNo(SignUpActivity.mobileNumber);
                sendSMS.setMessage("Your registeration key is "+randomKey+"\nThanks\nSmartChart Team");
                boolean result = sendSMS.sendMessage();
                if (result==true){
                    randomKey = new GenerateKey().getKey();
                    key.setText(String.valueOf(randomKey));
                    Toast.makeText(Confirm_KeyActivity.this, "Confirmation key successfully sent", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Confirm_KeyActivity.this, "Confirmation key sending failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(MainActivity.currentActivity.equals("activity_confirm_key")){
            super.onPause();
            //super.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }

}
