package com.mbds.appsmartfridge.oldentities;

import java.util.Date;

/**
 * Created by rechi on 07/02/2017.
 */

public class Measures {
    private String owner;
    private double temp_1;
    private double temp_2;
    private double temp_3;
    private double hygro;
    private double gas;
    private boolean open;
    private String createdAt;
    private String updatedAt;
    private String id;

    public Measures(){
        createdAt = new Date().toString();
        updatedAt = createdAt;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getTemp_1() {
        return temp_1;
    }

    public void setTemp_1(double temp_1) {
        this.temp_1 = temp_1;
    }

    public double getTemp_2() {
        return temp_2;
    }

    public void setTemp_2(double temp_2) {
        this.temp_2 = temp_2;
    }

    public double getTemp_3() {
        return temp_3;
    }

    public void setTemp_3(double temp_3) {
        this.temp_3 = temp_3;
    }

    public double getHygro() {
        return hygro;
    }

    public void setHygro(double hygro) {
        this.hygro = hygro;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
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

    public double getMinTemp(){
        return Math.min(Math.min(temp_1, temp_2), temp_3);
    }

    public double getMiddleTemp(){
        return (temp_1 + temp_2 + temp_3) / 3;
    }

    public double getMaxTemp(){
        return Math.max(Math.max(temp_1, temp_2), temp_3);
    }

}
