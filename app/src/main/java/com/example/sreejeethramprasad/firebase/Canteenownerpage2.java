package com.example.sreejeethramprasad.firebase;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.sreejeethramprasad.firebase.R.id.listViewArtists;
import static com.example.sreejeethramprasad.firebase.R.id.listViewArtistspage2;

/**
 * Created by Vishvajith Ramprasad on 15-05-2017.
 */

public class Canteenownerpage2 extends MainActivityone {

   public static  ArrayList<Artistfive> artistsfive;


    //our database reference object
DatabaseReference databaseArtistsqty;
    ListView listViewArtistspage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_canteen2);



        artistsfive=new ArrayList<>();

        listViewArtistspage2 = (ListView) findViewById(R.id.listViewArtistspage2);
        databaseArtistsqty = FirebaseDatabase.getInstance().getReference("artistqty");


        databaseArtistsqty.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            //clearing the previous artist list
            artistsfive.clear();
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                //getting artist
                Artistfive artist = postSnapshot.getValue(Artistfive.class);
                //adding artist to the list
                artistsfive.add(artist);

            }

        }


        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    // // // // // ArtistListCanteen artistAdapter = new ArtistListCanteen(MainActivityCanteen.this, artists1);
    ArtistListfive artistAdapter = new ArtistListfive(Canteenownerpage2.this,artistsfive);
        listViewArtistspage2 = (ListView) findViewById(R.id.listViewArtistspage2);
        listViewArtistspage2.setAdapter(artistAdapter);

}
}
