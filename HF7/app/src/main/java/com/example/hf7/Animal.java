package com.example.hf7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable {
    private String name;
    private String details;
    private int thumbnailDrawable;

    public Animal(String name, String details, int thumbnailDrawable) {
        this.name = name;
        this.details = details;
        this.thumbnailDrawable = thumbnailDrawable;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public int getThumbnailDrawable() {
        return thumbnailDrawable;
    }

    public static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Macska", "Lab lab lab lab", R.drawable.cat));
        animals.add(new Animal("Diszno", "Lab lab lab lab", R.drawable.disznyo));
        animals.add(new Animal("Kutya", "Lab lab lab lab", R.drawable.dog));
        animals.add(new Animal("Zsiraf", "Lab lab lab lab", R.drawable.giraffe));
        animals.add(new Animal("Lo", "Lab lab lab lab", R.drawable.horse));
        animals.add(new Animal("Oroszlan", "Lab lab lab lab", R.drawable.lion));
        animals.add(new Animal("Nyul", "Lab lab lab lab", R.drawable.rabbit));
        animals.add(new Animal("Barany", "Lab lab lab lab", R.drawable.sheep));
        animals.add(new Animal("Polip", "Lab lab lab lab", R.drawable.octopus));
        return animals;
    }
}
