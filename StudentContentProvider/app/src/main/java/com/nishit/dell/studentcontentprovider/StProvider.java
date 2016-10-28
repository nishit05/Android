package com.nishit.dell.studentcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class StProvider extends ContentProvider {
    DataBaseHandler dbh;

    public StProvider() {
    }

    @Override
    public boolean onCreate() {
        dbh=new DataBaseHandler(getContext());
        return true;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        dbh.addStudent(values);
        return uri;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        return dbh.updateStudent(values,selection);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        return dbh.deleteStudent(selection);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        SQLiteQueryBuilder sqlb=new SQLiteQueryBuilder();
        sqlb.setTables("Student");
        SQLiteDatabase db=dbh.getWritableDatabase();
        Cursor c=sqlb.query(db,null,null,null,null,null,null);
        return  c;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
