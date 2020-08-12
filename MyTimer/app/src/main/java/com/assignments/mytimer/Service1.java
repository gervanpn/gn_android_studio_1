package com.assignments.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class Service1 extends AppCompatActivity implements View.OnClickListener {
    private Button start, stop, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service1);

        start = (Button) findViewById(R.id.buttonStart);
        stop = (Button) findViewById(R.id.buttonStop);
        home = (Button) findViewById(R.id.buttonHome);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        home.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==start) {
            startService(new Intent(this, ServiceTutorial.class));
        } else if (view==stop) {
            stopService(new Intent(this, ServiceTutorial.class));
        } else if (view==home) {
            Intent i = new Intent(this, com.assignments.mytimer.MainActivity.class);
            startActivity(i);
        }
    }
}