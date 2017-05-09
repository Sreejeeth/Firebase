package com.example.sreejeethramprasad.firebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vishvajith Ramprasad on 05-05-2017.
 */

public class ArtistListCanteen extends ArrayAdapter<Artist> {
    private Activity context;
    List<Artist> artists;

    public ArtistListCanteen(Activity context, List<Artist> artists) {
        super(context, R.layout.list_layout_canteen, artists);
        this.context = context;
        this.artists = artists;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout_canteen, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName1);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        Artist artist = artists.get(position);
        textViewName.setText(artist.getArtistName());
        textViewGenre.setText(artist.getArtistGenre());

        return listViewItem;
    }
}