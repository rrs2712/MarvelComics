package com.appbusiness.marvelcomics.data.model;

/**
 * Created by rrs27 on 2017-12-07.
 */

public class Price {
    private String type;
    private double price;

    public Price(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
