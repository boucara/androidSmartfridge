package com.mbds.appsmartfridge.model;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by jperk on 03/12/2017.
 */

public class Produit implements Serializable {
    public int id;
    public int belongsTo;
    public String nom;
    public String cat;
    public transient Bitmap image;
    String date_ajout;
    public Produit(){}

    public Produit(int id, int belongs, String _n, String _c){
        this.id=id;
        this.nom=_n;
        this.cat=_c;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        this.date_ajout=currentDateandTime;
        this.belongsTo=belongs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(int belongsTo) {
        this.belongsTo = belongsTo;
    }

    public String getNom() {
        return nom;
    }

    public String getCat() {
        return cat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }


}
