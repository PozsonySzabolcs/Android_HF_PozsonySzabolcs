package com.example.tablelayout;

public class Product {
    protected int productCode;
    protected String productName;
    protected double productPrice;

    public Product(int productCode, String productName, double productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return this.productName + " price: " + this.productPrice;
    }
}
