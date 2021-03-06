package com.example.sreejeethramprasad.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.app.AlertDialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.os.Build.VERSION_CODES.M;
import static com.example.sreejeethramprasad.firebase.R.id.editText;
import static com.example.sreejeethramprasad.firebase.R.id.editTextPrice;
import static com.example.sreejeethramprasad.firebase.R.id.editTextPrice;
import static com.example.sreejeethramprasad.firebase.R.id.listViewArtists;
import static com.example.sreejeethramprasad.firebase.R.id.listViewArtists1;

/**
 * Created by Vishvajith Ramprasad on 05-05-2017.
 */
public class MainActivityone extends AppCompatActivity {

    //we will use these constants later to pass the artist name and id to another activity
    public static final String ARTIST_NAME = "net.simplifiedcoding.firebasedatabaseexample.artistname";
    public static final String ARTIST_ID = "net.simplifiedcoding.firebasedatabaseexample.artistid";

    //view objects
    EditText editTextName;
    EditText editTextPrice;
    Spinner spinnerGenre;
    Button buttonAddArtist;
    ListView listViewArtists8;
    ListView listViewArtists5;
    ListView listViewArtists7;
    Button button;
    //a list to store all the artist from firebase database
    ArrayList<Artistone> artistsone;
    Artisttwo artist2;

    public static ArrayList<Artisttwo> artiststwo;
 ArrayList<Artistthree> artiststhree;

//our database reference object
   DatabaseReference databaseArtistsfour;
    DatabaseReference databaseArtiststwo;
    DatabaseReference databaseArtiststhree;
   public static DatabaseReference databaseArtistsqty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);

        //getting the reference of artists node
        // databaseArtists = FirebaseDatabase.getInstance().getReference("artists");

        databaseArtiststwo = FirebaseDatabase.getInstance().getReference("artiststwo");
        databaseArtiststhree = FirebaseDatabase.getInstance().getReference("artiststhree");
        databaseArtistsqty=FirebaseDatabase.getInstance().getReference("artistqty");
    //    databaseArtistsfour = FirebaseDatabase.getInstance().getReference("artistsfour");
        //getting views

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
      //  spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
        // listViewArtists3 = (ListView) findViewById(listViewArtists1);
        listViewArtists5 = (ListView) findViewById(R.id.listViewArtistsone);
        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtistone);
        button = (Button) findViewById(R.id.order);
        listViewArtists7= (ListView) findViewById(R.id.listViewArtiststwo);
        listViewArtists8= (ListView) findViewById(R.id.listViewArtiststhree);


        //list to store artists
        artistsone = new ArrayList<>();
       artiststwo = new ArrayList<>();

        for(int i=0;i<artiststwo.size();i++)
            artiststwo.get(i).setArtistQuantity(0);
     //   artiststhree = new ArrayList<>();

        //adding an onclicklistener to button
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation

                addArtist();

            }
        });

       listViewArtists5.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

               Artistone artist = artistsone.get(i);
                showUpdateDeleteDialog(artist.getArtistId(), artist.getArtistName());

               return true;
           }
       });
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation

               Intent intent = new Intent(MainActivityone.this, Canteenownerpage2.class);
startActivity(intent);
            }
        });


    }

    public  static void count(String id,String name,int qty)
    {
        Artistqty artistqty = new Artistqty(id, name, qty);
        databaseArtistsqty.child(id).setValue(artistqty);

    }

    // Artisttwo artist2=artiststwo.get(i);
//showUpdateDeleteDialog(artist2.getArtistId(), artist2.getArtistName());
    @Override
    protected void onStart() {
        //recreate();
        super.onStart();

        //attaching value event listener
        databaseArtiststwo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                artistsone.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Artistone artist = postSnapshot.getValue(Artistone.class);
                    //adding artist to the list
                    artistsone.add(artist);

                }

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // // // // // ArtistListCanteen artistAdapter = new ArtistListCanteen(MainActivityCanteen.this, artists1);
        ArtistListone artistAdapter = new ArtistListone(MainActivityone.this, artistsone);
        //attaching adapter to the listview
        listViewArtists5.setAdapter(artistAdapter);

    }

    /*s
    * This method is saving a new artist to the
    * Firebase Realtime Database
    * */
    private void addArtist() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();

        //  String genre = spinnerGenre.getSelectedItem().toString();
        int price = Integer.parseInt(editTextPrice.getText().toString());
        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtiststwo.push().getKey();
           // String id= databaseArtiststhree.push().getKey();

            //creating an Artist Object
            Artistone artist = new Artistone(id, name, price);

           Artistqty artistqty = new Artistqty(id, name, 0);


            // artist2=new Artisttwo(id,name,price,1);
//Artistthree artist3=new Artistthree(id,name,artist2.getArtistQuantity());
            //Saving the Artist
            databaseArtiststwo.child(id).setValue(artist);
          databaseArtistsqty.child(id).setValue(artistqty);
          //  databaseArtistsfour.child(id).setValue(artist3);

            //setting edittext to blank again
            editTextName.setText("");
            editTextPrice.setText("");
            recreate();
            //displaying a success toast
            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
    private boolean updateArtist(String id, String name, int price) {
        //getting the specified artist reference
        DatabaseReference dRone = FirebaseDatabase.getInstance().getReference("artiststwo").child(id);
        DatabaseReference dRtwo = FirebaseDatabase.getInstance().getReference("artiststhree").child(id);

        //updating artist
        Artistone artist = new Artistone(id, name, price);
        Artisttwo artist2=new Artisttwo(id,name,price,0);
        dRone.setValue(artist);
        dRtwo.setValue(artist2);
        recreate();
        Toast.makeText(getApplicationContext(), "Artist Updated", Toast.LENGTH_LONG).show();
        return true;
    }
    private void showUpdateDeleteDialog(final String artistId, String artistName) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final EditText editTextPrice=(EditText) dialogView.findViewById(R.id.editTextPrice);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateArtist);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteArtist);

        dialogBuilder.setTitle(artistName   );
        final AlertDialog b = dialogBuilder.create();
        b.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                int price = Integer.parseInt(editTextPrice.getText().toString());
                if (!TextUtils.isEmpty(name)) {
                    updateArtist(artistId, name, price);
                    b.dismiss();
                }
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                * we will code this method to delete the artist
                * */
                buttonDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        deleteArtist(artistId);
                        b.dismiss();
                    }
               });

           }
        });
    }
    private boolean deleteArtist(String id) {
        //getting the specified artist reference
       DatabaseReference dRone = FirebaseDatabase.getInstance().getReference("artiststwo").child(id);
        DatabaseReference dRtwo = FirebaseDatabase.getInstance().getReference("artiststhree").child(id);

      //  removing artist
        dRone.removeValue();
dRtwo.removeValue();
recreate();



        Toast.makeText(getApplicationContext(), "Artist Deleted", Toast.LENGTH_LONG).show();

       return true;
   }


}