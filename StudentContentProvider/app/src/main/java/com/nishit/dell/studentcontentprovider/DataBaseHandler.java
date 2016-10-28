package com.nishit.dell.studentcontentprovider;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase db;

    public DataBaseHandler(Context context) {
        super(context, "Studentdb", null, 1);
        this.context = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Student(rno INTEGER PRIMARY KEY,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addStudent(ContentValues values) {
        return db.insert("Student", null, values);
    }

    public int deleteStudent(String selection) {
        return db.delete("Student", selection, null);
    }

    public int updateStudent(ContentValues v, String sel) {
        return db.update("Student", v, sel, null);
    }
}
