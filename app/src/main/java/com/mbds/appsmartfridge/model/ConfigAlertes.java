package com.mbds.appsmartfridge.model;

/**
 * Created by Tom on 22/03/2018.
 */

public class ConfigAlertes {
    int gas_alert_max;
    int temp_alert_min;
    int temp_alert_max;
    int hydro_alert_max;
    int hopen_alert_time;
    boolean gas_alert_on;
    boolean open_alert_on;
    boolean temp_alert_min_on;
    boolean temp_alert_max_on;
    boolean hygro_alert_on;
    int remind_me_after;

    public int getGas_alert_max() {
        return gas_alert_max;
    }

    public void setGas_alert_max(int gas_alert_max) {
        this.gas_alert_max = gas_alert_max;
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

    public int getHydro_alert_max() {
        return hydro_alert_max;
    }

    public void setHydro_alert_max(int hydro_alert_max) {
        this.hydro_alert_max = hydro_alert_max;
    }

    public int getHopen_alert_time() {
        return hopen_alert_time;
    }

    public void setHopen_alert_time(int hopen_alert_time) {
        this.hopen_alert_time = hopen_alert_time;
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

    public boolean isTemp_alert_min_on() {
        return temp_alert_min_on;
    }

    public void setTemp_alert_min_on(boolean temp_alert_min_on) {
        this.temp_alert_min_on = temp_alert_min_on;
    }

    public boolean isTemp_alert_max_on() {
        return temp_alert_max_on;
    }

    public void setTemp_alert_max_on(boolean temp_alert_max_on) {
        this.temp_alert_max_on = temp_alert_max_on;
    }

    public boolean isHygro_alert_on() {
        return hygro_alert_on;
    }

    public void setHygro_alert_on(boolean hygro_alert_on) {
        this.hygro_alert_on = hygro_alert_on;
    }

    public int getRemind_me_after() {
        return remind_me_after;
    }

    public void setRemind_me_after(int remind_me_after) {
        this.remind_me_after = remind_me_after;
    }
}
