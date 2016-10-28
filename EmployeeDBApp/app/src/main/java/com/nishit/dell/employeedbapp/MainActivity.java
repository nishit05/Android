package com.nishit.dell.employeedbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvdata;
    Button btnadd, btnupdate, btndelete;
    EditText etid, etname;
    DataBaseHandler dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdata = (TextView) findViewById(R.id.tvdata);
        btnadd = (Button) findViewById(R.id.btnadd);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        etid = (EditText) findViewById(R.id.etid);
        etname = (EditText) findViewById(R.id.etname);
        dbh=new DataBaseHandler(this);
        String employee=dbh.GetEmployees();
        tvdata.setText(employee);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int eid=Integer.parseInt(etid.getText().toString());
                String ename=etname.getText().toString();
                dbh.AddEmployee(eid,ename);
                String employee=dbh.GetEmployees();
                tvdata.setText(employee);
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int eid=Integer.parseInt(etid.getText().toString());
                String ename=etname.getText().toString();
                dbh.UpdateEmployee(eid,ename);
                String employee=dbh.GetEmployees();
                tvdata.setText(employee);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int eid=Integer.parseInt(etid.getText().toString());
                String ename=etname.getText().toString();
                dbh.DeleteEmployee(eid);
                String employee=dbh.GetEmployees();
                tvdata.setText(employee);
            }
        });
    }
}
