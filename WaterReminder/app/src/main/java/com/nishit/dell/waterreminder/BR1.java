package com.nishit.dell.waterreminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class BR1 extends BroadcastReceiver {
    MediaPlayer mp;

    public BR1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();

        Toast.makeText(context, "Please Drink Water", Toast.LENGTH_LONG).show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    if (mp.isPlaying()) {
                        mp.stop();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        Intent i = new Intent(context, BR1.class);
        final PendingIntent pi = PendingIntent.getBroadcast(context, 1234, i, 0);
        final AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 10000, pi);


    }
}
