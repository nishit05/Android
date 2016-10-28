package com.nishit.dell.selecttravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etsource,etdest;
    Spinner spclass;
    Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etsource= (EditText) findViewById(R.id.etsource);
        etdest= (EditText) findViewById(R.id.etdest);
        spclass= (Spinner) findViewById(R.id.spclass);
        btnsubmit= (Button) findViewById(R.id.btnsubmit);

        final ArrayList<String>alclass=new ArrayList();
        alclass.add("First Class");
        alclass.add("Second Class");
        alclass.add("Sleeper Class");
        alclass.add("AC Chair Car");

        ArrayAdapter<String>adclass=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,alclass);
        spclass.setAdapter(adclass);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m1=etsource.getText().toString();
                String m2=etdest.getText().toString();

                int s1=spclass.getSelectedItemPosition(); //Position of selected item
                String m3=alclass.get(s1);

                String m=m1+" to "+m2+" : "+m3;
                Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();

            }
        });


    }
}
