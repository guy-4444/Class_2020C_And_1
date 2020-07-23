package com.kobi.class_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double P = 3.14;
        double E = 2.71;
        // TODO: 23/07/2020 add goldRatio number
        double r = getRadius(200.0);

    }

    private double getRadius(double d) {
        // TODO: 23/07/2020 create function
        return 0;
    }
}