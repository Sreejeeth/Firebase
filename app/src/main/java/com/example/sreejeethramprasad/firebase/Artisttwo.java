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
public class Artisttwo extends Artistone implements Serializable {
    private String artistId;
   private String artistName;
  //  private String artistGenre;

public int  artistQuantity;
    private int artistPrice;
    public Artisttwo() {
        //this constructor is required
    }


    public Artisttwo(String artistId,String artistName,int artistPrice,int  artistQuantity) {
       this.artistId = artistId;
        this.artistName = artistName;
        this.artistQuantity = artistQuantity;
        this.artistPrice = artistPrice;
    }

   public String getArtistId() {
       return artistId;
    }


  public String getArtistName() {
        return artistName;
  }
    public int getArtistPrice() {
        return artistPrice;
    }

    public  int getArtistQuantity() {
    return artistQuantity;
     }
    public void setArtistQuantity(int  artistQuantity) {
        this.artistQuantity=artistQuantity;
    }
    public void setArtistId(String  artistId) {
        this.artistId=artistId;
    }

    public void setArtistPrice(int  artistPrice) {
        this.artistPrice=artistPrice;
    }

    public void setArtistName(String artistName) {
        this.artistName=artistName;
    }


}