package com.example.muhammadahsan;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

import com.example.muhammadahsan.singer.DB_TNSNAMES;
import com.example.muhammadahsan.singer.R;

import static com.example.muhammadahsan.LoginActivity.dbStatus;
import static com.example.muhammadahsan.singer.Splashscreen.connection;
import static com.example.muhammadahsan.singer.Splashscreen.dbConnection;
import static com.example.muhammadahsan.singer.Splashscreen.status;


public class MainActivity extends Activity {
    //AsyncTask PostTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ElementInitialization();
        //ElementListners();

 /*       if (connection != null) {
            Toast.makeText(getApplicationContext(), "Database Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Connection failed!", Toast.LENGTH_SHORT).show();
        }*/


        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

        PostTask();
    }

    public void ElementInitialization() {
    }

    public void ElementListners() {
    }

    // The definition of our task class
    private void PostTask() {
        new AsyncTask<Void, Void, String>() {
            protected String doInBackground(Void... params) {
                while(connection == null){
                    dbConnection = new DB_TNSNAMES();
                    status = dbConnection.connect_SingerDEV();

//                        dbStatus.setText(status);
                        //Toast.makeText(getApplicationContext(), ""+status, Toast.LENGTH_SHORT).show();
                }
                //return "Connected";
                if (status){
                    return "Connected";
                }else{
                    return "Not connected";
                }

            }
            protected void onPostExecute(String mgs) {

                dbStatus.setText(mgs);
                //Toast.makeText(getApplicationContext(), mgs, Toast.LENGTH_SHORT).show();
            }
        }.execute();


    }


}
