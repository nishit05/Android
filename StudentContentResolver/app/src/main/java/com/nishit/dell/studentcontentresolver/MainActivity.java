package com.nishit.dell.studentcontentresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Uri CONTENT_URI = Uri.parse("content://StudentProvider/Student");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver cr = getContentResolver();
        ContentValues cv = new ContentValues();
        cv.put("rno", 10);
        cv.put("name", "John");
        cr.insert(CONTENT_URI, cv);

        cv.put("rno", 20);
        cv.put("name", "Kevin");
        cr.insert(CONTENT_URI, cv);

        cv.put("rno", 30);
        cv.put("name", "Dean");
        cr.insert(CONTENT_URI, cv);

        Cursor cu = cr.query(CONTENT_URI, null, null, null, null);
        while (cu.moveToNext())
        {
            String rno=cu.getString(cu.getColumnIndex("rno"));
            String name=cu.getString(cu.getColumnIndex("name"));
            Log.d("SC32",rno+"  "+name);
        }
        cu.close();
    }
}
