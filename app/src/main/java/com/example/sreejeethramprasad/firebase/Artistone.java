package com.example.sreejeethramprasad.firebase;

/**
 * Created by Vishvajith Ramprasad on 03-05-2017.
 */

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by Belal on 2/26/2017.
 */
@IgnoreExtraProperties
public class Artistone {
    private String artistId;
    private String artistName;
    private String artistGenre;
    private int artistPrice;

    public Artistone() {
        //this constructor is required
    }


    public Artistone(String artistId, String artistName, int artistPrice) {
        this.artistId = artistId;
        this.artistName = artistName;
        //this.artistGenre = artistGenre;
        this.artistPrice = artistPrice;
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
    public int getArtistPrice() {
        return artistPrice;
    }
}