package com.nishit.dell.calculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.preference.DialogPreference;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etnumber;
    Button btnsquare,btnsqrt,btncube;
    TextView tvresult;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnumber= (EditText) findViewById(R.id.etnumber);
        btnsquare= (Button) findViewById(R.id.btnsquare);
        btnsqrt= (Button) findViewById(R.id.btnsqroot);
        btncube= (Button) findViewById(R.id.btncube);
        tvresult= (TextView) findViewById(R.id.tvresult);

        btnsquare.setOnClickListener(this);
        btnsqrt.setOnClickListener(this);
        btncube.setOnClickListener(this);

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

        int orient= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(orient);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to exit");
        builder.setCancelable(false);

       builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               finish();
           }
       });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog al=builder.create();
        al.setTitle("Exit");
        al.show();
    }

    @Override
    public void onClick(View view) {

        if (etnumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Enter a Valid Number", Toast.LENGTH_LONG).show();
        } else {
            switch (view.getId()) {
                case R.id.btnsquare: {
                    double n = Double.parseDouble(etnumber.getText().toString());
                    double r = n * n;
                    //Toast.makeText(MainActivity.this, "Square of " + n + " is " + r, Toast.LENGTH_LONG).show();
                    tvresult.setText("Square of " + n + " is " + r);
                    break;
                }

                case R.id.btnsqroot: {
                    double n = Double.parseDouble(etnumber.getText().toString());
                    double r = Math.sqrt(n);
                    //Toast.makeText(MainActivity.this, "Square Root of " + n + " is " + r, Toast.LENGTH_LONG).show();
                    tvresult.setText("Square Root of " + n + " is " + r);
                    break;
                }

                case R.id.btncube: {
                    double n = Double.parseDouble(etnumber.getText().toString());
                    double r = n * n * n;
                    tvresult.setText("Cube of " + n + " is " + r);
                    //Toast.makeText(MainActivity.this, "Cube of " + n + " is " + r, Toast.LENGTH_LONG).show();
                    break;
                }

            }
            String s=tvresult.getText().toString();
            textToSpeech.speak(s,TextToSpeech.QUEUE_ADD,null);
        }
    }


}
