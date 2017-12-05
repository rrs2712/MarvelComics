package com.appbusiness.marvelcomics.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.appbusiness.marvelcomics.R;
import com.appbusiness.marvelcomics.ui.detail.DetailView;

public class MainView extends Activity implements IComic.View {

    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();
    // Bundles
    public static final String ITEM_ID = "item_detail_id";
    // MVP
    private IComic.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        ListView lv = (ListView) findViewById(R.id.list_view_comics);
        presenter = new MainPresenter(this);
        presenter.showComics(lv, this);
    }

    @Override
    public void showComicDetail(String detailID) {
        showDetail(detailID);
    }

    /**
     *
     * Method called when users clicks on an item.
     *
     * @param id - String
     */
    private void showDetail(String id) {
        Log.d(TAG,"Selected item: " + id);

        Bundle b = new Bundle();
        b.putString(ITEM_ID,id);

        Intent i = new Intent(this, DetailView.class);
        i.putExtras(b);
        startActivity(i);
    }
}
