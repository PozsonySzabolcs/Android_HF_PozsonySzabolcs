package com.example.hf1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText szam1 = findViewById(R.id.szam1);
        EditText szam2 = findViewById(R.id.szam2);

        Button osszeadas = findViewById(R.id.osszeadas);
        Button kivonas = findViewById(R.id.kivonas);
        Button szorzas = findViewById(R.id.szorzas);
        Button osztas = findViewById(R.id.osztas);

        TextView eredmeny = findViewById(R.id.eredmeny);

        osszeadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double osszeg = Double.parseDouble(szam1.getText().toString()) + Double.parseDouble(szam2.getText().toString());
                    String formazottEredmeny = String.format("%.2f", osszeg);
                    eredmeny.setText(formazottEredmeny);

                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Kérem számot adjon bemenetnek!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        kivonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double kulonbseg = Double.parseDouble(szam1.getText().toString()) - Double.parseDouble(szam2.getText().toString());
                    String formazottEredmeny = String.format("%.2f", kulonbseg);
                    eredmeny.setText(formazottEredmeny);

                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Kérem számot adjon bemenetnek!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        szorzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double szorzat = Double.parseDouble((szam1.getText().toString())) * Double.parseDouble(szam2.getText().toString());
                    String formazottEredmeny = String.format("%.2f", szorzat);
                    eredmeny.setText(formazottEredmeny);

                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Kérem számot adjon bemenetnek!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        osztas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double hanyados = Double.parseDouble(szam1.getText().toString()) / Double.parseDouble(szam2.getText().toString());
                    if (Double.parseDouble(szam2.getText().toString()) == 0) {
                        throw new ArithmeticException("Zéróval való osztás!");
                    } else {
                        String formazottEredmeny = String.format("%.2f", hanyados);
                        eredmeny.setText(formazottEredmeny);
                    }
                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Kérem számot adjon bemenetnek!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } catch (ArithmeticException e) {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, e.getMessage(), duration);
                    toast.show();
                }
            }
        });
    }
}