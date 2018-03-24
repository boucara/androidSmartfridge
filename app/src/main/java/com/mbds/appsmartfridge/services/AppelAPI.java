package com.mbds.appsmartfridge.services;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.mbds.appsmartfridge.model.ConfigAlertes;
import com.mbds.appsmartfridge.model.Frigo;
import com.mbds.appsmartfridge.oldentities.Event;
import com.mbds.appsmartfridge.oldentities.Fridge;
import com.mbds.appsmartfridge.oldentities.Measures;
import com.mbds.appsmartfridge.oldentities.User;
import com.mbds.appsmartfridge.utils.ControllerApplication;
import com.mbds.appsmartfridge.utils.LockEssaie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rechi on 07/02/2017.
 * Updated by Tom on 22/03/2017
 */

public class AppelAPI {

    APIService apiService;

    public AppelAPI(Frigo fridge){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public void getMeasures(String serial){
        LockEssaie.getInstance().lock();
        Call<List<Measures>> measures = apiService.Get_Fridge_Measures(serial,"2018-03-22T04:12:05.000Z","2018-03-23T04:12:05.000Z");
        getMeasures(measures,null);
        System.out.println(" API _  getMeasures " + serial + "  "+ LockEssaie.getInstance().isLocked());
    }

    public void getMeasures(String serial,Handler handler , String from , String to){
        LockEssaie.getInstance().lock();
        Call<List<Measures>> measures = apiService.Get_Fridge_Measures("dev",from,to);
        getMeasures(measures,handler);
        System.out.println(" API _  getMeasures " + serial + "  "+ LockEssaie.getInstance().isLocked());
    }

    private void getMeasures(Call<List<Measures>> measures, final Handler handler){
        measures.enqueue(new Callback<List<Measures>>() {
            @Override
            public void onResponse(Call<List<Measures>> call, Response<List<Measures>> response) {
                System.out.println("RESPONSE ");
                List<Measures> measures = response.body();

                ControllerApplication control = ControllerApplication.getInstance();
                control.setMesuresList(measures);
                if(handler != null) {
                    System.out.println("----HANDLER----");
                    Message msg = handler.obtainMessage();
                    Bundle b = new Bundle();
                    b.putInt("state", 1);
                    msg.setData(b);
                    handler.sendMessage(msg);
                }
                if(measures != null) {
                    System.out.println(" API _  getMeasures " + measures.size());
                }
                LockEssaie.getInstance().unlock();
            }

            @Override
            public void onFailure(Call<List<Measures>> call, Throwable t) {
                System.out.println("API _  getMeasures FAILURE - " + t);
            }
        });
    }

    public void updateFridge(String serial){


        System.out.println("--- SERIAL ---- " + serial);

        ControllerApplication control = ControllerApplication.getInstance();
        ConfigAlertes conf = control.getActualFrigo().getConf();
        System.out.println("GAZ " + conf.getGas_alert_max());
        Call<Fridge> repos = apiService.updateFridge(serial,
                conf.getTemp_alert_min(),
                conf.getTemp_alert_max(),
                conf.getHydro_alert_max(),
                conf.getHopen_alert_time(),
                conf.getGas_alert_max(),
                conf.isGas_alert_on(),
                conf.isOpen_alert_on(),
                conf.isTemp_alert_min_on(),
                conf.isTemp_alert_max_on(),
                conf.isHygro_alert_on(),
                conf.getRemind_me_after());

        repos.enqueue(new Callback<Fridge>() {
            @Override
            public void onResponse(Call<Fridge> call, Response<Fridge> response) {
                Fridge f = response.body();
                System.out.println("----- MAJ OK -----" + f.getGas_alert_max());
            }

            @Override
            public void onFailure(Call<Fridge> call, Throwable t) {
                System.err.println("----- MAJ NOK ----- " );
                t.printStackTrace();
            }
        });
    }

    public void createFridge(String serial){

        Call<Fridge> repos = apiService.createFridge(serial);
        repos.enqueue(new Callback<Fridge>() {
            @Override
            public void onResponse(Call<Fridge> call, Response<Fridge> response) {
                Fridge frigo = response.body();
//                ControleurFridge control = ControleurFridge.getInstance();
//                control.setFridge((Fridge) frigo);
                System.out.println("CREATION FRIGO  " + frigo);
            }

            @Override
            public void onFailure(Call<Fridge> call, Throwable t) {
                System.err.println("Error");
                t.printStackTrace();
            }
        });
    }

    public void getDataSensors(String serial){
        Call<Measures> repos = apiService.Get_Fridge_Measures_last(serial);
        repos.enqueue(new Callback<Measures>() {
            @Override
            public void onResponse(Call<Measures> call, Response<Measures> response) {
                System.out.println("sendDataSensors success");
            }

            @Override
            public void onFailure(Call<Measures> call, Throwable t) {
                System.err.println("sendDataSensors failed");
                t.printStackTrace();
            }
        });
    }

    public void getEvents(String serial, final Handler handle , String from , String to){
        System.out.println("API_GetAlertes : " +  from + "  " + to);

        Call<List<Event>> ev = apiService.Get_Fridge_Events(serial, from , to);
        ev.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
//                ControleurFridge.getInstance().setEvents((List<Event>) response.body());
                System.out.println("API_GetAlertes RESPONSE : " + response.body());
                Message msg = handle.obtainMessage();
                Bundle b = new Bundle();
                b.putInt("state", 1);
                msg.setData(b);
                handle.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                System.err.println("Error");
                t.printStackTrace();
            }
        });
    }

    public void sendEvent(String serial, Event event) {
        Call<Event> ev = apiService.sendEvents(serial, event);
        ev.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                System.out.println("event up");
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                System.err.println("Error");
                t.printStackTrace();
            }
        });
    }

    public void getUsers(String serial, final Handler handel) {

        Call<List<User>> ev = apiService.Get_Fridge_Users(serial);
        ev.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

//                ControleurFridge.getInstance().setUsers((List<User>) response.body());
                Message msg = handel.obtainMessage();
                Bundle b = new Bundle();
                b.putInt("state", 1);
                msg.setData(b);
                handel.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.err.println("Error");
                t.printStackTrace();
            }
        });
    }
}
