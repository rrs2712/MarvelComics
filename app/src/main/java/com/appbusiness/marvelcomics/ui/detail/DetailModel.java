package com.appbusiness.marvelcomics.ui.detail;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.appbusiness.marvelcomics.data.model.Detail;

import retrofit2.Retrofit;

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
     *
     * Obtains data from an end point using {@link Retrofit} and {@link com.google.gson.Gson}
     *
     * @param tv - TextView
     * @param context - Activity
     * @param comicID - String
     */
    private void retrieveData(final TextView tv, final Activity context, String comicID) {
        Log.d(TAG,"retrieveData");
        // todo: implement API call (Retrofit)

        Detail detail = new Detail("Title " + comicID, "A description","pages: 55","$19.99","Unknown author");

        setWidgets(detail,tv, context);
    }

    /**
     * Method to set a custom views of a detail object.
     *
     * @param detail - {@link Detail}
     * @param tv - TextView
     * @param context - Activity
     */
    private void setWidgets(Detail detail, TextView tv, Activity context) {

        String details =
                detail.getTitle() + "\n" +
                detail.getDescription() + "\n" +
                detail.getPageCount() + "\n" +
                detail.getPrice() + "\n" +
                detail.getAuthors() ;

        tv.setText(details);
    }
}
