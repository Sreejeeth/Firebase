package com.example.sreejeethramprasad.firebase;

/**
 * Created by Vishvajith Ramprasad on 13-05-2017.
 */

import android.app.Activity;
import android.widget.ArrayAdapter;

/**
 * Created by Vishvajith Ramprasad on 03-05-2017.
 */

        import android.app.Activity;
        import android.support.annotation.NonNull;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.CheckBox;
        import android.widget.TextView;

        import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class ArtistListfour extends ArrayAdapter<Artisttwo> {
    private Activity context;
    List<Artisttwo> artists;

    public ArtistListfour(Activity context, List<Artisttwo> artists) {
        super(context, R.layout.list_layout_four, artists);
        this.context = context;
        this.artists = artists;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItemone = inflater.inflate(R.layout.list_layout_four, null, true);

        TextView textViewName = (TextView) listViewItemone.findViewById(R.id.textViewNameone);
        TextView textViewQuantity = (TextView) listViewItemone.findViewById(R.id.TextViewQuantity);
        TextView textViewPrice = (TextView) listViewItemone.findViewById(R.id.textViewPrice);

        Artisttwo artist = artists.get(position);

        textViewName.setText(artist.getArtistName());
        //textViewGenre.setText(artist.getArtistGenre());
        textViewPrice.setText(artist.getArtistPrice()+"");
        textViewQuantity.setText(artist.getArtistQuantity()+"");

        return listViewItemone;
    }
}