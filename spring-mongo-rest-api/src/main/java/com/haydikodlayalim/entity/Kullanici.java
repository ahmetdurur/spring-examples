package com.haydikodlayalim.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
public class Kullanici {
    @Id
    private String id;
    private String ad;
    private String soyadi;
    private HashMap ozellikleri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public HashMap getOzellikleri() {
        return ozellikleri;
    }

    public void setOzellikleri(HashMap ozellikleri) {
        this.ozellikleri = ozellikleri;
    }
}
