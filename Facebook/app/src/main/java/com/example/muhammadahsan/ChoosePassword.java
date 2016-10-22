package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadahsan.facebook.DatabaseHelper;
import com.example.muhammadahsan.facebook.R;
import com.example.muhammadahsan.facebook.UserData;

public class ChoosePassword extends AppCompatActivity {
    EditText cPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_password);
        cPassword = (EditText) findViewById(R.id.editText_password);
    }
    public void goTermsPrivacy(View view){
        if (cPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Password cannot leave empty", Toast.LENGTH_SHORT).show();
        }else {
            UserData.password=cPassword.getText().toString();
            Intent intent = new Intent(this, TermsPrivacy.class);startActivity(intent);
        }
    }

}
