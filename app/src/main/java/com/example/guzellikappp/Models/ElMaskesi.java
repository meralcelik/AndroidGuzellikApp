package com.example.guzellikappp.Models;
import java.io.Serializable;

public class ElMaskesi implements Serializable {

    private int imageID;
    private String baslik;
    private String malzemeler;

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setMalzemeler(String malzemeler) {
        this.malzemeler = malzemeler;
    }

    public void setHazirlanisi(String hazirlanisi) {
        this.hazirlanisi = hazirlanisi;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    private String hazirlanisi;

    public int getImageID() {
        return imageID;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getMalzemeler() {
        return malzemeler;
    }

    public String getHazirlanisi() {
        return hazirlanisi;
    }

    public String getAciklama() {
        return aciklama;
    }

    private  String aciklama;


}
