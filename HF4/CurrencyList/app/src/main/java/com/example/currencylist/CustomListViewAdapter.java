package com.example.currencylist;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListViewAdapter extends ArrayAdapter {
    private final Activity context;
    private final Integer[] imageArray;
    private final String[] nameArray;
    private final String[] infoArray;
    private final double[] buyInfoArray;
    private final double[] sellInfoArray;

    public CustomListViewAdapter(Activity context) {
        super(context, R.layout.listview_row, DisplayedObject.getNameArray());
        this.context = context;
        this.imageArray = DisplayedObject.getImageArray();
        this.nameArray = DisplayedObject.getNameArray();
        this.infoArray = DisplayedObject.getInfoArray();
        this.buyInfoArray = DisplayedObject.getBuyInfoArray();
        this.sellInfoArray = DisplayedObject.getSellInfoArray();
    }


    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.listview_row, null, true);

        ImageView image = rowView.findViewById(R.id.image);
        TextView name = rowView.findViewById(R.id.name);
        TextView description = rowView.findViewById(R.id.description);
        TextView buyView = rowView.findViewById(R.id.buyView);
        TextView sellView = rowView.findViewById(R.id.sellView);

        image.setImageResource(imageArray[position]);
        name.setText(nameArray[position]);
        description.setText(infoArray[position]);
        buyView.setText(String.format("%,.4f", buyInfoArray[position]));
        sellView.setText(String.format("%,.4f", sellInfoArray[position]));

        return rowView;
    }
}
