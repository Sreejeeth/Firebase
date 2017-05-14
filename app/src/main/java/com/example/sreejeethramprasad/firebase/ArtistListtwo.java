package com.example.sreejeethramprasad.firebase;

/**
 * Created by Vishvajith Ramprasad on 03-05-2017.
 */

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.sreejeethramprasad.firebase.R.id.TextViewQuantity;
import static com.example.sreejeethramprasad.firebase.R.id.buttonAddArtist;
import static com.example.sreejeethramprasad.firebase.R.id.editTextName;
import static com.example.sreejeethramprasad.firebase.R.id.editTextPrice;
import static com.example.sreejeethramprasad.firebase.R.id.textView;
import static com.example.sreejeethramprasad.firebase.R.id.textViewName;
import static com.example.sreejeethramprasad.firebase.R.id.textViewPrice;

/**
 * Created by Belal on 2/26/2017.
 */

public class ArtistListtwo extends ArrayAdapter<Artisttwo> {

    private Activity context;
    TextView textViewQuantity ;
    List<Artisttwo> artists;
    EditText editTextName;
    Button button;
    DatabaseReference   databaseArtiststhree;
   // ArrayList<Artisttwo> artiststwo;
    ListView listViewArtists7;




    public ArtistListtwo(Activity context, List<Artisttwo> artists) {
        super(context, R.layout.list_layout_two, artists);
        this.context = context;
        this.artists = artists;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final ViewHolder holder;
        databaseArtiststhree = FirebaseDatabase.getInstance().getReference("artiststhree");


       // databaseArtiststhree = FirebaseDatabase.getInstance().getReference("artiststhree");
     //   editTextName = (EditText) findViewById(R.id.editTextName);

        if (convertView == null) {


          //  databaseArtiststfour = FirebaseDatabase.getInstance().getReference("artistsfour");
           // String name = editTextName.getText().toString().trim();
            //  String genre = spinnerGenre.getSelectedItem().toString();

            holder = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_layout_two, null, true);

            holder.textViewName = (TextView) convertView.findViewById(R.id.textViewNameone);
            holder.textViewQuantity = (TextView) convertView.findViewById(R.id.TextViewQuantity);
            holder.textViewPrice = (TextView) convertView.findViewById(R.id.textViewPrice);
            holder.buttonplus = (Button) convertView.findViewById(R.id.buttonplus);
            holder.buttonminus = (Button) convertView.findViewById(R.id.buttonminus);
            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textViewName.setText(MainActivityone.artiststwo.get(position).getArtistName());
        holder.textViewQuantity.setText(String.valueOf(MainActivityone.artiststwo.get(position).getArtistQuantity()));
        holder.textViewPrice.setText(String.valueOf(MainActivityone.artiststwo.get(position).getArtistPrice()));


        holder.buttonplus.setTag(R.integer.btn_plus_view, convertView);
        holder.buttonplus.setTag(R.integer.btn_plus_pos, position);
        holder.buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View tempview = (View) holder.buttonplus.getTag(R.integer.btn_plus_view);
                TextView tv = (TextView) tempview.findViewById(R.id.TextViewQuantity);
                Integer pos = (Integer) holder.buttonplus.getTag(R.integer.btn_plus_pos);

                int number = Integer.parseInt(tv.getText().toString()) + 1;

                tv.setText(String.valueOf(number));

                MainActivityone.artiststwo.get(pos).setArtistQuantity(number);

            }
        });

        holder.buttonminus.setTag(R.integer.btn_minus_view, convertView);
        holder.buttonminus.setTag(R.integer.btn_minus_pos, position);
        holder.buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View tempview = (View) holder.buttonminus.getTag(R.integer.btn_minus_view);
                TextView tv = (TextView) tempview.findViewById(R.id.TextViewQuantity);
                Integer pos = (Integer) holder.buttonminus.getTag(R.integer.btn_minus_pos);

                int number = Integer.parseInt(tv.getText().toString()) - 1;
                if(number<0)
                {
                    Toast.makeText(getContext(), "Quantity cannot go below 1!",
                            Toast.LENGTH_LONG).show();
                    number=0;
                }


                tv.setText(String.valueOf(number));

                MainActivityone.artiststwo.get(pos).setArtistQuantity(number);
            //    MainActivityone.artiststwo.set(pos,artists.get(pos)).setArtistQuantity(number);

//tv.setText(number+"");

            }
        });
          /*  LayoutInflater inflater = context.getLayoutInflater();
            View listViewItemone = inflater.inflate(R.layout.list_layout_two, null, true);
Artistthree artist3=new Artistthree(id,name,artist2.getArtistQuantity());
            TextView textViewName = (TextView) listViewItemone.findViewById(R.id.textViewNameone);
            TextView textViewPrice = (TextView) listViewItemone.findViewById(textViewPrice);
            TextView textViewQuantity = (TextView) listViewItemone.findViewById(R.id.TextViewQuantity);
            Artisttwo artist = artists.get(position);


            textViewName.setText(artist.getArtistName());
            textViewQuantity.setText(artist.getArtistQuantity() + "");
            textViewPrice.setText(artist.getArtistPrice() + "");

            return listViewItemone;*/
        return convertView;
        }



    private class ViewHolder {

        protected Button buttonplus, buttonminus;
        private TextView textViewName, textViewQuantity,textViewPrice;

    }


}
// work on quantitypage thing