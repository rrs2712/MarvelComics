package com.appbusiness.marvelcomics.ui.main;

import android.app.Activity;
import android.widget.ListView;

/**
 *
 * Class to implementing {@link IComic.Presenter} to preserve MVP pattern.
 *
 * @author Raul RS
 * @version 1.0
 */
public class MainPresenter implements IComic.Presenter {

    // MVP variables
    private IComic.View view;
    private IComic.Model model;

    /**
     * Class constructor.
     *
     * @param view - {@link IComic.View}
     */
    public MainPresenter(IComic.View view) {
        this.view = view;
        this.model = new MainModel(this);
    }

    // ## Implementations ## //

    @Override
    public void showComics(ListView lv, Activity context) {
        if(view!=null){
            model.fillList(lv,context);
        }
    }

    @Override
    public void sendDetailID(String detailID) {
        if(view!=null){
            view.showComicDetail(detailID);
        }
    }
}

