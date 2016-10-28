package com.nishit.dell.employeedbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHandler extends SQLiteOpenHelper{
    Context context;
    SQLiteDatabase db;

    public DataBaseHandler(Context context)
    {
        super(context,"employeedb",null,1);
        Log.d("ec123","dbn created/opened");
        this.context=context;
        db=getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table employee(eid integer primary key,ename text)");
        Log.d("ec123","Table created successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void AddEmployee(int id,String name)
    {
        ContentValues cv=new ContentValues();
        cv.put("eid",id);
        cv.put("ename",name);
        db.insert("employee",null,cv);
    }

    public String GetEmployees()
    {
        Cursor c=db.query("employee",null,null,null,null,null,null,null);
        StringBuffer sb=new StringBuffer();
        while (c.moveToNext())
        {
            String eid=c.getString(0);
            String ename=c.getString(1);
            sb.append(eid+" "+ename+"\n");
        }
        return sb.toString();
    }

    public void UpdateEmployee(int id,String name)
    {
        ContentValues cv=new ContentValues();
        cv.put("eid",id);
        cv.put("ename",name);
        db.update("employee",cv,"eid="+id,null);
    }

    public void DeleteEmployee(int id)
    {
        db.delete("employee","eid="+id,null);
    }
}
