package com.appbusiness.marvelcomics.data.model;

/**
 * Created by rrs27 on 2017-12-07.
 */

public class Marvel {
    private Data data;

    public Marvel(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Marvel{" +
                "data=" + data +
                '}';
    }
}
