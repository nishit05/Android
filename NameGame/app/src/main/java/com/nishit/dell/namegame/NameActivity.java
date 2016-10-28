package com.nishit.dell.namegame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    TextView tvName;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        tvName= (TextView) findViewById(R.id.tvName);
        sp=getSharedPreferences("F1",MODE_PRIVATE);
        String welmsg=sp.getString("name","No Name");
        tvName.setText(welmsg);
    }
}
