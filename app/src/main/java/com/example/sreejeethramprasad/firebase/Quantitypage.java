package com.example.sreejeethramprasad.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Vishvajith Ramprasad on 12-05-2017.
 */

public class Quantitypage extends MainActivityone {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quantity_interface);
        databaseArtistsfour = FirebaseDatabase.getInstance().getReference("artistsfour");


        databaseArtistsfour.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artiststhree.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artistthree artist = postSnapshot.getValue(Artistthree.class);
                    //adding artist to the list
                    artiststhree.add(artist);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        ArtistListthree artistAdapterthree = new ArtistListthree(Quantitypage.this, artiststhree);
        //attaching adapter to the listview
         listViewArtists8.setAdapter(artistAdapterthree);
    }
}
