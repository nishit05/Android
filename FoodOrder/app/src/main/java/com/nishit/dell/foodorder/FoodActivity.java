package com.nishit.dell.foodorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FoodActivity extends AppCompatActivity {

    RadioGroup rgFood;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        rgFood = (RadioGroup) findViewById(R.id.rgFood);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                int s1 = rgFood.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(s1);

                String m=rb.getText().toString();

                i.putExtra("food",m);
                setResult(RESULT_OK,i);
                finish();

            }
        });

    }
}
