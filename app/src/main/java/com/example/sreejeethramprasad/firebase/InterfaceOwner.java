package com.example.sreejeethramprasad.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishvajith Ramprasad on 04-05-2017.
 */

public class InterfaceOwner extends MainActivity {
    ArrayList<Artist> questions ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.owner_interface);

       // Intent intent = getIntent();
       // Bundle args = intent.getBundleExtra("BUNDLE");
       //    ArrayList<Artist> object = (ArrayList<Artist>) args.getSerializable("key");
Bundle bundleObject=getIntent().getExtras();
        questions = (ArrayList<Artist>) bundleObject.getSerializable("artists");
       // ArtistList artistAdapter = new ArtistList(InterfaceOwner.this, questions);
      //  ListView listViewArtists = (ListView) findViewById(R.id.listViewArtists);
        //attaching adapter to the listview
       // listViewArtists.setAdapter(artistAdapter);

        // List<Artist> list;

      //  Bundle b = getIntent().getExtras();
//list =(ArrayList)b.getStringArrayList("key");
      // list =(ArrayList)b.getStringArrayList("key");
     // ArrayList<Artist> list = new ArrayList<>();
      //  list=(ArrayList) getIntent().getStringArrayListExtra("key");
        ArtistList artistAdapter = new ArtistList(InterfaceOwner.this, questions);
        //attaching adapter to the listview
        ListView listViewArtists = (ListView) findViewById(R.id.listViewArtists);
         listViewArtists.setAdapter(artistAdapter);

}}