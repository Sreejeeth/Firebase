package com.example.sreejeethramprasad.firebase;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by Vishvajith Ramprasad on 15-05-2017.
 */
@IgnoreExtraProperties
public class Artistfive implements Serializable {
    private String artistId;
    private String artistName;
    private int artistQuantity;

    public Artistfive(){
        //this constructor is required
    }

    public Artistfive(String artistId, String artistName, int artistQuantity) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistQuantity = artistQuantity;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getArtistQuantity() {
        return artistQuantity;
    }
}