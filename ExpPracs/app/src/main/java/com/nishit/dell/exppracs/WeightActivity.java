package com.nishit.dell.exppracs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeightActivity extends AppCompatActivity {

    EditText etWeight;
    Button btnSubmit;
    TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        etWeight = (EditText) findViewById(R.id.etWeight);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        Intent i = getIntent();
        final String un = i.getStringExtra("u");

        txtMsg.setText("Welcome " + un);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wt = etWeight.getText().toString();
                if (wt.equals("")) {
                    etWeight.setError("Enter a valid weight");
                } else {
                    Intent i = new Intent(WeightActivity.this, ConfirmActivity.class);
                    i.putExtra("u", un);
                    i.putExtra("w", wt);
                    startActivity(i);
                }
            }
        });

    }
}
