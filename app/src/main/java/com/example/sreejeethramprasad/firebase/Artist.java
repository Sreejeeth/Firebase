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
public class Artist implements Serializable {
    private String artistId;
    private String artistName;
    private String artistGenre;

    public Artist(){
        //this constructor is required
    }

    public Artist(String artistId, String artistName, String artistGenre) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }
}