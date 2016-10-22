package com.example.muhammadahsan.facebook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    String DATABASE_NAME = "facebook.db";
    String TABLE_NAME = "users";
    String COL0 = "id";
    String COL1 = "first_name";
    String COL2 = "last_name";
    String COL3 = "age";
    String COL4 = "gender";
    String COL5 = "mobile_number";
    String COL6 = "email";
    String COL7 = "password";
    String COL8 = "fb_id";
    String COL9 = "profile_pic";
    String COL10 = "cover_pic";
    String COL11 = "detail_about_you";

    public DatabaseHelper(Context context) {
        super(context, "facebook.db", null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+
                "("+
                COL0 + " integer primary key autoincrement, "+
                COL1 + " text, "+
                COL2 + " text, "+
                COL3 + " int, "+
                COL4 + " text, "+
                COL5 + " text, "+
                COL6 + " text, "+
                COL7 + " text, "+
                COL8 + " text, "+
                COL9 + " blob, "+
                COL10 + " blob, "+
                COL11+ " text"+
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
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
    public void onInsert(String first_name, String last_name,String gender,String mobile_number,String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Insert into users(first_name, last_name, gender, mobile_number, email, password)" +
                " values('"+first_name+"', '"+last_name+"', '"+gender+"', '"+mobile_number+"', '"+email+"', '"+password+"')");
    }
    public String searchID(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users where mobile_number = '"+id+"' or email = '"+id+"'" , null);
        if (c.getCount() == 0) {
            return "Record not found";
        }
        else{
            StringBuffer buffer=new StringBuffer();
            c.moveToNext();
            buffer.append(c.getString(7)).toString();
            return buffer.toString();
        }
    }
    public String searchRecord(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users where mobile_number = '"+id+"' or email = '"+id+"'" , null);
        if (c.getCount() == 0) {
            return "Record not found";
        }
        else{
            StringBuffer buffer=new StringBuffer();
                c.moveToNext();

                buffer.append("Name: "+c.getString(1)+" ");
                buffer.append(c.getString(2)+"\n");
                buffer.append("Mobile Number: "+c.getString(5)+"\n");
                buffer.append("Email: "+c.getString(6)+"\n");
                buffer.append("Password: "+c.getString(7));

            return buffer.toString();
        }
    }
}