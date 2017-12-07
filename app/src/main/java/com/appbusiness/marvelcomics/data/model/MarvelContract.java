package com.appbusiness.marvelcomics.data.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rrs27 on 2017-12-05.
 */

public interface MarvelContract {

    public static final String END_POINT="http://gateway.marvel.com/";
    public static final String PUBLIC_KEY = "54306733de0f5cd1418aa05a85fa062a";
    public static final String TS = "raulregaladosanchez";
    public static final String HASH = "d8a0f6572a0199aad4e7bf4e0421f9a7";
    public static final int LIMIT=100;

    @Headers("Accept: */*")
    @GET("v1/public/comics")
    Call<Marvel> getMarvelComics(
            @Query("ts") String timeStamp,
            @Query("apikey") String publicKey,
            @Query("hash") String hash,
            @Query("limit") int limit);

    @Headers("Accept: */*")
    @GET("v1/public/comics/{comicId}")
    Call<Marvel> getComic(
            @Path("comicId") String comicId,
            @Query("ts") String timeStamp,
            @Query("apikey") String publicKey,
            @Query("hash") String hash);
}
