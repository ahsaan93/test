package com.example.muhammadahsan.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText studentID;
    TextView studentDetail;
    Button search;
    ReportCard reportCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialized_gedgets();
        gedgets_listners();
    }
    public void initialized_gedgets(){

        studentID = (EditText) findViewById(R.id.editText_studentID);
        studentDetail = (TextView) findViewById(R.id.textView_StudentDetail);
        search = (Button) findViewById(R.id.btn_search);

        reportCard = new ReportCard("100", "Ahsan", "9th", 2008, 84);

        reportCard.setStudentID("101", "Farhan", "10th", 2006, 95);
        reportCard.setStudentID("102", "Imran", "5th", 2000, 45);
        reportCard.setStudentID("103", "Haqnawaz", "3rd", 2009, 99);
        reportCard.setStudentID("104", "Rabnawaz", "7th", 2004, 54);
        reportCard.setStudentID("105", "Saad", "9th", 2003, 45);
        reportCard.setStudentID("106", "Asad", "10th", 2008, 31);
        reportCard.setStudentID("107", "Ali", "4th", 2002, 65);
        reportCard.setStudentID("108", "Sabir", "7th", 2001, 10);

        //System.out.print(reportCard.getStudentID("102"));

    }
    public void gedgets_listners(){
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDetail.setText(reportCard.getStudentID(studentID.getText().toString()));
            }
        });
    }
}
