package com.example.muhammadahsan;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

import com.example.muhammadahsan.singer.DB_TNSNAMES;
import com.example.muhammadahsan.singer.R;

import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends Activity {
    public static DB_TNSNAMES dbConnection;
    public static Statement stmt;
    public static ResultSet resultSet;
    public static String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ElementInitialization();
        ElementListners();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);


    }
    public void ElementInitialization(){
        dbConnection = new DB_TNSNAMES();
        String status = dbConnection.connect_SingerDEV();
        Toast.makeText(getApplicationContext(), ""+dbConnection.connect_SingerDEV(), Toast.LENGTH_SHORT).show();
    }

    public void ElementListners(){

    }

}
