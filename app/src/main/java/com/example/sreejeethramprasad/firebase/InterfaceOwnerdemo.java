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

/**
 * Created by Vishvajith Ramprasad on 04-05-2017.
 */

public class InterfaceOwnerdemo extends MainActivitydemo {
    ArrayList<Artist> questions;
    DatabaseReference databaseArtists;
   ListView listViewArtists1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.owner_interface);
       listViewArtists1 = (ListView) findViewById(R.id.listViewArtists);

        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");

        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artists.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artist artist = postSnapshot.getValue(Artist.class);
                    //adding artist to the list
                    artists.add(artist);
                }

                //        //   Intent intent = new Intent(MainActivity.this, InterfaceOwner.class);
                //        // Bundle b = new Bundle();
                //      //    b.putSerializable("artists",artists);
                //      //    intent.putExtras(b);
                // intent.putStringArrayListExtra("key", (ArrayList) artists);
                //  intent.putExtra("QuestionListExtra", artists);
                //intent.putParcelableArrayListExtra("key", ArrayList<T extends Parcelable> list);

                //  intent.putStringArrayListExtra("stock_list", artists);
                //    b.putSerializable("key", (Serializable) artists);
                // intent.putExtra("BUNDLE", b);
                //      //    startActivity(intent);
                //ArrayList<String> myList = new ArrayList<String>();
                // Intent intent = new Intent(MainActivity.this, InterfaceOwner.class);
                //intent.putStringArrayListExtra("key",(ArrayList)artists);
                //startActivity(intent);
                //intent.putExtra("mylist", myList);
                //creating adapter
                //   ArtistList artistAdapter = new ArtistList(MainActivity.this, artists);
                //attaching adapter to the listview
                // listViewArtists.setAdapter(artistAdapter);
                //   String result = (String) listViewArtists.getItemAtPosition(position).toString();
                //  intent.putExtra("get",result);
                //  startActivity(intent);

              /*  listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                    {
                        Intent intent = new Intent(MainActivity.this,InterfaceOwner.class);

                            // intent.putExtra("get", aList.get(position));


                            String result = (String) listViewArtists.getItemAtPosition(position).toString();
                        Bundle b = new Bundle();

                            intent.putExtra("get",result);
                            startActivity(intent);
                     }
                });*/
//creating adapter
                ArtistList artistAdapter = new ArtistList(InterfaceOwnerdemo.this, artists);
                //attaching adapter to the listview
                listViewArtists1.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}