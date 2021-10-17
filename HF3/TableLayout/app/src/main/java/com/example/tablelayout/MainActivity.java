package com.example.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText productCode = findViewById(R.id.productCode);
        EditText productName = findViewById(R.id.productName);
        EditText productPrice = findViewById(R.id.productPrice);

        TextView list = findViewById(R.id.list);

        Button addProduct = findViewById(R.id.addProduct);
        Button cancel = findViewById(R.id.cancel);
        Button showProducts = findViewById(R.id.showProducts);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (productCode.getText().toString().isEmpty() ||
                            productName.getText().toString().isEmpty() ||
                            productPrice.getText().toString().isEmpty()) {
                        throw new EmptyFieldException("You have to fill in all fields!");
                    } else {

                        /*A productcode-ot egyedinek vettem tehat,
                        ha van a listaban egy koddal levo termek akkor
                        ugyanarra a kodra nem tudok uj termeket betenni*/

                        for (Product product : products) {
                            if (product.productCode == Integer.parseInt(productCode.getText().toString())) {
                                throw new InvalidProductCodeException("Please enter an another product code!");
                            }
                        }

                        int productCodeInteger = Integer.parseInt(productCode.getText().toString());
                        String productNameString = productName.getText().toString();
                        double productPriceDouble = Double.parseDouble(productPrice.getText().toString());

                        products.add(new Product(productCodeInteger, productNameString, productPriceDouble));
                        Toast.makeText(MainActivity.this,
                                "You added a new product!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this,
                            "Invalid input type, please enter a number", Toast.LENGTH_SHORT).show();
                } catch (InvalidProductCodeException | EmptyFieldException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productCode.setText("");
                productName.setText("");
                productPrice.setText("");
            }
        });

        showProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.setText("");
                for (Product product : products) {
                    list.append(product.toString() + "\n");
                }
            }
        });
    }
}