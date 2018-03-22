package com.mbds.appsmartfridge.oldentities;

/**
 * Created by rechi on 07/02/2017.
 */

public class Fridge {

    private String serial;
    private String association_key;

    private int temp_alert_min;
    private int temp_alert_max;
    private int hygro_alert_min;
    private int hygro_alert_max;
    private int open_alert_time;
    private int gas_alert_max;

    private boolean temp_alert_max_on;
    private boolean temp_alert_min_on;
    private boolean hygro_alert_on;
    private boolean gas_alert_on;
    private boolean open_alert_on;

    private int remind_me_after ; // seconde

    private String createdAt;
    private String updatedAt;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getAssociation_key() {
        return association_key;
    }

    public void setAssociation_key(String association_key) {
        this.association_key = association_key;
    }

    public int getTemp_alert_min() {
        return temp_alert_min;
    }

    public void setTemp_alert_min(int temp_alert_min) {
        this.temp_alert_min = temp_alert_min;
    }

    public int getTemp_alert_max() {
        return temp_alert_max;
    }

    public void setTemp_alert_max(int temp_alert_max) {
        this.temp_alert_max = temp_alert_max;
    }

    public int getHygro_alert_min() {
        return hygro_alert_min;
    }

    public void setHygro_alert_min(int hygro_alert_min) {
        this.hygro_alert_min = hygro_alert_min;
    }

    public int getHygro_alert_max() {
        return hygro_alert_max;
    }

    public void setHygro_alert_max(int hygro_alert_max) {
        this.hygro_alert_max = hygro_alert_max;
    }

    public int getOpen_alert_time() {
        return open_alert_time;
    }

    public void setOpen_alert_time(int open_alert_time) {
        this.open_alert_time = open_alert_time;
    }

    public int getGas_alert_max() {
        return gas_alert_max;
    }

    public void setGas_alert_max(int gas_alert_max) {
        this.gas_alert_max = gas_alert_max;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isTemp_alert_max_on() {
        return temp_alert_max_on;
    }

    public void setTemp_alert_max_on(boolean temp_alert_max_on) {
        this.temp_alert_max_on = temp_alert_max_on;
    }

    public boolean isTemp_alert_min_on() {
        return temp_alert_min_on;
    }

    public void setTemp_alert_min_on(boolean temp_alert_min_on) {
        this.temp_alert_min_on = temp_alert_min_on;
    }

    public boolean isHygro_alert_on() {
        return hygro_alert_on;
    }

    public void setHygro_alert_on(boolean hygro_alert_on) {
        this.hygro_alert_on = hygro_alert_on;
    }

    public boolean isGas_alert_on() {
        return gas_alert_on;
    }

    public void setGas_alert_on(boolean gas_alert_on) {
        this.gas_alert_on = gas_alert_on;
    }

    public boolean isOpen_alert_on() {
        return open_alert_on;
    }

    public void setOpen_alert_on(boolean open_alert_on) {
        this.open_alert_on = open_alert_on;
    }

    public int getRemind_me_after() {
        return remind_me_after;
    }

    public void setRemind_me_after(int remind_me_after) {
        this.remind_me_after = remind_me_after;
    }

    @Override
    public String toString() {
        return getAssociation_key() + " " +getId() + "  " + getTemp_alert_max() + " " + getTemp_alert_min() ;
    }
}
