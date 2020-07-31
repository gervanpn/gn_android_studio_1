package com.assignments.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Timer extends AppCompatActivity {
    public static final long defaultTime = 60000; // 1 minute in ms
    private TextView countdownText;
    private EditText myTimeInput;
    private Button countdownButton, countdownReset, home_button;
    private CountDownTimer countDownTimer;
    private long timeLeft = defaultTime;  //1 min default entered
    private boolean running;
    private long startTime;
    private long minutesInMS;
    private Activity v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        v = this;

        countdownText = findViewById(R.id.counter_text);
        countdownButton = findViewById(R.id.start_button);
        countdownReset = findViewById(R.id.reset_button);
        myTimeInput = findViewById(R.id.my_time_input);
        home_button = findViewById(R.id.home_button);


        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startTime = new Long(String.valueOf(myTimeInput.getText()));
                
//                checkTime();
                if (running) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        updateTimer();

        countdownReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTime();
            }
        });
        updateTimer();

        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(v, com.assignments.mytimer.MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void checkTime() {
        if (startTime >= 2) {
            minutesInMS = (startTime * defaultTime);
            timeLeft = minutesInMS;
        } else {
            timeLeft = defaultTime;
        }
    }

//    public void startStop() {
//        if (running) {
//            stopTimer();
//        } else {
//            startTimer();
//        }
//    }

    public void startTimer() {
    countDownTimer = new CountDownTimer(timeLeft, 1000) {
        @Override
        public void onTick(long l) {
            timeLeft = l;
            updateTimer();
        }

        @Override
        public void onFinish() {
            running = false;
            countdownButton.setText("START");
            countdownButton.setVisibility(View.INVISIBLE);
            countdownReset.setVisibility(View.VISIBLE);
        }
    }.start();
    running = true;
    countdownButton.setText("PAUSE");
    countdownReset.setVisibility(View.INVISIBLE);
    }

    public void pauseTimer() {
        countDownTimer.cancel();
        running = false;
        countdownButton.setText("START");
        countdownReset.setVisibility(View.VISIBLE);
    }

    public void stopTimer() {
        countDownTimer.cancel();
        countdownButton.setText("START");
        running = false;
        countdownReset.setVisibility(View.VISIBLE);
    }

    public void resetTime() {
        startTime = new Long(String.valueOf(myTimeInput.getText()));
        checkTime();
        updateTimer();
        countdownReset.setVisibility(View.INVISIBLE);
        countdownButton.setVisibility(View.VISIBLE);
    }

    public void updateTimer() {
        int min = (int) timeLeft / 60000;
        int sec = (int) timeLeft % 60000 / 1000;

        String timeLeftText;
            timeLeftText = "" + min;
            timeLeftText += ":";
            if (sec < 10) timeLeftText += "0";
            timeLeftText += sec;

        countdownText.setText(timeLeftText);

//        Option 2
//        int mins = (int) (timeLeft / 1000) / 60;
//        int secs = (int) (timeLeft / 1000) % 60;
//        String timeLeftFormat = String.format("%02d:%02d", mins, secs);
//
//        countdownText.setText(timeLeftFormat);

    }

}