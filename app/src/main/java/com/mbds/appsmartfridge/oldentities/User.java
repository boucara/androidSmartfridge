package com.mbds.appsmartfridge.oldentities;

/**
 * Created by kccrocher on 12/03/2017.
 */

public class User {


    private String serial;
    private String gcm_key;
    private String createdAt;
    private String updatedAt;
    private String id;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getGcm_key() {
        return gcm_key;
    }

    public void setGcm_key(String gcm_key) {
        this.gcm_key = gcm_key;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
