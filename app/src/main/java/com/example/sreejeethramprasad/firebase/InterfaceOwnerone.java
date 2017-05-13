package com.example.sreejeethramprasad.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.button1;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.sreejeethramprasad.firebase.R.id.listViewArtists;
import static com.example.sreejeethramprasad.firebase.R.id.listViewArtists1;
import static com.example.sreejeethramprasad.firebase.R.id.listViewArtistsone;

/**
 * Created by Vishvajith Ramprasad on 04-05-2017.
 */

public class InterfaceOwnerone extends MainActivityone{
   // ArrayList<Artisttwo> artiststwo;
    // DatabaseReference databaseArtists;
    // ListView listViewArtists2;
    ListView listViewArtists7;
    Button button3;
int gobi=0;
    int parota=0;
    int masala_dosa=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_interface_one);
        button3 = (Button) findViewById(R.id.order1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                summaryorder();

            }
        });


        listViewArtists7 = (ListView) findViewById(R.id.listViewArtiststwo);


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

                    artiststwo.add(artist);

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ArtistListtwo artistAdapter = new ArtistListtwo(InterfaceOwnerone.this, artiststwo);
        //attaching adapter to the listview
        listViewArtists7.setAdapter(artistAdapter);
    }
public void summaryorder()
    {
        Intent intent=new Intent(InterfaceOwnerone.this,SummaryOrder.class);
        startActivity(intent);
    }

    }



