package com.example.wuyou.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wuyou on 2018/10/31.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "imooc_daily", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table if not exists imooc_cost(" +
        "id integer primary key, " +
        "cost_title varchar," +
        "cost_date varchar," +
        "cost_money varchar)");

    }

    public void insertCost(CostBean costBean){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cost_title",costBean.costTitle);
        contentValues.put("cost_date",costBean.costDate);
        contentValues.put("cost_money",costBean.costMoney);
        sqLiteDatabase.insert("imooc_cost",null,contentValues);

    }

    public Cursor query(){

        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        return sqLiteDatabase.query("imooc_cost",null,null,null,null,null,"cost_date " + "ASC");

    }

    public void delete(){

        SQLiteDatabase sqLiteDatabase  = getWritableDatabase();
        sqLiteDatabase.delete("imooc_cost",null,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
