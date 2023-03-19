package com.example.bmical;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView wel,healthy;
    private static int splash_timeout=5000;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wel = findViewById(R.id.textview1);
        healthy = findViewById(R.id.textview2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashintent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(splashintent);
                finish();

            }
        },splash_timeout);
        Animation myanimation = AnimationUtils.loadAnimation(MainActivity2.this,R.anim.animation1);
        wel.startAnimation(myanimation);

        Animation myanimation2 = AnimationUtils.loadAnimation(MainActivity2.this,R.anim.animation2);
        healthy.startAnimation(myanimation2);


    }
}