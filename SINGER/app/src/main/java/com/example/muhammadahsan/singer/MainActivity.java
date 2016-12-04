package com.example.muhammadahsan.singer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private String httpCalls(){

        try {
            //URL url = new URL(urlInput);
            URL url = new URL("http://www.vu.edu.pk");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            InputStream is =  urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String data = "";

            while(true){
                String temp = br.readLine();

                if(temp == null){
                    break;
                }
                data += temp;

            }

            Log.d("HTTP","Data = "+data);
            return data;




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //HttpURLConnection

        return null;

    }


    public class MyTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {
            String data = httpCalls();
            return data;
        }

        @Override
        protected void onPostExecute(String result) {


            //textView1.setText(result);
        }
    }

}
