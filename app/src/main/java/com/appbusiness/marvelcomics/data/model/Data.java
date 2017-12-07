package com.appbusiness.marvelcomics.data.model;

import java.util.List;


/**
 * Created by rrs27 on 2017-12-07.
 */

public class Data {
    private List<Result> results;

    public Data(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "results=" + results +
                '}';
    }
}
