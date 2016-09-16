package com.example.muhammadahsan.sqldbapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_name,editText_marks,editText_grade;
    Button addDataButton;

    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editText_name = (EditText)findViewById(R.id.editText_name);
        editText_marks = (EditText)findViewById(R.id.editText_marks);
        editText_grade = (EditText)findViewById(R.id.editText_grade);
        addDataButton = (Button)findViewById(R.id.button_addData);
        //addData();
    }

    public  void addData(View view){
        boolean isInserted = myDb.onInsert(
                editText_name.getText().toString(),
                editText_marks.getText().toString(),
                editText_grade.getText().toString());
        if (isInserted==true)
            Toast.makeText(MainActivity.this, "Data is Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data is not Inserted",Toast.LENGTH_LONG).show();
    }

}
