package com.example.sreejeethramprasad.firebase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static com.example.sreejeethramprasad.firebase.R.id.textViewGenre;

/**
 * Created by Vishvajith Ramprasad on 12-05-2017.
 */

public class ArtistListthree extends ArrayAdapter<Artistthree> {
    private Activity context;
    List<Artistthree> artists;

    public ArtistListthree(Activity context, List<Artistthree> artists) {
        super(context, R.layout.list_layout_three, artists);
        this.context = context;
        this.artists = artists;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout_three, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewNameone);
        TextView textViewQuantity = (TextView) listViewItem.findViewById(R.id.textViewQtyone);

        Artistthree artist = artists.get(position);
        textViewName.setText(artist.getArtistName());
        textViewQuantity.setText(artist.getArtistQuantity());

        return listViewItem;
    }
}