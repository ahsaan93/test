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
    EditText editText_name,editText_marks,editText_grade,editText_updateID,editText_deleteID, editText_viewRecord;
    Button addDataButton,viewAllButton,btn_viewRecord;
    TextView textView_records;

    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editText_name = (EditText)findViewById(R.id.editText_name);
        editText_marks = (EditText)findViewById(R.id.editText_marks);
        editText_grade = (EditText)findViewById(R.id.editText_grade);
        editText_updateID = (EditText)findViewById(R.id.editText_updateID);
        editText_deleteID = (EditText)findViewById(R.id.editText_deleteID);
        editText_viewRecord = (EditText)findViewById(R.id.editText_viewID);

        addDataButton = (Button)findViewById(R.id.button_addData);
        viewAllButton = (Button)findViewById(R.id.button_viewAll);
        btn_viewRecord = (Button) findViewById(R.id.button_viewRecord);
        textView_records = (TextView) findViewById(R.id.textView_result);
    }

    public  void addData(View view) {
        myDb.onInsert(
                editText_name.getText().toString(),
                editText_marks.getText().toString(),
                editText_grade.getText().toString());
        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }
    public void viewRecord(View view) {
        textView_records.setText(myDb.viewRecord(MainActivity.this,Integer.parseInt(editText_viewRecord.getText().toString())));
        Toast.makeText(MainActivity.this, "Record found "+editText_viewRecord.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    public void viewAll(View view) {
        textView_records.setText(myDb.viewAll(MainActivity.this));
    }
    public void updateID(View view) {
        myDb.onUpdate(Integer.parseInt(editText_updateID.getText().toString()),editText_name.getText().toString(), editText_marks.getText().toString(), editText_grade.getText().toString());
        Toast.makeText(MainActivity.this, "Record updated", Toast.LENGTH_SHORT).show();
    }
    public void deleteID(View view) {
        myDb.onDelete(Integer.parseInt(editText_deleteID.getText().toString()));
        Toast.makeText(MainActivity.this, "Record deleted", Toast.LENGTH_SHORT).show();

    }
}
