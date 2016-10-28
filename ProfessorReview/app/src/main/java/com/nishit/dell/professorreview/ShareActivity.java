package com.nishit.dell.professorreview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShareActivity extends AppCompatActivity {

    Button btnmodify, btnWhatsApp, btnGmail;
    TextView tvmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        btnmodify = (Button) findViewById(R.id.btnModify);
        btnWhatsApp = (Button) findViewById(R.id.btnWhatsapp);
        btnGmail = (Button) findViewById(R.id.btnEmail);
        tvmsg = (TextView) findViewById(R.id.tvMsg);
        tvmsg.setText(getIntent().getStringExtra("mview"));

        btnmodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent waintent = new Intent(Intent.ACTION_SEND);
                waintent.setType("text/plain");
                waintent.setPackage("com.whatsapp");
                Intent i = getIntent();
                String m=i.getStringExtra("mview");
                waintent.putExtra(Intent.EXTRA_TEXT,m);
                try {
                    startActivity(waintent);
                }
                catch(ActivityNotFoundException ae)
                {
                    Toast.makeText(getApplicationContext(), "Whatsapp not installed", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=getIntent().getStringExtra("email");
                String Sub="Professor Review";
                Intent i=new Intent(Intent.ACTION_SENDTO);
                i.setPackage("com.google.android.gm");
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{e});
                i.putExtra(Intent.EXTRA_SUBJECT,Sub);
                i.putExtra(Intent.EXTRA_TEXT,tvmsg.getText());
                try {
                    startActivity(i);
                }
                catch(ActivityNotFoundException ae)
                {
                    Toast.makeText(getApplicationContext(), "Gmail not installed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
