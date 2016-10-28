package com.nishit.dell.ledflash;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tbSwitch;
    boolean hasFlash, isFlashOn;
    Camera camera;
    Camera.Parameters par;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbSwitch = (ToggleButton) findViewById(R.id.tbSwitch);
        PackageManager pm = getApplicationContext().getPackageManager();
        hasFlash = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!hasFlash) {
            Toast.makeText(getApplicationContext(), "No Flash Present", Toast.LENGTH_LONG).show();
            return;
        }

        tbSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFlashOn)
                    turnOffFlash();
                else
                    turnOnFlash();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(camera==null)
        {
            try {
                camera = Camera.open();
            }
            catch (RuntimeException re)
            {
                Toast.makeText(getApplicationContext(),"Error in Opening Camera",Toast.LENGTH_LONG).show();
            }
        }
    }

    void turnOnFlash() {
        par=camera.getParameters();
        if(!isFlashOn)
        {
            par=camera.getParameters();
            par.setFlashMode(par.FLASH_MODE_TORCH);
            camera.setParameters(par);
            camera.startPreview();
            isFlashOn=true;
        }
    }

    void turnOffFlash() {
        par=camera.getParameters();
        if(isFlashOn) {
            par.setFlashMode(par.FLASH_MODE_OFF);
            camera.setParameters(par);
            camera.stopPreview();
            isFlashOn = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        turnOnFlash();
    }

    @Override
    protected void onPause() {
        super.onPause();
        turnOffFlash();
    }

    @Override
    protected void onStop() {
        super.onStop();
        camera.release();
        camera=null;
    }
}
