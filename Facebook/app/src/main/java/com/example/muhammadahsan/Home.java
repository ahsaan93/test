package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.muhammadahsan.facebook.MainActivity;
import com.example.muhammadahsan.facebook.R;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void toLogin(View view) {
        Intent intent = new Intent(Home.this, MainActivity.class);
    }
}
