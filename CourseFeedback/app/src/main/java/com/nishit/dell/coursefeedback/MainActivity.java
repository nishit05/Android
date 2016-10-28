package com.nishit.dell.coursefeedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgfood;
    RatingBar rabfood;
    Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgfood= (RadioGroup) findViewById(R.id.rgFood);
        rabfood= (RatingBar) findViewById(R.id.rabfood);
        btnsubmit= (Button) findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s1=rgfood.getCheckedRadioButtonId();
                RadioButton r1= (RadioButton) findViewById(s1);
                String m1=r1.getText().toString();

                String m2=String.valueOf(rabfood.getRating());

                Toast.makeText(getApplicationContext(),"Food Selected: "+m1+"\n"+"Rating: "+m2,Toast.LENGTH_LONG).show();
            }
        });

    }
}
