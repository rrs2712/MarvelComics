package com.appbusiness.marvelcomics.data.model;

/**
 * Created by rrs27 on 2017-12-07.
 */

public class Creators {
    private int available;
    private String collectionURI;

    public Creators(int available, String collectionURI) {
        this.available = available;
        this.collectionURI = collectionURI;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    @Override
    public String toString() {
        return "Creators{" +
                "available=" + available +
                ", collectionURI='" + collectionURI + '\'' +
                '}';
    }
}
