package com.example.sreejeethramprasad.firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.label;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.sreejeethramprasad.firebase.MainActivityone.artiststwo;

//import static com.example.sreejeethramprasad.firebase.MainActivityone.gobi;
import static com.example.sreejeethramprasad.firebase.R.id.listViewArtists;

/**
 * Created by Vishvajith Ramprasad on 13-05-2017.
 */
public class SummaryOrder extends InterfaceOwnerone {
    ArrayList<Artisttwo> artiststwotemp;
    ArrayList<Artistqty> artiststwotemp1;
   ArrayList<Artistqty>artistsqty;

 int i=0;
static int flag=0;
    public static int masala;
    public static int gobi;
    DatabaseReference databaseArtistsqty;
    DatabaseReference databaseArtiststemp;
    Button button;
    // ListView listViewArtists2;
    ListView listViewArtists9;
    TextView Name;
int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order_summary);


        databaseArtistsqty = FirebaseDatabase.getInstance().getReference("artistqty");
        databaseArtiststemp = FirebaseDatabase.getInstance().getReference("artistemp");
        artistsqty=new ArrayList<>();

        databaseArtiststemp.removeValue();
        button = (Button) findViewById(R.id.buttonsummaryorder);

        Bundle bundleobject = getIntent().getExtras();
        artiststwotemp = (ArrayList<Artisttwo>) bundleobject.getSerializable("artiststwo");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   addqty1();
                // Toast.makeText(getApplicationContext(), "Artist Updated", Toast.LENGTH_LONG).show();

                for(int i=0;i<artiststwotemp.size();i++)
                {

                    Artistqty artist = new Artistqty(artiststwotemp.get(i).getArtistId(), artiststwotemp.get(i).getArtistName(), artiststwotemp.get(i).getArtistQuantity());
                    databaseArtiststemp.child(artiststwotemp.get(i).getArtistId()).setValue(artist);
                }




                databaseArtiststemp.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //clearing the previous artist list
                        artiststwotemp1.clear();

                        //iterating through all the nodes+
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            //getting artist

                            Artistqty artist = postSnapshot.getValue(Artistqty.class);

                            artiststwotemp1.add(artist);
                            Toast.makeText(getApplicationContext(),artistsqty.size()+ "count1111", Toast.LENGTH_LONG).show();

                        }
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                            for (i=0; i <artistsqty.size(); i++) {

                                if (artistsqty.get(i).getArtistId().equals(postSnapshot.getValue(Artistqty.class).getArtistId())) {
                                    artistsqty.get(i).setArtistQuantity(postSnapshot.getValue(Artistqty.class).getArtistQuantity() + artistsqty.get(i).getArtistQuantity());

                                    Toast.makeText(getApplicationContext(), "if", Toast.LENGTH_LONG).show();
                                    //  Toast.makeText(getApplicationContext(),artiststwotemp.get(i).getArtistQuantity()+ "", Toast.LENGTH_LONG).show();
                                    Toast.makeText(getApplicationContext(),artistsqty.get(i).getArtistId()+ "if1", Toast.LENGTH_LONG).show();

                                    Toast.makeText(getApplicationContext(), postSnapshot.getValue(Artistqty.class).getArtistId() +"if2", Toast.LENGTH_LONG).show();
                                    //  Toast.makeText(getApplicationContext(), artiststwo.get(i).getArtistId()+ "", Toast.LENGTH_LONG).show();


                                    Artistqty artistqty = new Artistqty(artistsqty.get(i).getArtistId(), artistsqty.get(i).getArtistName(), artistsqty.get(i).getArtistQuantity());
                                    databaseArtistsqty.child(artistsqty.get(i).getArtistId()).setValue(artistqty);



                                }

                                else
                                {

                                    Toast.makeText(getApplicationContext(), "else", Toast.LENGTH_LONG).show();
                                    Toast.makeText(getApplicationContext(),artistsqty.get(i).getArtistId()+ "else1", Toast.LENGTH_LONG).show();

                                    Toast.makeText(getApplicationContext(), postSnapshot.getValue(Artistqty.class).getArtistId() +"else2", Toast.LENGTH_LONG).show();
                                    Artistqty artistqty = new Artistqty(artistsqty.get(i).getArtistId(), artistsqty.get(i).getArtistName(), artistsqty.get(i).getArtistQuantity());
                                    databaseArtistsqty.child(artistsqty.get(i).getArtistId()).setValue(artistqty);


                                }
                                //  flag=1;
                                //x Toast.makeText(getApplicationContext(), artiststwotemp.get(i).getArtistId() + "", Toast.LENGTH_LONG).show();
                            }


                            //  Toast.makeText(getApplicationContext(), postSnapshot.getValue(Artistqty.class).getArtistId()+"", Toast.LENGTH_LONG).show();
                        }



