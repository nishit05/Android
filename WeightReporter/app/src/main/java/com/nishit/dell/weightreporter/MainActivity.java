package com.nishit.dell.weightreporter;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etWeight;
    Button btnWeight;
    FloatingActionButton fabCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWeight = (EditText) findViewById(R.id.etWeight);
        btnWeight = (Button) findViewById(R.id.btnWeight);
        fabCall= (FloatingActionButton) findViewById(R.id.fabCall);

        btnWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String w = etWeight.getText().toString();
                if (w.isEmpty()) {
                    Snackbar.make(view, "Enter a valid weight", Snackbar.LENGTH_LONG).show();
                }
                else if(w.length()<=0)
                {
                    Snackbar.make(view, "Weight cannot be 0 or negative", Snackbar.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_TEXT, "The Entered Weight is " + w);
                    startActivity(i);
                }
            }
        });

        fabCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.About:
            {
                Snackbar.make(findViewById(android.R.id.content),"Developed by Kilonewton Apps",Snackbar.LENGTH_LONG).show();
                break;
            }

            case R.id.Website:
            {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http:"+"www.google.com"));
                startActivity(i);
                break;
            }
        }
        return true;
    }
}
