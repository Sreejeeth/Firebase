package com.example.sreejeethramprasad.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Vishvajith Ramprasad on 12-05-2017.
 */

@IgnoreExtraProperties
public class Artistthree {
    private String artistId;
    private String artistName;
    private String artistGenre;
    private int artistQuantity;

    public Artistthree() {
        //this constructor is required
    }


    public Artistthree(String artistId, String artistName, int artistQuantity) {
        this.artistId = artistId;
        this.artistName = artistName;
        //this.artistGenre = artistGenre;
        this.artistQuantity = artistQuantity;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    //public String getArtistGenre() {
    // return artistGenre;
    //  }
    public int getArtistQuantity() {
        return artistQuantity;
    }
}