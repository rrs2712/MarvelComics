package com.appbusiness.marvelcomics.data.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rrs27 on 2017-12-05.
 */

public interface MarvelContract {

    public static final String END_POINT="http://gateway.marvel.com/";
    public static final String PUBLIC_KEY="54306733de0f5cd1418aa05a85fa062a";
    public static final String PRIVATE_KEY="5de1fabcda2ea08912bd8b09bca4321f50563655";

    @GET("v1/public/comics")
    Call<List<Comic>> getComic();
}
