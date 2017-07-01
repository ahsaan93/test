package com.example.muhammadahsan.lms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference myRef= FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRefChild_id;

    Button sign_in;
    EditText loginID;
   // Users users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
       // classesInstance();
        //clickListener();
    }
    public void initWidgets(){

        sign_in = (Button) findViewById(R.id.btn_sign_in);
        loginID = (EditText) findViewById(R.id.editText_loginID);

    }
    //public void classesInstance(){
     //   users = new Users();
    //}
    public void clickListener(){
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // users.add_user("Haqnawaz","ssddsab123",37,"haqnawaz84gmail.com");

                Toast.makeText(MainActivity.this, "User name is ", Toast.LENGTH_LONG).show();

            }
        });
    }
}
