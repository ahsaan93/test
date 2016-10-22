package com.example.muhammadahsan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.muhammadahsan.facebook.R;
import com.example.muhammadahsan.facebook.UserData;

public class Gender extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }
    public void goPassword(View view){
        int isSelected= radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(isSelected);
        UserData.gender = radioButton.getText().toString();

        Intent intent = new Intent(this, ChoosePassword.class);startActivity(intent);
    }
}
