package com.kobi.class_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Random;

public class Activity_Panel extends AppCompatActivity {

    private ImageView panel_IMG_background;
    private EditText panel_EDT_name;
    private Button panel_BTN_continue;
    private TextView panel_LBL_result;
    private Button panel_BTN_a;
    private Button panel_BTN_b;
    private Button panel_BTN_c;

    private int counter = 1;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("MY_INTEGER", counter);
        Log.d("pttt", "onSaveInstanceState: " + counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            int oldCounter = savedInstanceState.getInt("MY_INTEGER");
            counter = oldCounter;
            Log.d("pttt", "onRestoreInstanceState : " + oldCounter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
        Log.d("pttt", "onCreate");

        findViews();
        panel_BTN_a.setOnClickListener(bottomClickListener);
        panel_BTN_b.setOnClickListener(bottomClickListener);
        panel_BTN_c.setOnClickListener(bottomClickListener);

//        Glide
//                .with(this)
//                .load(R.drawable.img_panda)
//                .centerCrop()
//                .into(panel_IMG_background);

        Glide
                .with(this)
                .load("https://crosstalk.cell.com/hs-fs/hubfs/Images/Jennifer%20Levine/New%20Insights%20into%20pandas%2C/6990634-panda-hug.jpg?width=2560&height=1600&name=6990634-panda-hug.jpg")
                .placeholder(R.drawable.img_loading)
                .error(R.drawable.img_not_found)
                .centerCrop()
                .into(panel_IMG_background);



        ///// -------------------- /////
        panel_BTN_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                continueClicked();
            }
        });

        panel_EDT_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //panel_LBL_result.setTextColor(Color.GREEN);
                //panel_LBL_result.setTextColor(Color.parseColor("#FF0000"));

                panel_LBL_result.setText(editable.toString());

                if (editable.length() > 5) {
                    if (android.os.Build.VERSION.SDK_INT >= 23) {
                        panel_LBL_result.setTextColor(ContextCompat.getColor(Activity_Panel.this, R.color.validate));
                    } else {
                        panel_LBL_result.setTextColor(getResources().getColor(R.color.validate));
                    }
                } else {
                    panel_LBL_result.setTextColor(ContextCompat.getColor(Activity_Panel.this, R.color.invalidate));
                }
            }
        });

    }
    
    private void continueClicked() {
        String input = panel_EDT_name.getText().toString();
        panel_LBL_result.setText(input);
    }

    private View.OnClickListener bottomClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            counter++;
            panel_LBL_result.setText("" + counter);
            bottomClicked(view);
        }
    };

    private void bottomClicked(View view) {
        if (  ((String) view.getTag()).equals("a") ) {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
        ((Button) view).setText("Hi");
        Log.d("pttt", "My Bottom Button Clicked");
    }

    private void findViews() {
        panel_IMG_background = findViewById(R.id.panel_IMG_background);
        panel_EDT_name = findViewById(R.id.panel_EDT_name);
        panel_BTN_continue = findViewById(R.id.panel_BTN_continue);
        panel_LBL_result = findViewById(R.id.panel_LBL_result);
        panel_BTN_a = findViewById(R.id.panel_BTN_a);
        panel_BTN_b = findViewById(R.id.panel_BTN_b);
        panel_BTN_c = findViewById(R.id.panel_BTN_c);
    }


    @Override
    protected void onStart() {
        Log.d("pttt", "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("pttt", "onStop");
        super.onStop();
    }
}