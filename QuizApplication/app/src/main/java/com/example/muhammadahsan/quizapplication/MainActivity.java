package com.example.muhammadahsan.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup1,radioGroup2, radioGroup3;
    RadioButton radioButtonAnswer1, radioButtonAnswer2, radioButtonAnswer3;
    RadioButton rbanswer1, rbanswer2, rbanswer3;

    String r1, r2, r3, result, answer1, answer2, answer3, c1,c2, c3;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = (RadioGroup) findViewById(R.id.rg_1);
        radioGroup2 = (RadioGroup) findViewById(R.id.rg_2);
        radioGroup3 = (RadioGroup) findViewById(R.id.rg_3);

        rbanswer1 = (RadioButton) findViewById(R.id.rb_ans_1);
        rbanswer2 = (RadioButton) findViewById(R.id.rb_ans_2);
        rbanswer3 = (RadioButton) findViewById(R.id.rb_ans_3);

        answer1 = rbanswer1.getText().toString();
        answer2 = rbanswer2.getText().toString();
        answer3 = rbanswer3.getText().toString();
    }

    public void chk_validation(View v){
        if (radioGroup1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(MainActivity.this, "Answer 1 is not yet selected", Toast.LENGTH_SHORT).show();
        }
        else if (radioGroup2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(MainActivity.this, "Answer 2 is not yet selected", Toast.LENGTH_SHORT).show();
        }
        else if (radioGroup3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(MainActivity.this, "Answer 3 is not yet selected", Toast.LENGTH_SHORT).show();
        }
        else{

            int isSelected1 = radioGroup1.getCheckedRadioButtonId();
            radioButtonAnswer1 = (RadioButton) findViewById(isSelected1);
            r1 = radioButtonAnswer1.getText().toString();

            int isSelected2 = radioGroup2.getCheckedRadioButtonId();
            radioButtonAnswer2 = (RadioButton) findViewById(isSelected2);
            r2 = radioButtonAnswer2.getText().toString();

            int isSelected3 = radioGroup3.getCheckedRadioButtonId();
            radioButtonAnswer3 = (RadioButton) findViewById(isSelected3);
            r3 = radioButtonAnswer3.getText().toString();

            checkAnswers();

        }
    }

    public void checkAnswers(){
        if (!answer1.equals(r1)){
            c1 = "Answer 1 is not correct\n";
        }else{
            c1="";
        }
        if (!answer2.equals(r2)){
            c2 = "Answer 2 is not correct\n";
        }else{
            c2="";
        }
        if (!answer3.equals(r3)){
            c3 = "Answer 3 is not correct\n";
        }else{
            c3="";
        }
        result = c1+'\n'+c2+'\n'+c3;
        //Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        if(result.length() <= 2){
            result = "Congrats, All are correct";
        }else{
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
