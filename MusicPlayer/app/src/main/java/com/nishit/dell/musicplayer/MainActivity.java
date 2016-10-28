package com.nishit.dell.musicplayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ListView lvmusic;
    Button btnpause, btnstop;
    MediaPlayer mp;
    String mlist[], mpath[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvmusic = (ListView) findViewById(R.id.lvmusic);
        btnpause = (Button) findViewById(R.id.btnpause);
        btnstop = (Button) findViewById(R.id.btnstop);

        ContentResolver c = getContentResolver();
        Cursor c1 = c.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        int count = c1.getCount();
        mlist = new String[count];
        mpath = new String[count];
        int i = 0;
        while (c1.moveToNext()) {
            mlist[i] = c1.getString(c1.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
            mpath[i] = c1.getString(c1.getColumnIndex(MediaStore.Audio.Media.DATA));
            i++;
        }
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, mlist);
        lvmusic.setAdapter(ad);
        mp=new MediaPlayer();
        lvmusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String p = mpath[i];

                try {
                    mp.reset();
                    mp.setDataSource(p);
                    mp.prepare();
                    mp.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.pause();
                    btnpause.setText("Resume");
                } else {
                    mp.start();
                    btnpause.setText("Pause");
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });
    }
}
