package com.example.muhammadahsan.intentactivites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.muhammadahsan.ColorsActivity;
import com.example.muhammadahsan.FamilyMembersActivity;
import com.example.muhammadahsan.NumbersActivity;
import com.example.muhammadahsan.PhrasesActivity;

public class MainActivity extends AppCompatActivity {
    TextView numbers,familyMembers, colors, phrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers = (TextView)findViewById(R.id.textView_numbers);
        numbers = (TextView)findViewById(R.id.textView_familyMembers);
        numbers = (TextView)findViewById(R.id.textView_Colors);
        numbers = (TextView)findViewById(R.id.textView_phrases);

    }
    public  void goNumber(View view){
        Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
        startActivity(intent);
    }
    public  void goFamilyMembers(View view){
        Intent intent = new Intent(MainActivity.this, FamilyMembersActivity.class);
        startActivity(intent);
    }
    public  void goColors(View view){
        Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
        startActivity(intent);
    }
    public  void goPhrases(View view){
        Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
        startActivity(intent);
    }
}
