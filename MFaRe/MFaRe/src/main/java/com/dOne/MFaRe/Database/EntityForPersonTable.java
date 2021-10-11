package com.dOne.MFaRe.Database;

public class EntityForPersonTable {
    private int id;
    private String ad;
    private String soyad;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EntityForPersonTable{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
}
