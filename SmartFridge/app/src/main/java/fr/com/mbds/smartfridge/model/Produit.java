package fr.com.mbds.smartfridge.model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;


/**
 * Created by jperk on 03/12/2017.
 */

public class Produit implements Serializable {
    public String nom;
    public String cat;
    public transient Bitmap image;
    Date date_ajout;

    public Produit(String _n, String _c){
        this.nom=_n;
        this.cat=_c;
        this.date_ajout=Calendar.getInstance().getTime();
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

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
