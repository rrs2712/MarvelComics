package com.appbusiness.marvelcomics.ui.detail;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.appbusiness.marvelcomics.R;
import com.appbusiness.marvelcomics.ui.main.MainView;

/**
 *
 * Activity implementing {@link IDetail.View} to preserve MVP pattern.
 *
 * @author Raul RS
 * @version 1.0
 */
public class DetailView extends Activity implements IDetail.View{

    // Bundles
    private String comicID;
    // MVP
    private IDetail.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        retrieveBundle();

        TextView tv = (TextView) findViewById(R.id.text_view_details);

        presenter = new DetailPresenter(this);
        presenter.showDetail(tv, this, comicID);
    }

    /**
     * Method to check if the bundle has been received and it contains an ID. If not, will
     * return to the previous activity.
     *
     */
    private void retrieveBundle(){
        Bundle bundle = getIntent().getExtras();
        comicID = bundle.getString(MainView.ITEM_ID,"");

        if(comicID.equals("")){
            Toast.makeText(this,"No comic ID",Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

}
