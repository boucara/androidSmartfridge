package com.mbds.appsmartfridge.services;

import com.mbds.appsmartfridge.oldentities.Event;
import com.mbds.appsmartfridge.oldentities.Fridge;
import com.mbds.appsmartfridge.oldentities.Measures;
import com.mbds.appsmartfridge.oldentities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rechi on 07/02/2017.
 * Updated by Tom on 22/03/2018
 */

public interface APIService {

    public static final String ENDPOINT = "http://192.168.1.11:1337";

    @GET("/fridges/{serial}")
    void getFridge(@Path("serial") String serial, Callback<Fridge> callback);

    //@Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("/fridges")
    Call<Fridge> createFridge(@Field("serial") Object serial);

    @FormUrlEncoded
    @PUT("/fridges/{serial}")
    Call<Fridge> updateFridge(@Path("serial") String serial,
                              @Field("temp_alert_min") int value,
                              @Field("temp_alert_max") int value2,
                              @Field("hygro_alert_max") int value3,
                              @Field("open_alert_time") int value4,
                              @Field("gas_alert_max") int value5,
                              @Field("gas_alert_on") boolean value6,
                              @Field("open_alert_on") boolean value7,
                              @Field("temp_alert_min_on") boolean value8,
                              @Field("temp_alert_max_on") boolean value9,
                              @Field("hygro_alert_on") boolean value10,
                              @Field("remind_me_after") int value11);


    @GET("/fridges/{serial}/measures")
    Call<List<Measures>> Get_Fridge_Measures(@Path("serial")String serial, @Query("from") String from , @Query("to") String to );

    @GET("/fridges/{serial}/measures/last")
    Object Get_Fridge_Measures_last(@Path("serial")String serial);

    @GET("/fridges/{serial}/events")
    Call<List<Event>> Get_Fridge_Events(@Path("serial")String serial, @Query("from") String from , @Query("to") String to );

    @POST("/fridges/{serial}/measures")
    Call<Measures> sendMeasures(@Path("serial")String serial, @Body Measures measures);

    @POST("/fridges/{serial}/events")
    Call<Event> sendEvents(@Path("serial")String serial, @Body Event event);

    @GET("/fridges/{serial}/users")
    Call<List<User>> Get_Fridge_Users(@Path("serial")String serial);
}
