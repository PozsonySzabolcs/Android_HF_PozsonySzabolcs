package com.example.activitylifecyclemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Log.d("Statusz", "ActivityThree: onCreate()");

        Button button = findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThree.this, ActivityTwo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz", "ActivityThree: onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz", "ActivityThree: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz", "ActivityThree: onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz", "ActivityThree: onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz", "ActivityThree: onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz", "ActivityThree: onRestart()");
    }
}