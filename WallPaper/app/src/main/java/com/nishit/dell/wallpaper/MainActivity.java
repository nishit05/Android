package com.nishit.dell.wallpaper;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnphoto, btnsetwallppr, btnSave;
    ImageView iv;
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.imageView);
        btnphoto = (Button) findViewById(R.id.btnphoto);
        btnsetwallppr = (Button) findViewById(R.id.btnsetWallppr);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 100);
            }
        });

        btnsetwallppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wm.setBitmap(photo);
                    Toast.makeText(getApplicationContext(), "Wallpaper set Successfully", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st= Environment.getExternalStorageState();
                if(Environment.MEDIA_MOUNTED.equalsIgnoreCase(st))
                {
                    File root=Environment.getExternalStorageDirectory();
                    File d=new File(root + "/WallpaperFolder");
                    if (!d.exists())
                    {
                        d.mkdir();
                    }
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddHHmmSSS");
                    Date dt=new Date();
                    String fname=sdf.format(dt)+".jpg";

                    File f=new File(d,fname);

                    try {
                        FileOutputStream fos=new FileOutputStream(f);
                        BufferedOutputStream bos=new BufferedOutputStream(fos);
                        photo.compress(Bitmap.CompressFormat.JPEG,80,bos);
                        Toast.makeText(getApplicationContext(),"Image Saved in SD card",Toast.LENGTH_LONG).show();
                        bos.flush();
                        bos.close();
                    }  catch (IOException e) {
                        Toast.makeText(getApplicationContext(),"File Save Error due to "+e,Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"SD Card Not Present",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 100)
                photo = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(photo);
            btnsetwallppr.setEnabled(true);
        }
    }
}
