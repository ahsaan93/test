package com.example.muhammadahsan.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.muhammadahsan.courtcounter.R.string.resetCounter;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA=0;
    int scoreTeamB=0;

    Button reset, teamA_3, teamA_2, teamA_1, teamB_3, teamB_2, teamB_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ini_buttons();
        click_buttons();
    }

    private void ini_buttons(){
        reset = (Button) findViewById(R.id.btn_reset);
        teamA_1 = (Button) findViewById(R.id.btn_ta_freethrow);
        teamA_2 = (Button) findViewById(R.id.btn_ta_twoPoints);
        teamA_3 = (Button) findViewById(R.id.btn_ta_threePoints);
        teamB_1 = (Button) findViewById(R.id.btn_tb_freethrow);
        teamB_2 = (Button) findViewById(R.id.btn_tb_twoPoints);
        teamB_3 = (Button) findViewById(R.id.btn_tb_threePoints);
    }

    private void click_buttons(){
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreTeamA=0;
                scoreTeamB=0;

                teamA(0);
                teamB(0);
                Toast.makeText(MainActivity.this, R.string.resetCounter, Toast.LENGTH_SHORT).show();
            }
        });

        teamA_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA(1);
            }
        });
        teamA_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA(2);
            }
        });
        teamA_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA(3);
            }
        });

        teamB_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB(1);
            }
        });
        teamB_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB(2);
            }
        });
        teamB_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB(3);
            }
        });
    }

    private void teamA(int score){
        TextView scoreTA = (TextView) findViewById(R.id.textView_teamScoreA);
        scoreTeamA = scoreTeamA + score;
        scoreTA.setText(String.valueOf(scoreTeamA));
    }

    private void teamB(int score){
        TextView scoreTB = (TextView) findViewById(R.id.textView_teamScoreB);
        scoreTeamB = scoreTeamB + score;
        scoreTB.setText(String.valueOf(scoreTeamB));
    }
}
