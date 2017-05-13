package com.example.sreejeethramprasad.firebase;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.sreejeethramprasad.firebase.MainActivityone.artiststwo;

/**
 * Created by Vishvajith Ramprasad on 13-05-2017.
 */

public class SummaryOrder extends InterfaceOwnerone {
    // ArrayList<Artisttwo> artiststwo;
    // DatabaseReference databaseArtists;
    // ListView listViewArtists2;
    ListView listViewArtists9;
    int gobi=0;
    int parota=0;
    int masala_dosa=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order_summary);
        listViewArtists9= (ListView) findViewById(R.id.listViewArtiststhree);

        databaseArtiststwo = FirebaseDatabase.getInstance().getReference("artiststwo");
        databaseArtiststhree = FirebaseDatabase.getInstance().getReference("artiststhree");

        databaseArtiststhree.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artiststwo.clear();

                //iterating through all the nodes+
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artisttwo artist = postSnapshot.getValue(Artisttwo.class);
                    //adding artist to the list
                    if(postSnapshot.getValue(Artisttwo.class).getArtistQuantity()>0)
                    artiststwo.add(artist);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ArtistListfour artistAdapter = new ArtistListfour(SummaryOrder.this, artiststwo);
        //attaching adapter to the listview


                listViewArtists9.setAdapter(artistAdapter);
        }



}