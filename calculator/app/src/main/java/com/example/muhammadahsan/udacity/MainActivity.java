package com.example.muhammadahsan.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    String num;
    String num1="";

    int number1=0;
    int number2=0;
    String act="";
    int result=0;

    public void doClear(View view) {
        num1 = "";
        act="Cleared";
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
        Toast.makeText(this, act, Toast.LENGTH_SHORT).show();
    }

    public void doAdd(View view) {
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        number1 = Integer.parseInt(textView1.getText().toString());
        num1 = "";
        act="+";
        textView1.setText(num1);
        Toast.makeText(this, "+Plus with", Toast.LENGTH_SHORT).show();
    }

    public void doSub(View view) {
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        number1 = Integer.parseInt(textView1.getText().toString());
        num1 = "";
        act="-";
        textView1.setText(num1);
        Toast.makeText(this, "-Minus to", Toast.LENGTH_SHORT).show();
    }

    public void doMultiple(View view) {
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        number1 = Integer.parseInt(textView1.getText().toString());
        num1 = "";
        act="*";
        textView1.setText(num1);
        Toast.makeText(this, "xMultiply by", Toast.LENGTH_SHORT).show();
    }

    public void doDivide(View view) {
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        number1 = Integer.parseInt(textView1.getText().toString());
        num1 = "";
        act="/";
        textView1.setText(num1);
        Toast.makeText(this, "/Divide by", Toast.LENGTH_SHORT).show();
    }
    public void equal(View view){
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        number2 = Integer.parseInt(textView1.getText().toString());

        if (act.equals("+")){
          result = number1+number2;}
        else if(act.equals("-")){
            result = number1-number2;}
        else if(act.equals("*")){
            result = number1*number2;}
        else if(act.equals("/")){
            result = number1/number2;}

        textView1.setText(String.valueOf(result));
        Toast.makeText(this, "Your result is = "+ String.valueOf(result), Toast.LENGTH_SHORT).show();
        num1="";
    }
    public void press0(View view) {
        Button button = (Button) findViewById(R.id.zero);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press1(View view) {
        Button button = (Button) findViewById(R.id.one);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press2(View view) {
        Button button = (Button) findViewById(R.id.two);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press3(View view) {
        Button button = (Button) findViewById(R.id.three);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }


    public void press4(View view) {
        Button button = (Button) findViewById(R.id.four);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press5(View view) {
        Button button = (Button) findViewById(R.id.five);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press6(View view) {
        Button button = (Button) findViewById(R.id.six);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press7(View view) {
        Button button = (Button) findViewById(R.id.seven);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press8(View view) {
        Button button = (Button) findViewById(R.id.eight);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }

    public void press9(View view) {
        Button button = (Button) findViewById(R.id.nine);
        num = button.getText().toString();

        num1 = num1 + num;
        TextView textView1 = (TextView) findViewById(R.id.resultBox);
        textView1.setText(num1);
    }


}