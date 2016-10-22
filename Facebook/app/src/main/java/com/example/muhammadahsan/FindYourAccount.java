package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadahsan.facebook.DatabaseHelper;
import com.example.muhammadahsan.facebook.R;

public class FindYourAccount extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText searchID;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_your_account);
        myDB = new DatabaseHelper(this);

        searchID = (EditText)findViewById(R.id.editText_search);
    }
    public void doFindYourAccount(View view) {
        id = searchID.getText().toString();

        if (id.isEmpty()){
            Toast.makeText(this, "Enter email or phone number", Toast.LENGTH_SHORT).show();
        }else if (myDB.searchRecord(id).equals("Record not found")){
            Toast.makeText(FindYourAccount.this,"Record not found" , Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(FindYourAccount.this,myDB.searchRecord(id) , Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(this, MobileNumber.class); startActivity(intent);
        }
    }

}
