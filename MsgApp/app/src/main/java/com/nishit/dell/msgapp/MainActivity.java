package com.nishit.dell.msgapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMsg;
    Button btnSend, btnWhatsapp, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMsg = (EditText) findViewById(R.id.etMsg);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnWhatsapp = (Button) findViewById(R.id.btnWhatsapp);
        btnSms = (Button) findViewById(R.id.btnSms);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = etMsg.getText().toString();
                if (msg.isEmpty()) {
                    etMsg.setError("Empty Message");
                    etMsg.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(i);
            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = etMsg.getText().toString();
                if (msg.isEmpty()) {
                    etMsg.setError("Empty Message");
                    etMsg.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.setPackage("com.whatsapp");
                i.putExtra(Intent.EXTRA_TEXT, msg);
                try {
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Whatsapp not Installed", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = etMsg.getText().toString();
                if (msg.isEmpty()) {
                    etMsg.setError("Empty Message");
                    etMsg.requestFocus();
                    return;
                }
                Intent i = new Intent(getApplicationContext(), SmsActivity.class);
                i.putExtra("m", msg);
                startActivity(i);
            }
        });
    }
}
