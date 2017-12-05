package com.appbusiness.marvelcomics.ui.main;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.appbusiness.marvelcomics.data.model.Comic;

import java.util.ArrayList;
import java.util.List;

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
        this.presenter = mainPresenter;
    }

    @Override
    public void fillList(ListView lv, Activity context) {
        List<Comic> comics = new ArrayList<Comic>();
        for (int i = 0; i < 100; i++) {
            comics.add(new Comic(String.valueOf(i),"Title " + i, "R.drawable.ic_launcher_background"));
        }

        setWidgets(comics, lv, context);
    }


    /**
     *
     * Method to set a custom ListView for a list of {@link Comic}
     *
     * @param comics - {@link List<Comic>}
     * @param lv - {@link ListView}
     * @param context - {@link Activity}
     */
    private void setWidgets(final List<Comic> comics, ListView lv, Activity context) {

        ComicAdapter comicAdapter = new ComicAdapter(context,comics);

        lv.setAdapter(comicAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Comic comic = comics.get(position);
                Log.d(TAG,"Comic: " +  comic.toString());
                presenter.sendDetailID(comic.getId());
            }
        });
    }
}
