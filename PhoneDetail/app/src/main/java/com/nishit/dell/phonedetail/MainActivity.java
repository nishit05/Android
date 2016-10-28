package com.nishit.dell.phonedetail;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnlang, btnmomk, btnandver, btnimei, btnnetcar, btndispres, btnintcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlang = (Button) findViewById(R.id.btnlang);
        btnmomk = (Button) findViewById(R.id.btnmomk);
        btnandver = (Button) findViewById(R.id.btnandver);
        btnimei = (Button) findViewById(R.id.btnimei);
        btnnetcar = (Button) findViewById(R.id.btnnetcar);
        btndispres = (Button) findViewById(R.id.btndispreso);
        btnintcon = (Button) findViewById(R.id.btnintcon);

        btnlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lang = Locale.getDefault().getDisplayLanguage();
                Toast.makeText(getApplicationContext(), "Language: " + lang, Toast.LENGTH_LONG).show();
            }
        });

        btnmomk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String model = Build.MODEL;
                String make = Build.MANUFACTURER;
                Toast.makeText(getApplicationContext(), "Model:" + model + "\n" + "Manufacturer: " + make, Toast.LENGTH_LONG).show();
            }
        });

        btnandver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ver = Build.VERSION.RELEASE;
                int sdk = Build.VERSION.SDK_INT;
                String nam = AndroidName(sdk);
                Toast.makeText(getApplicationContext(), "Release:" + ver + "\n" + "SDK ver: " + sdk + "\n" + "Code Name: " + nam, Toast.LENGTH_LONG).show();
            }
        });

        btnimei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelephonyManager tm = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
                String imei = tm.getDeviceId();
                String y = imei.substring(imei.length() - 3, imei.length());
                imei = imei.substring(0, 3).concat("...").concat(y);
                Toast.makeText(getApplicationContext(), "IMEI:" + imei, Toast.LENGTH_LONG).show();
            }
        });

        btnnetcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TelephonyManager tm = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
                int type = tm.getPhoneType();
                String ptype = "";
                switch (type) {
                    case (TelephonyManager.PHONE_TYPE_CDMA): {
                        ptype = "CDMA";
                        break;
                    }
                    case (TelephonyManager.PHONE_TYPE_GSM): {
                        ptype = "GSM";
                        break;
                    }
                    case (TelephonyManager.PHONE_TYPE_NONE): {
                        ptype = "NONE";
                        break;
                    }
                }

                String car = tm.getNetworkOperatorName();
                if (car.equals("")) {
                    Toast.makeText(getApplicationContext(), "Network Type :" + ptype + "\n" + "Network Carrier: No Network", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Network Type :" + ptype + "\n" + "Network Carrier : " + car, Toast.LENGTH_LONG).show();
                }

            }
        });

        btndispres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Display d = getWindowManager().getDefaultDisplay();
                int w = d.getWidth();
                int h = d.getHeight();

                Toast.makeText(getApplicationContext(), "Resolution: " + w + " x " + h, Toast.LENGTH_LONG).show();
            }
        });

        btnintcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                    Toast.makeText(getApplicationContext(), "Connected to Internet", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Not Connected to Internet", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public String AndroidName(int sdk) {

        if (sdk >= 9 && sdk < 11)
            return "Ginger Bread";
        else if (sdk >= 11 && sdk < 14)
            return "Honeycomb";
        else if (sdk >= 14 && sdk < 16)
            return "Ice Cream Sandwich";
        else if (sdk >= 16 && sdk < 19)
            return "Jelly Bean";
        else if (sdk >= 19 && sdk < 21)
            return "Kitkat";
        else if (sdk >= 21 && sdk < 23)
            return "Lolipop";
        else if (sdk == 23)
            return "Marshmallow";
        else
            return "Invalid SDK";

    }
}
