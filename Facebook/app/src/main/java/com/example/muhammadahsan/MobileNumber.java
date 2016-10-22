package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadahsan.facebook.R;
import com.example.muhammadahsan.facebook.UserData;

public class MobileNumber extends AppCompatActivity {
    EditText mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);
        mobile = (EditText) findViewById(R.id.editText_mobileNo);
    }
    public void goEmail(View view){
        UserData.mobile_number = null;
        Intent intent = new Intent(this, EmailAddress.class);startActivity(intent);
    }
    public void goName(View view){
        if (mobile.getText().toString().isEmpty()){
            Toast.makeText(this, "Mobile number cannot leave empty", Toast.LENGTH_SHORT).show();
        }else if (mobile.getText().toString().length()<=10){
            Toast.makeText(this, "Mobile number is wrong", Toast.LENGTH_SHORT).show();
        }else {
            UserData.mobile_number = mobile.getText().toString();
            Intent intent = new Intent(this, Name.class);startActivity(intent);
        }
    }
}
