package com.example.loginsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database_Helper extends SQLiteOpenHelper {

    private static final String databaseName = "signup.db";

    public Database_Helper(@Nullable Context context) {

        super(context, "signup.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table allusers(email TEXT primary key,name TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {

        MyDatabase.execSQL("drop Table if exists allusers");

    }

    public boolean insertData(String email,String name,String password)
    {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("Name",name);
        contentValues.put("password",password);



        long result = MyDatabase.insert("allusers" , null , contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("select * from allusers where email = ?",new String[]{email});

        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("select * from allusers where email = ? and password = ?",new String[]{email,password});

        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }

    }


}
