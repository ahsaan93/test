package com.example.muhammadahsan.sqldbapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public void onDelete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM STUDENTS WHERE ID = "+id);
    }
    public void onUpdate(int id, String name, String marks, String grade){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE STUDENTS SET NAME='"+name+"', MARKS='"+marks+"', GRADE='"+grade+"' WHERE ID="+id);
    }
    public void onInsert(String name, String marks, String grade){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Insert into students(name,marks,grade) values('"+name+"','"+marks+"','"+grade+"')");
    }
    public String viewAll(Context context){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM students", null);
        if(c.getCount()==0)
        {
            return "Error - No records found";
        }
        else{
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("RollNo: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Marks: "+c.getString(2)+"\n");
                buffer.append("Grade: "+c.getString(3)+"\n\n");
            }
            return buffer.toString();
        }
    }
    public String viewRecord(Context context, int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM students where id = "+id, null);
        if(c.getCount()==0)
        {
            return "Error - No records found";
        }
        else{
            StringBuffer buffer=new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("RollNo: "+c.getString(0)+"\n");
                buffer.append("Name: "+c.getString(1)+"\n");
                buffer.append("Marks: "+c.getString(2)+"\n");
                buffer.append("Grade: "+c.getString(3)+"\n\n");
            }
            return buffer.toString();

        }
    }
}