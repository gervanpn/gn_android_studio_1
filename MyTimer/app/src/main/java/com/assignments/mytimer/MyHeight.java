package com.assignments.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyHeight extends AppCompatActivity {
    public static final double inches = 2.54;
    public TextView incm;
    public EditText feet, inch;
    public Button tohome, calculate;
    public double tf;
    public double ti;
    public double intoCM;
    public Activity v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myheight);

        incm = findViewById(R.id.incm);
        feet = findViewById(R.id.feet);
        inch = findViewById(R.id.inch);
        tohome = findViewById(R.id.toHome);
        calculate = findViewById(R.id.calculate);

        v = this;

        tohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.MainActivity.class);
                startActivity(i);
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            tf = Double.valueOf(String.valueOf(feet.getText()));
            ti = Double.valueOf(String.valueOf(inch.getText()));
            howTall();
            }
        });


    }

    public void howTall() {
        double inCm = (((tf * 12)*inches)+(ti*inches));
//        System.out.println(tf + " feet, " + ti + " inches is = " + inCm + " CM tall.");

    }
}