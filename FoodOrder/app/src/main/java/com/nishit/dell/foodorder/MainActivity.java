package com.nishit.dell.foodorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSelectFood;
    TextView txtFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectFood = (Button) findViewById(R.id.btnSelectFood);
        txtFood = (TextView) findViewById(R.id.txtFood);

        btnSelectFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(i, 1234);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1234 && data != null) {
            String food = data.getStringExtra("food");
            txtFood.setText("Selected Food: " + food);
        }
    }
}
