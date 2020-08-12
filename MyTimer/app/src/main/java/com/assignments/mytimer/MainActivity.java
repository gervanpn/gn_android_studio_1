package com.assignments.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button_big, button_tbd, button_height, button_ttt, button_calc, button_timer, button_stopwatch, button_service1;
    private Activity v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_ttt = findViewById(R.id.button_ttt);
        button_tbd = findViewById(R.id.button_tbd);
        button_calc = findViewById(R.id.button_calc);
        button_timer = findViewById(R.id.button_timer);
        button_stopwatch = findViewById(R.id.button_stopwatch);
        button_height = findViewById(R.id.button_height);
        button_big = findViewById(R.id.button_big);
        button_service1 = findViewById(R.id.button_service1);

        v = this;

        button_ttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.MainActivity.class);
                startActivity(i);
            }
        });

        button_tbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.MainActivity.class);
                startActivity(i);
            }
        });

        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.MainActivity.class);
                startActivity(i);
            }
        });

        button_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.Timer.class);
                startActivity(i);
            }
        });

        button_stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.StopWatch.class);
                startActivity(i);
            }
        });

        button_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.MyHeight.class);
                startActivity(i);
            }
        });

        button_service1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.Service1.class);
                startActivity(i);
            }
        });

        button_big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.MainActivity.class);
                startActivity(i);
            }
        });
    }
}