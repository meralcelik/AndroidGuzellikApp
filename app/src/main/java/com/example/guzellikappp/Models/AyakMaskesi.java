package com.example.guzellikappp.Models;

import java.io.Serializable;

public class AyakMaskesi implements Serializable {


    private int imageID;
    private String baslik;
    private String Hazirlanisi;
    private String malzemeler;
    private  String aciklama;

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getAciklama() {
        return aciklama;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setHazirlanisi(String hazirlanisi) {
        Hazirlanisi = hazirlanisi;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }



    public int getImageID() {
        return imageID;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getHazirlanisi() {
        return Hazirlanisi;
    }
    }