//artiststhree=artiststwo;


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        recreate();
                    }
                });

            }
        });
        // Name = (TextView) findViewById(R.id.temp);
        //  Quantity= (TextView) findViewById(R.id.TextViewQuantity);
        //  Price= (TextView) findViewById(R.id.textViewPrice);

        artiststwotemp1=new ArrayList<>();



        ArtistListfour artistAdapter = new ArtistListfour(SummaryOrder.this, artiststwotemp);
        //attaching adapter to the listview
        for (int i = 0; i < artiststwotemp.size(); i++) {
            if (artiststwotemp.get(i).getArtistQuantity() == 0) {

                artistAdapter.remove(artiststwotemp.get(i));
                // artiststwotemp.remove(artiststwotemp.get(i));

            }
        }
        for (int i = 0; i < artiststwotemp.size(); i++) {
            if (artiststwotemp.get(i).getArtistQuantity() == 0) {

                artistAdapter.remove(artiststwotemp.get(i));
                //  artiststwotemp.remove(artiststwotemp.get(i));
            }
        }
        for (int i = 0; i < artiststwotemp.size(); i++) {
            if (artiststwotemp.get(i).getArtistQuantity() == 0) {

                artistAdapter.remove(artiststwotemp.get(i));
                // artiststwotemp.remove(artiststwotemp.get(i));
            }
        }



        databaseArtistsqty.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artistsqty.clear();

                //iterating through all the nodes+
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist

                    Artistqty artist = postSnapshot.getValue(Artistqty.class);

                    artistsqty.add(artist);
                    Toast.makeText(getApplicationContext(),artistsqty.size()+ "count", Toast.LENGTH_LONG).show();

                }

            /*  for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    for (i=0; i <artiststwotemp.size(); i++) {

                        if (artiststwotemp.get(i).getArtistId().equals(postSnapshot.getValue(Artistqty.class).getArtistId())) {
                            artistsqty.get(i).setArtistQuantity(postSnapshot.getValue(Artistqty.class).getArtistQuantity() + artiststwotemp.get(i).getArtistQuantity());

                            Toast.makeText(getApplicationContext(), "if", Toast.LENGTH_LONG).show();
                          //  Toast.makeText(getApplicationContext(),artiststwotemp.get(i).getArtistQuantity()+ "", Toast.LENGTH_LONG).show();
                           Toast.makeText(getApplicationContext(),artistsqty.get(i).getArtistId()+ "if1", Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(), postSnapshot.getValue(Artistqty.class).getArtistId() +"if2", Toast.LENGTH_LONG).show();
                          //  Toast.makeText(getApplicationContext(), artiststwo.get(i).getArtistId()+ "", Toast.LENGTH_LONG).show();


                            Artistqty artistqty = new Artistqty(artistsqty.get(i).getArtistId(), artistsqty.get(i).getArtistName(), artistsqty.get(i).getArtistQuantity());
                            databaseArtistsqty.child(artistsqty.get(i).getArtistId()).setValue(artistqty);



                        }

                        else
                        {

                            Toast.makeText(getApplicationContext(), "else", Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(),artistsqty.get(i).getArtistId()+ "else1", Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(), postSnapshot.getValue(Artistqty.class).getArtistId() +"else2", Toast.LENGTH_LONG).show();
                            Artistqty artistqty = new Artistqty(artistsqty.get(i).getArtistId(), artistsqty.get(i).getArtistName(), artistsqty.get(i).getArtistQuantity());
                            databaseArtistsqty.child(artistsqty.get(i).getArtistId()).setValue(artistqty);


                        }
                        //  flag=1;
                        //x Toast.makeText(getApplicationContext(), artiststwotemp.get(i).getArtistId() + "", Toast.LENGTH_LONG).show();
                    }


                //  Toast.makeText(getApplicationContext(), postSnapshot.getValue(Artistqty.class).getArtistId()+"", Toast.LENGTH_LONG).show();
            }*/



