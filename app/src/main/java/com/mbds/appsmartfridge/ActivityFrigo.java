package com.mbds.appsmartfridge;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mbds.appsmartfridge.model.Frigo;
import com.mbds.appsmartfridge.services.AppelAPI;
import com.mbds.appsmartfridge.utils.ControllerApplication;

import java.util.Timer;
import java.util.TimerTask;

public class ActivityFrigo extends AppCompatActivity {

    TextView titre;
    ImageView imageFrigo;
    ImageView temp;
    ImageView humidite;
    ImageView decomp;
    ImageView status;
    TextView temp_t;
    TextView decomp_t;
    TextView humid_t;
    TextView status_t;
    Button liste_prod;
    Button caracts;
    Button alertes;
    AppelAPI appelAPI;
    Timer timerGetData;
    Frigo frigo;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frigo);
        imageFrigo=(ImageView)findViewById(R.id.imageFrigo);
        temp=(ImageView)findViewById(R.id.imageTemp);
        humidite=(ImageView)findViewById(R.id.imageHumidite);
        decomp=(ImageView)findViewById(R.id.imageDecomposition);
        status=(ImageView)findViewById(R.id.imageStatus);
        titre=(TextView)findViewById(R.id.titre);
        temp_t=(TextView)findViewById(R.id.tempData);
        decomp_t=(TextView)findViewById(R.id.decompositionData);
        humid_t=(TextView)findViewById(R.id.humiditeData);
        status_t=(TextView)findViewById(R.id.statusData);
        liste_prod=(Button) findViewById(R.id.butProd);
        caracts=(Button) findViewById(R.id.butCaract);
        alertes=(Button) findViewById(R.id.buttAlertes);
        handler = new Handler();

        Intent i = getIntent();
        frigo = (Frigo)i.getSerializableExtra("frigo");
        ControllerApplication.getInstance().setActualFrigo(frigo);
        timerGetData = new Timer();
        timerGetData.schedule(new GetDataSensorTimer(), 1000,30000);
        final long id = (long)i.getSerializableExtra("id");
        //Toast.makeText(getApplicationContext(),Integer.toString(frigo.getTemperature()),Toast.LENGTH_LONG).show();
        titre.setText(frigo.getFrigoName());
        temp_t.setText("? °");
        decomp_t.setText("?");
        humid_t.setText("?");
        status_t.setText("?");
        liste_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putSerializable("id",id);
                Intent i=new Intent(ActivityFrigo.this,ActivityProduits.class);
                i.putExtras(args);
                startActivity(i);
            }
        });
        alertes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle args = new Bundle();
                //args.putSerializable("frigo",f);
                Intent i=new Intent(ActivityFrigo.this,ActivityListeAlerte.class);
                startActivity(i);
            }
        });
        caracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle args = new Bundle();
                //args.putSerializable("frigo",f);
                Intent i=new Intent(ActivityFrigo.this,ActivityCaracteristiques.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onDestroy() {

        //Close timerReadData
        timerGetData.cancel();
        timerGetData.purge();

        super.onDestroy();
    }

    // ---- SEND DATA SENSOR TIMER
    private class GetDataSensorTimer extends TimerTask {

        private AppelAPI appelAPI = new AppelAPI();

        @Override
        public void run() {


            appelAPI.getDataSensors(frigo.getFrigoName());
            frigo = ControllerApplication.getInstance().getActualFrigo();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    temp_t.setText(frigo.getTemperature()+" °");
                    decomp_t.setText(frigo.getDecomposition());
                    humid_t.setText(frigo.getHumidite()+"");
                    status_t.setText(frigo.getFrigoStatus());
                }
            });

        }
    }
}
