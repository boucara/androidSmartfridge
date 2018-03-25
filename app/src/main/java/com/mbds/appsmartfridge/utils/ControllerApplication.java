package com.mbds.appsmartfridge.utils;

import com.mbds.appsmartfridge.model.Frigo;
import com.mbds.appsmartfridge.oldentities.Measures;

import java.util.List;

/**
 * Created by Tom on 22/03/2018.
 */

public class ControllerApplication {

    private static ControllerApplication lock;
    private Frigo actualFrigo;

    public List<Measures> getMesuresList() {
        return mesuresList;
    }

    public void setMesuresList(List<Measures> mesuresList) {
        this.mesuresList = mesuresList;
    }

    private List<Measures> mesuresList;

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

    public void setMesuresFrigo(Measures measures) {
        actualFrigo.setTemperature((int)measures.getTemp_1());
        actualFrigo.setHumidite((int)measures.getHygro());
        actualFrigo.setDecomposition(""+(int)measures.getGas());
        actualFrigo.setFrigoStatus("Connecté");
    }
}
