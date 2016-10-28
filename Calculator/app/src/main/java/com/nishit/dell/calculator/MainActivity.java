package com.nishit.dell.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etinput,etpower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etinput= (EditText) findViewById(R.id.etinputt);
    }

    public boolean isBlank()
    {
        return true;
    }

     
    public void Square(View v){
        if(isBlank())
        {
            Toast.makeText(MainActivity.this,"Enter a valid number",Toast.LENGTH_LONG).show();
        }
        else {
            double n = Double.parseDouble(etinput.getText().toString());
            double r = n * n;
            Toast.makeText(MainActivity.this, "Square of " + n + " is " + r, Toast.LENGTH_LONG).show();
        }
    }

    public void Sqrt(View v){
        if(isBlank())
        {
            Toast.makeText(MainActivity.this,"Enter a valid number",Toast.LENGTH_LONG).show();
        }
        else {
            double n = Double.parseDouble(etinput.getText().toString());
            double r = Math.sqrt(n);
            Toast.makeText(MainActivity.this, "Square Root of " + n + " is " + r, Toast.LENGTH_LONG).show();
        }
    }

    public void Cube(View v){
        if(isBlank())
        {
            Toast.makeText(MainActivity.this,"Enter a valid number",Toast.LENGTH_LONG).show();
        }
        else {
            double n = Double.parseDouble(etinput.getText().toString());
            double r = n * n * n;
            Toast.makeText(MainActivity.this, "Cube of " + n + " is " + r, Toast.LENGTH_LONG).show();
        }
    }


}
