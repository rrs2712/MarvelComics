package com.appbusiness.marvelcomics.ui.main;

import android.app.Activity;
import android.widget.ListView;

/**
 * Interface with sub-interfaces to manage MVP implementation of the Main view,
 * presenter and model.
 *
 * @author Raul RS
 * @version 1.0
 */
public interface IComic {

    interface View {
        void showComicDetail(String detailID);
    }

    interface Presenter{
        void showComics(ListView lv, Activity context);
        void sendDetailID(String detailID);
    }

    interface Model{
        void fillList(ListView lv, Activity context);
    }
}
