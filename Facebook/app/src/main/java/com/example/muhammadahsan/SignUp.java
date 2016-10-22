package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhammadahsan.facebook.DatabaseHelper;
import com.example.muhammadahsan.facebook.R;
import com.example.muhammadahsan.facebook.UserData;

public class SignUp extends AppCompatActivity {
    DatabaseHelper myDB;
    Intent intent;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        myDB = new DatabaseHelper(this);
        SignUp();
    }
    public void SignUp(){

        if (UserData.first_name.length() == 0 || UserData.last_name.length()==0) {
            Toast.makeText(SignUp.this, "Mandatory field cannot be empty", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, Name.class);
            startActivity(intent);
        }else if (UserData.password.length()==0){
            Toast.makeText(SignUp.this, "Password cannot leave empty", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, Name.class);startActivity(intent);
        }else{
            myDB.onInsert(UserData.first_name, UserData.last_name, UserData.gender, UserData.mobile_number, UserData.email, UserData.password);
            Toast.makeText(SignUp.this, "You are seccessfully signed Up", Toast.LENGTH_SHORT).show();

            intent = new Intent(this, Home.class);startActivity(intent);
        }
    }
}
