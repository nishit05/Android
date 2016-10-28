package com.nishit.dell.namegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnSave;
    SharedPreferences sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= (EditText) findViewById(R.id.etName);
        btnSave= (Button) findViewById(R.id.btnSave);

        sp1=getSharedPreferences("F1",MODE_PRIVATE);

        if(sp1.getBoolean("ne",false)==false) {
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name=etName.getText().toString();
                    if(name.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(),"Enter a Name",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        SharedPreferences.Editor editor=sp1.edit();
                        editor.putString("name","Hello "+name+"\n"+"Welcome to Storage Practical");
                        editor.putBoolean("ne",true);
                        editor.commit();
                        Intent i=new Intent(MainActivity.this,NameActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            });
        }
        else
        {
            Intent i=new Intent(MainActivity.this,NameActivity.class);
            startActivity(i);
            finish();
        }
    }
}
