package com.example.muhammadahsan.sqldbapp;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;

public class DatabaseHelper extends SQLiteOpenHelper {
    String stu;
    public DatabaseHelper(Context context) {
        super(context, "Student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table students(id integer primary key autoincrement, name text, marks text, grade text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop if exists students");
        onCreate(db);
    }

    public boolean onInsert(String name, String marks, String grade){
        SQLiteDatabase db = this.getWritableDatabase();

        //long result = db.execSQL("Insert into students(name,marks,grade) values ("+name+","+marks+","+grade+")");
        //return true;


        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("marks",marks);
        contentValues.put("grade",grade);
        long result = db.insert("students",null,contentValues);
        if (result==-1){
            return false;
        }else{
            return true;
        }
    }
    public void onSelect(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        // Retrieving all records
        Cursor c=db.rawQuery("SELECT * FROM student", null);
        // Checking if no records found
        if(c.getCount()==0)
        {
            showMessage("Error", "No records found");
            return;
        }
        // Appending records to a string buffer
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("Rollno: "+c.getString(0)+"\n");
            buffer.append("Name: "+c.getString(1)+"\n");
            buffer.append("Marks: "+c.getString(2)+"\n\n");
        }
        // Displaying all records
        //showMessage("Student Details", buffer.toString());
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

/*        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
*/
    }
}
