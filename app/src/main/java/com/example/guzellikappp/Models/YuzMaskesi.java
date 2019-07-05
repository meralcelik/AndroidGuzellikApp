package com.example.guzellikappp.Models;

import java.io.Serializable;

public class YuzMaskesi implements Serializable {

    private int imageID;
    private String baslik;




//    public YuzMaskesi(Resources res) {
//        this.res = res;


  

    public String getCiltTipi() {
        return ciltTipi;
    }

    public String getEtkisi() {
        return Etkisi;
    }

    public String getHazirlanisi() {
        return Hazirlanisi;
    }

    private String ciltTipi;
    private String Etkisi;

    public void setCiltTipi(String ciltTipi) {
        this.ciltTipi = ciltTipi;
    }

    public void setEtkisi(String etkisi) {
        Etkisi = etkisi;
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