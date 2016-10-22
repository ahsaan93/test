package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadahsan.facebook.R;
import com.example.muhammadahsan.facebook.UserData;

public class Name extends AppCompatActivity {
    EditText fName,lName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        fName = (EditText) findViewById(R.id.editText_FirstName);
        lName = (EditText) findViewById(R.id.editText_LastName);

    }
    public void goJoinFacebook(View view){


        if (lName.getText().toString().isEmpty() || fName.getText().toString().isEmpty()){
            Toast.makeText(this, "Mandatory feild cannot leave empty", Toast.LENGTH_SHORT).show();
        }else {
            UserData.first_name = fName.getText().toString();
            UserData.last_name = lName.getText().toString();
            Intent intent = new Intent(this, JoinFacebook.class);startActivity(intent);
        }
    }
}
