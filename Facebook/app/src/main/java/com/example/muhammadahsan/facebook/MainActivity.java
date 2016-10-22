package com.example.muhammadahsan.facebook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadahsan.EmailAddress;
import com.example.muhammadahsan.FindYourAccount;
import com.example.muhammadahsan.Home;
import com.example.muhammadahsan.MobileNumber;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    UserData userData;
    Button btn_Login;
    EditText editText_id,editText_password;
    String id,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);
        userData = new UserData();
        btn_Login = (Button) findViewById(R.id.button_login);
        editText_id = (EditText) findViewById(R.id.editText_loginName);
        editText_password = (EditText) findViewById(R.id.editText_password);

    }
    public void doLogin(View view) {
        id = editText_id.getText().toString();
        password = editText_password.getText().toString();

        if (id.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Mandatory feild cannot leave empty", Toast.LENGTH_SHORT).show();
        } else if (password.equals(myDB.searchID(id))) {
            Toast.makeText(MainActivity.this, "Successful login..", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home.class); startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void signUp_mobileNo(View view){
        Intent intent = new Intent(this, MobileNumber.class); startActivity(intent);
    }

    public void forgotPassword(View view){
        Intent intent = new Intent(this, FindYourAccount.class); startActivity(intent);
    }
}

