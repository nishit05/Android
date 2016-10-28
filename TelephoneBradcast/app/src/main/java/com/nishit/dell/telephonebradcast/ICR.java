package com.nishit.dell.telephonebradcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class ICR extends BroadcastReceiver {
    String msg = "";

    public ICR() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (TelephonyManager.EXTRA_STATE_RINGING.equalsIgnoreCase(state)) {
                String inc = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                msg += inc + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainActivity.tvLog.setText(MainActivity.tvLog.getText() + msg);
    }
}
