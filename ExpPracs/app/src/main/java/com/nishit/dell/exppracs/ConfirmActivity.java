package com.nishit.dell.exppracs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    TextView txtMsg;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        Intent i=getIntent();
        String m1=i.getStringExtra("u");
        String m2=i.getStringExtra("w");
        String m="Username: "+m1+"\n"+"Weight: "+m2;

        txtMsg.setText(m);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ConfirmActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
