package com.example.sreejeethramprasad.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.style.ParagraphStyle;
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
   public  static ArrayList<Artisttwo> artiststhree;
    // DatabaseReference databaseArtists;
    // ListView listViewArtists2;
    ListView listViewArtists7;
    Button button3;
    TextView buttoninterface;
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
for(int i=0;i<artiststwo.size();i++)
    artiststwo.get(i).setArtistQuantity(0);

        listViewArtists7 = (ListView) findViewById(R.id.listViewArtiststwo);


        databaseArtiststwo = FirebaseDatabase.getInstance().getReference("artiststwo");
        databaseArtiststhree = FirebaseDatabase.getInstance().getReference("artiststhree");

        databaseArtiststwo.addValueEventListener(new ValueEventListener() {
            @Override
           public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artiststwo.clear();

                //iterating through all the nodes+
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist

                    Artisttwo artist = postSnapshot.getValue(Artisttwo.class);

                    artiststwo.add(artist);

                }
//artiststhree=artiststwo;


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
recreate();
            }
        });

        ArtistListtwo artistAdapter = new ArtistListtwo(InterfaceOwnerone.this, artiststwo);
        //attaching adapter to the listview
        listViewArtists7.setAdapter(artistAdapter);
       /* Bundle newBundle = new Bundle();
        mBundle.putParcelable("listview", artistAdapter); // the key is the identifier for the parcelable
        newIntent.putExtras(newBundle);
        startActivity(newIntent);*/

    }
public void summaryorder()
    {
        Intent intent=new Intent(InterfaceOwnerone.this,SummaryOrder.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("artiststwo",artiststwo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
 /*   private ArrayList<Artisttwo> getModel(){
        ArrayList<Artisttwo> list = new ArrayList<>();


            Artisttwo model = new Artisttwo();
            model.setArtistQuantity(model.getArtistQuantity());
            model.setArtistName(model.getArtistName());
            model.setArtistPrice(model.getArtistPrice());
            model.setArtistId(model.getArtistId());
            list.add(model);

        return list;
    }*/

    }



