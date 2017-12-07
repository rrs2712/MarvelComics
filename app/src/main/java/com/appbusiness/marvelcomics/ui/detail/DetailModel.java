package com.appbusiness.marvelcomics.ui.detail;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.appbusiness.marvelcomics.data.model.Marvel;
import com.appbusiness.marvelcomics.data.model.MarvelContract;
import com.appbusiness.marvelcomics.data.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * Class to implementing {@link IDetail.Model} to retrieve data from an end point and
 * populate views with such data.
 *
 * @author Raul RS
 * @version 1.0
 */
public class DetailModel implements IDetail.Model {

    // MVP
    private IDetail.Presenter presenter;
    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();

    /**
     * Class constructor. Receives a presenter to instantiate this class.
     * @param presenter - {{@link IDetail.Presenter}}
     */
    public DetailModel(IDetail.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     *
     * Fills views passed as references by parameters:
     *
     * @param tv - TextView
     * @param context - Activity
     * @param procedureID - String
     */
    @Override
    public void fillWidgets(final TextView tv, final Activity context, String procedureID) {
        retrieveData(tv, context, procedureID);
    }

    /**
     * Method to set a custom views of a comic object.
     *
     * @param comic - {@link Result}
     * @param tv - TextView
     * @param context - Activity
     */
    private void setWidgets(Result comic, TextView tv, Activity context) {

        String details =
                "ID: " + comic.getId() + "\n\n" +
                "Title: " + comic.getTitle() + "\n\n" +
                "Description:\n" +comic.getDescription() + "\n\n" +
                "Pages: " + comic.getPageCount() + "\n\n" +
                "Price: $" + comic.getPrices().get(0).getPrice() + "\n\n" +
                "Author(s): " + comic.getCreators().getAvailable() ;

        tv.setText(details);
    }

    /**
     * Obtains data from an end point using {@link Retrofit} and {@link com.google.gson.Gson}
     *
     * @param tv - {@link TextView}
     * @param context - {@link Activity}
     */
    private void retrieveData(final TextView tv, final Activity context, String comicID) {
        Log.d(TAG,"retrieveData");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MarvelContract.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MarvelContract marvelContract = retrofit.create(MarvelContract.class);
        Call<Marvel> comicsRequest = marvelContract.getComic(
                comicID,
                MarvelContract.TS,
                MarvelContract.PUBLIC_KEY,
                MarvelContract.HASH);

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
                setWidgets(comics.getData().getResults().get(0), tv, context);
            }

            @Override
            public void onFailure(Call<Marvel> call, Throwable t) {
                Log.e(TAG,"onFailure: " + t.getMessage());
                Log.i(TAG,call.request().toString());
                Log.i(TAG,call.request().headers().toString());
            }
        });
    }
}
