package com.nishit.dell.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etname,etuser,etpass,etcpass;
    Button btnsubmit,btncncl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = (EditText) findViewById(R.id.etname);
        etuser = (EditText) findViewById(R.id.etuser);
        etpass = (EditText) findViewById(R.id.etpass);
        etcpass = (EditText) findViewById(R.id.etcpass);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        btncncl = (Button) findViewById(R.id.btncncl);

        btnsubmit.setOnClickListener(this);


        btncncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etname.setText("");
                etuser.setText("");
                etpass.setText("");
                etcpass.setText("");
            }
        });
    }

    public boolean Validate()
    {
        int c=0,c1=0;
        String name,user,pass,cpass;
        char []cn,cu;
        name = new String(etname.getText().toString());
        user = new String(etuser.getText().toString());
        pass = new String(etpass.getText().toString());
        cpass = new String(etcpass.getText().toString());
        cn = new char[name.length()];
        cu = new char[user.length()];
        cn = name.toCharArray();
        cu = user.toCharArray();

        for (char p : cn) {
            if (Character.isDigit(p)) {
                c++;
            }
        }

        for (char j : cu) {
            if (!Character.isDigit(j) && !Character.isLetter(j) && j != '.') {
                c1++;

            }
        }

        if (name.equals("") || user.equals("") || pass.equals("") || cpass.equals("")) {
            Toast.makeText(MainActivity.this, "All Fields Should be Filled", Toast.LENGTH_LONG).show();
            return false;
        }

        else if (c != 0) {
            Toast.makeText(MainActivity.this, "Name should contain only LETTERS", Toast.LENGTH_LONG).show();
            return false;
        }

        else if (c1 != 0) {
            Toast.makeText(MainActivity.this, "Username Can contain ONLY LETTERS, NUMBERS OR PERIODS", Toast.LENGTH_LONG).show();
            return false;
        }

        else if (pass.length() < 6 || pass.length() > 10) {
            Toast.makeText(MainActivity.this, "Password should be of 6-10 characters", Toast.LENGTH_LONG).show();
            return false;
        }

        else if (!pass.equals(cpass)) {
            Toast.makeText(MainActivity.this, "PASSWORD MISMATCH", Toast.LENGTH_LONG).show();
            return false;
        }

        else
        {
            return true;
        }

    }


    @Override
    public void onClick(View view) {
        if(Validate()) {
            String s="SUCCESSFUL REGISTRATION WELCOME "+etname.getText().toString();
            Toast.makeText(MainActivity.this,s, Toast.LENGTH_LONG).show();
            etname.setText("");
            etuser.setText("");
            etpass.setText("");
            etcpass.setText("");
        }
    }


}

