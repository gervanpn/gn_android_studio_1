package com.myheight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    double tf;
    double ti;
    double incm;
    double inches;
    inches = 2.54

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tf = getText(R.id.feet);
        ti = getText(R.id.inch);

    public static void howTall(double tf, double ti, double inches) {
        double inCm = (((tf * 12)*inches)+(ti*inches));
//        System.out.println(tf + " feet, " + ti + " inches is = " + inCm + " CM tall.");
            incm = inCm;
    }

    }
}