//artiststhree=artiststwo;


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                recreate();
            }
        });





        listViewArtists9 = (ListView) findViewById(R.id.listViewArtiststhree);


        listViewArtists9.setAdapter(artistAdapter);



    }




}























   /* public void addqty() {

        databaseArtistsqty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artiststwo.clear();

                //iterating through all the nodes+
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artisttwo artist = postSnapshot.getValue(Artisttwo.class);

                    switch (postSnapshot.getKey()) {

                        case "Kk4eVAUhDorIyBt-KhN":


                    }
                    artiststwo.add(artist);

                }
//artiststhree=artiststwo;


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
        /*    switch(databaseArtiststwo.getKey())
            {

               case "Kk4eVAUhDorIyBt-KhN":
                  // gobi=artiststwotemp.get(0).artistQuantity+databaseArtistsqty.child("Kk4eVAUhDorIyBt-KhN").updateChildren()
                   gobi=artiststwotemp.get(0).artistQuantity+
            }

        }*/
//use cases for ids
    // qty+=qty;


  /*  public void addqty1() {


        databaseArtistsqty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artiststwo.clear();
                DatabaseReference dRtwo;
                String id;
                String name;
                int quantity;

                //iterating through all the nodes+
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artistqty artist = postSnapshot.getValue(Artistqty.class);

                    switch (1) {

                        case 1:
                            Toast.makeText(getApplicationContext(), "case 1.1", Toast.LENGTH_LONG).show();
                           dRtwo = FirebaseDatabase.getInstance().getReference("artiststhree").child("Kk59gHG9AxiJUYEHOA9");
                            id="Kk59gHG9AxiJUYEHOA9";
                         name="gobi";
                            artiststwotemp.get(0).setArtistQuantity(2);
                            Toast.makeText(getApplicationContext(), "case 1.2", Toast.LENGTH_LONG).show();
                           quantity=postSnapshot.getValue(Artistqty.class).getArtistQuantity()+artiststwotemp.get(0).getArtistQuantity();
                            Artistqty artistqty= new Artistqty(id, name, quantity);
                            Toast.makeText(getApplicationContext(), "quantity"+quantity, Toast.LENGTH_LONG).show();
                            dRtwo.setValue(artistqty);

                            Toast.makeText(getApplicationContext(), "case 1.4", Toast.LENGTH_LONG).show();

break;
                        case 2:
                             dRtwo = FirebaseDatabase.getInstance().getReference("artiststhree").child("Kk59nU2sDu3-v4JA-wP");
                            id="Kk59nU2sDu3-v4JA-wP";
                            name="masala";
                             quantity=postSnapshot.getValue(Artistqty.class).getArtistQuantity()+artiststwotemp.get(1).getArtistQuantity();
                             artistqty = new Artistqty(id, name, quantity);
                            dRtwo.setValue(artistqty);

break; */
                     //   default:
                //            Toast.makeText(getApplicationContext(), postSnapshot.getValue(Artistqty.class).getArtistId(), Toast.LENGTH_LONG).show();
                   // }


                //}
//artiststhree=artiststwo;


          //  }

         //   @Override
           // public void onCancelled(DatabaseError databaseError) {

       //     }
      //  });
    //}


