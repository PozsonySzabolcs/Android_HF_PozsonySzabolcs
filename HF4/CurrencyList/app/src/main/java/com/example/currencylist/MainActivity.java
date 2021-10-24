package com.example.currencylist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.currencyList);

        CustomListViewAdapter adapter = new CustomListViewAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = DisplayedObject.getNameArray()[position];
                double buyPrice = DisplayedObject.getBuyInfoArray()[position];
                Toast.makeText(getApplicationContext(), name + " " + String.format("%,.4f", buyPrice) + " RON",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}