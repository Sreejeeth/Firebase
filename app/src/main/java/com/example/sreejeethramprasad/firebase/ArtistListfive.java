package com.example.sreejeethramprasad.firebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vishvajith Ramprasad on 15-05-2017.
 */

public class ArtistListfive extends ArrayAdapter<Artistfive> {
    private Activity context;
    List<Artistfive> artists;

    public ArtistListfive(Activity context, List<Artistfive> artists) {
        super(context, R.layout.list_layout_five, artists);
        this.context = context;
        this.artists = artists;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout_five, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.itemName);
        TextView textViewQuantity = (TextView) listViewItem.findViewById(R.id.itemQty);

        Artistfive artist = artists.get(position);
        textViewName.setText(artist.getArtistName());
        textViewQuantity.setText(artist.getArtistQuantity() +"");

        return listViewItem;
    }
}
