package com.appbusiness.marvelcomics.ui.main;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbusiness.marvelcomics.R;
import com.appbusiness.marvelcomics.data.model.Result;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;


/**
 *
 * Class extending {@link ArrayAdapter<Result>} to create a customs ListView.
 *
 * @author Raul RS
 * @version 1.0
 */
public class ComicAdapter extends ArrayAdapter<Result> {

    // Async image loader
    private ImageLoader imageloader = ImageLoader.getInstance();

    /**
     * Class constructor.
     *
     * @param context - {@link Activity}
     * @param comics - {@link List<Result>}
     */
    public ComicAdapter(Activity context, List<Result> comics) {
        super(context, 0, comics);
        imageloader.init(ImageLoaderConfiguration.createDefault(context));
    }

    /**
     * Provides a View for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item View.
     * @param convertView The recycled View to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing View is being reused, otherwise inflate the View
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_comics, parent, false);
        }

        Result comic = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.comic_title);
        nameTextView.setText(comic.getTitle());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.comic_icon);
        String imgLink =
                comic.getThumbnail().getPath() +
                "." +
                comic.getThumbnail().getExtension();
        imageloader.displayImage(imgLink, iconView);

        return listItemView;
    }

}