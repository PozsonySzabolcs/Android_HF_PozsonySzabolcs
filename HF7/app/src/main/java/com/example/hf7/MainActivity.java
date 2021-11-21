package com.example.hf7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvAnimals = findViewById(R.id.rvAnimals);
        rvAnimals.setHasFixedSize(true);
        rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        List<Animal> animals = Animal.getAnimals();
        AnimalsAdapter adapter = new AnimalsAdapter(this, animals);
        rvAnimals.setAdapter(adapter);
    }
}