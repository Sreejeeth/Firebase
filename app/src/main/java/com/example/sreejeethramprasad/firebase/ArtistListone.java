package com.example.sreejeethramprasad.firebase;

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

public class ArtistListone extends ArrayAdapter<Artistone> {
    private Activity context;
    List<Artistone> artists;

    public ArtistListone(Activity context, List<Artistone> artists) {
        super(context, R.layout.list_layout_one, artists);
        this.context = context;
        this.artists = artists;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItemone = inflater.inflate(R.layout.list_layout_one, null, true);

        TextView textViewName = (TextView) listViewItemone.findViewById(R.id.textViewNameone);
       // TextView textViewGenre = (TextView) listViewItemone.findViewById(R.id.textViewGenreone);
        TextView textViewPrice = (TextView) listViewItemone.findViewById(R.id.textViewPrice);

        Artistone artist = artists.get(position);
        textViewName.setText(artist.getArtistName());
        //textViewGenre.setText(artist.getArtistGenre());
        textViewPrice.setText(artist.getArtistPrice()+"");
        return listViewItemone;
    }
}