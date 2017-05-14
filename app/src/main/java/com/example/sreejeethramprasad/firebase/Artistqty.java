package com.example.sreejeethramprasad.firebase;

import java.io.Serializable;

/**
 * Created by Vishvajith Ramprasad on 13-05-2017.
 */

public class Artistqty  {
    private String artistId;
    private String artistName;
    private int artistQuantity;

    public Artistqty(){
        //this constructor is required
    }

    public Artistqty(String artistId, String artistName, int artistQuantity) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistQuantity= artistQuantity;
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
    public void setArtistQuantity(int artistQuantity) {
        this. artistQuantity=artistQuantity;
    }
    public void setArtistId(String artistid) {
        this. artistId=artistid;
    }
    public void setArtistName(String artistName) {
        this. artistName=artistName;
    }
}