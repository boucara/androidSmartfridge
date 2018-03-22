package com.mbds.appsmartfridge.oldentities;

/**
 * Created by kccrocher on 22/03/2017.
 */

public class ValueEvent {

    private double value;
    private String type;

    public ValueEvent(String type , int value){
        this.type = type;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
