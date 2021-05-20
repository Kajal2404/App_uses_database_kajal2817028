package com.example.app_uses_database_kajal2817028;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="student.db";
    public DBHelper(Context context){
        super(context,DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(sname TEXT, rollno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
    }
    public void insertdata(String studname, String studroll){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sname", studname);
        cv.put("rollno", studroll);
        db.insert("student",null,cv);
    }
    public Cursor getalldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from student", null);
        return res;
    }

}

