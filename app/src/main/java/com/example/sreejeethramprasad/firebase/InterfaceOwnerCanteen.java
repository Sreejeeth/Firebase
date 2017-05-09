package com.example.sreejeethramprasad.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.sreejeethramprasad.firebase.R.id.listViewArtists1;

/**
 * Created by Vishvajith Ramprasad on 04-05-2017.
 */

public class InterfaceOwnerCanteen extends MainActivityCanteen {
    ArrayList<Artist> questions;
   // DatabaseReference databaseArtists;
   // ListView listViewArtists2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.owner_interface_canteen);
       listViewArtists3= (ListView) findViewById(listViewArtists1);

        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");

        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artists1.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artist artist = postSnapshot.getValue(Artist.class);
                    //adding artist to the list
                    artists1.add(artist);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ArtistListCanteen artistAdapter = new ArtistListCanteen(InterfaceOwnerCanteen.this, artists1);
        //attaching adapter to the listview
        listViewArtists3.setAdapter(artistAdapter);
    }
}