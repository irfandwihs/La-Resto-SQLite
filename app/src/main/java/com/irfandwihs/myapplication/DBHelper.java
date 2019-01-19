package com.irfandwihs.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "resep.db";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table resep(no integer primary key, judul text null, kategori text null, bahan text null, intruksi text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO resep (no, judul, kategori, bahan, intruksi) VALUES ('1', 'Glazed Chicken Wings', 'Hot Appetizer', '2-1/2 pounds chicken wings','Cut chicken wings into three sections');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}