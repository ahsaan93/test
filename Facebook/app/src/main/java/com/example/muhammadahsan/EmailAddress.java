package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadahsan.facebook.R;
import com.example.muhammadahsan.facebook.UserData;

public class EmailAddress extends AppCompatActivity {
    EditText mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_address);
        mail = (EditText) findViewById(R.id.editText_email);

    }
    public void goMobileNo(View view){

        UserData.email=null;
        Intent intent = new Intent(this, MobileNumber.class);startActivity(intent);
    }
    public void goName(View view){
        if (mail.getText().toString().isEmpty()){
            Toast.makeText(EmailAddress.this, "Email cannot leave empty", Toast.LENGTH_SHORT).show();
        }else{
            UserData.email= mail.getText().toString();
            Intent intent = new Intent(this, Name.class);startActivity(intent);
        }
    }
}
