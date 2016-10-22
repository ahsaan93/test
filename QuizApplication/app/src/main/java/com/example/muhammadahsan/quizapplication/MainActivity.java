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

    String r1, r2, r3, Result;
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

        Button button = (Button) findViewById(R.id.btn_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int isSelected = radioGroup1.getCheckedRadioButtonId();
                radioButtonAnswer1 = (RadioButton) findViewById(isSelected);





            }
        });

    }

    public void checkAnswers(View view) {
        int isSelected = radioGroup1.getCheckedRadioButtonId();
        radioButtonAnswer1 = (RadioButton) findViewById(isSelected);
        r = isSelected;
/*
        if (radioButtonAnswer1.equals(-1)){
            r1 = "Answer1 is not yet selected";
        }else{
            if (rbanswer1.getText().toString().equals(radioButtonAnswer1.getText().toString()) ){
                r1 = "Answer1 is correct";
            }else{
                r1 = "Answer1 is not correcct";
            }

        }
*/


        //Toast.makeText(this, r, Toast.LENGTH_SHORT).show();

    }
}
