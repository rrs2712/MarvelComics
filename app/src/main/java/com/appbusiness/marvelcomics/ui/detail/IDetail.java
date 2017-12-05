package com.appbusiness.marvelcomics.ui.detail;

import android.app.Activity;
import android.widget.TextView;

/**
 * Interface with sub-interfaces to manage MVP implementation of the Detail view,
 * presenter and model.
 *
 * @author Raul RS
 * @version 1.0
 */
public interface IDetail {

    interface View{}

    interface Presenter{
        void showDetail(TextView tv, Activity context, String comicID);
    }

    interface Model{
        void fillWidgets(final TextView tv, final Activity context, String comicID);
    }
}
