package com.example.activitylifecyclemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Log.d("Statusz", "ActivityTwo: onCreate()");

        Button button = findViewById(R.id.button2);
        Button button1 = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTwo.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTwo.this, ActivityThree.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz", "ActivityTwo: onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz", "ActivityTwo: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz", "ActivityTwo: onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz", "ActivityTwo: onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz", "ActivityTwo: onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz", "ActivityTwo: onRestart()");
    }
}