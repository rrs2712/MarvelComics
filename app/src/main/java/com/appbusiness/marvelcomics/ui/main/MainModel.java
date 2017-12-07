package com.appbusiness.marvelcomics.ui.main;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.appbusiness.marvelcomics.data.model.Marvel;
import com.appbusiness.marvelcomics.data.model.MarvelContract;
import com.appbusiness.marvelcomics.data.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rrs27 on 2017-12-05.
 */

class MainModel implements IComic.Model {

    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();
    // Presenter
    private IComic.Presenter presenter;

    /**
     * Class constructor. Receives {@link IComic.Presenter} to instantiate this class.
     * @param mainPresenter - IComic.Presenter
     */
    public MainModel(MainPresenter mainPresenter) {
        Log.d(TAG, "Using " + this.getClass().getSimpleName());
        this.presenter = mainPresenter;
    }

    @Override
    public void fillList(ListView lv, Activity context) {
        retrieveData(lv,context);
    }

    /**
     * Obtains data from an end point using {@link Retrofit} and {@link com.google.gson.Gson}
     *
     * @param lv - {@link ListView}
     * @param context - {@link Activity}
     */
    private void retrieveData(final ListView lv, final Activity context) {
        Log.d(TAG,"retrieveData");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MarvelContract.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MarvelContract marvelContract = retrofit.create(MarvelContract.class);
        Call<Marvel> comicsRequest = marvelContract.getMarvelComics(
                MarvelContract.TS,
                MarvelContract.PUBLIC_KEY,
                MarvelContract.HASH,
                MarvelContract.LIMIT);

        comicsRequest.enqueue(new Callback<Marvel>() {
            @Override
            public void onResponse(Call<Marvel> call, Response<Marvel> response) {
                if(!response.isSuccessful()){
                    Log.w(TAG,"unsuccessful: " + response.code());
                    Log.i(TAG,call.request().toString());
                    Log.i(TAG,call.request().headers().toString());
                    Log.i(TAG,response.toString());

                    return;
                }

                Log.i(TAG,"onResponse: "+ response.toString());
                Marvel comics = response.body();
                setWidgets(comics.getData().getResults(), lv, context);
            }

            @Override
            public void onFailure(Call<Marvel> call, Throwable t) {
                Log.e(TAG,"onFailure: " + t.getMessage());
                Log.i(TAG,call.request().toString());
                Log.i(TAG,call.request().headers().toString());
            }
        });
    }

    /**
     *
     * Method to set a custom ListView for a list of comics
     *
     * @param results - {@link List< Result >}
     * @param lv - {@link ListView}
     * @param context - {@link Activity}
     */
    private void setWidgets(final List<Result> results, ListView lv, Activity context) {
        ComicAdapter comicAdapter = new ComicAdapter(context,results);

        lv.setAdapter(comicAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Result comic = results.get(position);
                Log.d(TAG,"Click on comic: " +  comic.toString());
                presenter.sendDetailID(comic.getId().toString());
            }
        });

//        for (Result comic: results) {
//            Log.d(TAG,comic.toString());
//        }
    }
}
