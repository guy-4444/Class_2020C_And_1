package com.kobi.class_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView main_LBL_title;
    private TextView main_LBL_subTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        /*
        LBL
        EDT
        BTN
        IMG
        LST
        SWC
        LAY
        SPC
         */

        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_LBL_subTitle = findViewById(R.id.main_LBL_subTitle);


        editTitles("Hi Android", "we love android!");
    }

    private void editTitles(String titleText, String subTitleText) {
        //main_LBL_title.setText(titleText);
        //main_LBL_subTitle.setText(subTitleText);
    }

}