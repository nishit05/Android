package com.nishit.dell.professorreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etname, etmobile, etemail, etbatch, etreview;
    Button btnsubmit;
    RadioGroup rbgender;
    Spinner spsubject;
    RatingBar rbrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = (EditText) findViewById(R.id.etname);
        etmobile = (EditText) findViewById(R.id.etmobile);
        etemail = (EditText) findViewById(R.id.etemail);
        etbatch = (EditText) findViewById(R.id.etbatch);
        etreview = (EditText) findViewById(R.id.etreview);
        btnsubmit = (Button) findViewById(R.id.butnsubmit);
        rbgender = (RadioGroup) findViewById(R.id.rbgender);
        spsubject = (Spinner) findViewById(R.id.spsubject);
        rbrate = (RatingBar) findViewById(R.id.rbrate);

        final ArrayList<String> sub = new ArrayList<String>();
        sub.add("Select Sub");
        sub.add("OCPJP");
        sub.add("Android");
        sub.add("Oracle 12c");
        sub.add("PHP");
        sub.add("SPCC");
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, sub);
        spsubject.setAdapter(ad);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = spsubject.getSelectedItemPosition();
                int rbpos = rbgender.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(rbpos);
                if (isBlank()) {
                    String m1 = "Name: " + etname.getText().toString() + "\n" + "Mobile No.: " + etmobile.getText().toString()+"\n";
                    String m2 = "Email-id: " + etemail.getText().toString() + "\n" + "Gender: " + rb.getText().toString()+"\n";
                    String m3 = "Batch Code: " + etbatch.getText().toString() + "\n" + "Subject: " + sub.get(pos)+"\n";
                    String s=etreview.getText().toString();
                    if(s.isEmpty())
                    {
                        s="No review";
                    }
                    String m4 = "Review: " + s + "\n" + "Rating: " + rbrate.getRating() + " stars";
                    String msg=m1+m2+m3+m4;
                    //Toast.makeText(MainActivity.this, "Professor Review" + "\n" + m1 + m2 + m3 + m4, Toast.LENGTH_LONG).show();
                    Intent i=new Intent(MainActivity.this,ShareActivity.class);
                    i.putExtra("mview",msg);
                    i.putExtra("email",etemail.getText().toString());
                    startActivity(i);
                }
            }
        });

    }

    public boolean isBlank() {
        int ct = 0, c = 0;
        char name[] = etname.getText().toString().toCharArray();
        for (char r : name)
            if (Character.isDigit(r) || !Character.isLetter(r))
                ct++;
        char mno[] = etmobile.getText().toString().toCharArray();
        for (char g : mno)
            if (!Character.isDigit(g))
                c++;
        if (etname.getText().toString().equals("") || ct != 0) {
            Toast.makeText(MainActivity.this, "Enter a valid name", Toast.LENGTH_LONG).show();
            return false;
        } else if (etmobile.getText().toString().equals("") || etmobile.getText().toString().length() != 10 || c != 0) {
            Toast.makeText(MainActivity.this, "Enter a valid mobile no. of 10 digits", Toast.LENGTH_LONG).show();
            return false;
        } else if (etemail.getText().toString().equals("") || !etemail.getText().toString().contains("@") || !etemail.getText().toString().contains(".")) {
            Toast.makeText(MainActivity.this, "Enter a valid email id", Toast.LENGTH_LONG).show();
            return false;
        } else if (etbatch.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Enter a valid batch code", Toast.LENGTH_LONG).show();
            return false;
        } else if (spsubject.getSelectedItemPosition() == 0) {
            Toast.makeText(MainActivity.this, "Enter a valid Subject", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }

    }
}
