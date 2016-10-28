package com.nishit.dell.waterreminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStartAlarm, btnStopAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartAlarm = (Button) findViewById(R.id.btnStartAlarm);
        btnStopAlarm = (Button) findViewById(R.id.btnStopAlarm);

        Intent i = new Intent(MainActivity.this, BR1.class);
        final PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 1234, i, 0);
        final AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        btnStartAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Alarm about to start",Toast.LENGTH_LONG).show();
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 10000, pi);
            }
        });

        btnStopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Alarm stopped",Toast.LENGTH_LONG).show();
                am.cancel(pi);
            }
        });

    }
}
