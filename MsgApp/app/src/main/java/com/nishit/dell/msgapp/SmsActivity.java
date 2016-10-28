package com.nishit.dell.msgapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {

    TextView tvMsg;
    EditText etPhone;
    Button btnSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        tvMsg = (TextView) findViewById(R.id.tvMsg);
        etPhone = (EditText) findViewById(R.id.etPhone);
        btnSendSms = (Button) findViewById(R.id.btnSendSms);

        Intent i = getIntent();
        final String msg = i.getStringExtra("m");
        tvMsg.setText(msg);

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = etPhone.getText().toString();
                if (n.isEmpty()) {
                    etPhone.setError("Enter a Phone No.");
                    etPhone.requestFocus();
                    return;
                }

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:" + n));
                i.putExtra("sms_body", msg);
                startActivity(i);
            }
        });
    }
}
