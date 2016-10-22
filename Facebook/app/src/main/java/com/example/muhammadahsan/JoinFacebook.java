package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.muhammadahsan.facebook.R;
import com.example.muhammadahsan.facebook.UserData;

public class JoinFacebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_facebook);
    }
    public void goGender(View view){
        Intent intent = new Intent(this, Gender.class);startActivity(intent);
    }
}
