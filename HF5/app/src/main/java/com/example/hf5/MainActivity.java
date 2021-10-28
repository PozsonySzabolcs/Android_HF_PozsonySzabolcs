package com.example.hf5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayAdapter<CharSequence> adapter;
    ArrayList<CharSequence> roster = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roster.add("LeBron James");
        roster.add("Russell Westbrook");
        roster.add("Carmelo Anthony");
        roster.add("Anthony Davis");
        roster.add("Dwight Howard");
        roster.add("DeAndre Jordan");
        roster.add("Rajon Rondo");
        roster.add("Talen Horton-Tucker");

        list = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, roster);
        registerForContextMenu(list);
        list.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort:
                Collections.sort(roster, new Comparator<CharSequence>() {
                    @Override
                    public int compare(CharSequence o1, CharSequence o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                });
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Rendez", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                roster.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Töröl", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        SpannableString string;
        switch (item.getItemId()) {
            case R.id.red:
                string = SpannableString.valueOf(roster.get(info.position));
                string.setSpan(new ForegroundColorSpan(Color.RED), 0, string.length(), 0);
                roster.set(info.position, string);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.green:
                string = SpannableString.valueOf(roster.get(info.position));
                string.setSpan(new ForegroundColorSpan(Color.GREEN), 0, string.length(), 0);
                roster.set(info.position, string);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.yellow:
                string = SpannableString.valueOf(roster.get(info.position));
                string.setSpan(new ForegroundColorSpan(Color.YELLOW), 0, string.length(), 0);
                roster.set(info.position, string);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}