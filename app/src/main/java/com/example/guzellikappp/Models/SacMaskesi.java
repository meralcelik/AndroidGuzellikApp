package com.example.guzellikappp.Models;

import java.io.Serializable;

public class SacMaskesi implements Serializable {
    private int imageID;
    private String baslik;
    private String malzemeler;

    public void setMalzeme(String malzeme) {
        this.malzemeler = malzeme;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public String getHazirlanisi() {
        return Hazirlanisi;
    }


    public void setHazirlanisi(String hazirlanisi) {
        Hazirlanisi = hazirlanisi;
    }

    private String Hazirlanisi;


    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getBaslik() {
        return baslik;

    }


}