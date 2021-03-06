package com.mbds.appsmartfridge.model;

import android.graphics.Bitmap;

import com.mbds.appsmartfridge.oldentities.Fridge;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by jperk on 03/12/2017.
 */

public class Frigo implements Serializable {
    public int id;
    public String frigoName;
    public String frigoStatus;
    public String nom;
    public transient Bitmap image;
    public int temperature;
    public int humidite;
    Date date_achat;
    public String decomposition;
    public String garantie;
    public String dimensions;
    public String marque;
    private ConfigAlertes conf;

    public Frigo(Fridge fridge){
        conf = new ConfigAlertes(fridge.getGas_alert_max(), fridge.getTemp_alert_min(), fridge.getTemp_alert_max(), fridge.getHygro_alert_max(), fridge.getOpen_alert_time(), fridge.isGas_alert_on(), fridge.isOpen_alert_on(), fridge.isTemp_alert_min_on(), fridge.isTemp_alert_max_on(), fridge.isHygro_alert_on(), fridge.getRemind_me_after());
        frigoName=fridge.getSerial();
    }

    public Frigo(int id, String frigonom,String frigoStatus, int temperature, int humidite, String decomposition, String garantie, String dimensions, String marque) {
        this.id=id;
        this.frigoName=frigonom;
        this.frigoStatus = frigoStatus;
        this.temperature = temperature;
        this.humidite = humidite;
        this.date_achat = Calendar.getInstance().getTime();
        this.decomposition = decomposition;
        this.garantie = garantie;
        this.dimensions = dimensions;
        this.marque = marque;
    }

    public ConfigAlertes getConf() {
        return conf;
    }

    public void setConf(ConfigAlertes conf) {
        this.conf = conf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrigoName() {
        return frigoName;
    }

    public String getFrigoStatus() {
        return frigoStatus;
    }

    public String getNom() {
        return nom;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setFrigoName(String frigoName) {
        this.frigoName = frigoName;
    }

    public void setFrigoStatus(String frigoStatus) {
        this.frigoStatus = frigoStatus;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidite() {
        return humidite;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public String getDecomposition() {
        return decomposition;
    }

    public String getGarantie() {
        return garantie;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHumidite(int humidite) {
        this.humidite = humidite;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

    public void setDecomposition(String decomposition) {
        this.decomposition = decomposition;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
