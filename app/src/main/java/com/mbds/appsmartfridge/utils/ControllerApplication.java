package com.mbds.appsmartfridge.utils;

import com.mbds.appsmartfridge.model.Frigo;

/**
 * Created by Tom on 22/03/2018.
 */

public class ControllerApplication {

    private static ControllerApplication lock;
    private Frigo actualFrigo;

    public static ControllerApplication getInstance(){
        if(lock == null){
            lock = new ControllerApplication();
        }
        return lock;
    }

    public Frigo getActualFrigo() {
        return actualFrigo;
    }

    public void setActualFrigo(Frigo actualFrigo) {
        this.actualFrigo = actualFrigo;
    }

}
