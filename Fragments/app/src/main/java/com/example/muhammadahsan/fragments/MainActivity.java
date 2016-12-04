package com.example.muhammadahsan.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    TextView textView1;
    Button button1, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        clickListners();

        fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().add(R.id.fragment1, new FirstFragment()).commit();
    }

    public void initComponents(){
            button1 = (Button) findViewById(R.id.btn_1);
            button2 = (Button) findViewById(R.id.btn_2);
            button3 = (Button) findViewById(R.id.btn_3);
            button4 = (Button) findViewById(R.id.btn_4);
    }

    public void clickListners(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment1, new FirstFragment())
                        .addToBackStack("test")
                        .commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment1, new SecondFragment())
                        .addToBackStack("test")
                        .commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment1, FourthFragment.newInstance("This is 4th Fragment"))
                        //.replace(R.id.fragment1, new ThirdFragment())
                        .addToBackStack("test")
                        .commit();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.popBackStack();
            }
        });
    }

}
