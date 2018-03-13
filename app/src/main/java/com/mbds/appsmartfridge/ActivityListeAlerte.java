package com.mbds.appsmartfridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityListeAlerte extends AppCompatActivity {
    ListView mListView;
    ArrayList<String> alertes_temperature = new ArrayList<String>();
    ArrayList<String> alertes_decomposition = new ArrayList<String>();
    ArrayList<String> alertes_porte = new ArrayList<String>();
    ArrayList<String> alertes_peremption = new ArrayList<String>();
    ArrayList<String> alertes_global = new ArrayList<String>();
    ArrayList<String> alertes_hygrometrie  = new ArrayList<String>();
    //initialisation



    FloatingActionButton fab;
    int ok_ann=1;
    TextView titre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_liste_alerte);
        initialise();

        titre= (TextView) findViewById(R.id.titre) ;

        fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityListeAlerte.this,ActivityChoixAlerte.class);
                startActivityForResult(intent,ok_ann);
            }
        });
        mListView=(ListView) findViewById(R.id.listView);
        Spinner spinner_Alerte = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[] { "Alerte temperature", "Alerte decomposition", "Alerte porte" , "Alerte hygrometrie","Alerte péremption" };
        ArrayAdapter<String> adapter_Alerte = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adapter_Alerte.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_Alerte.setAdapter(adapter_Alerte);
        spinner_Alerte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                String alerte=(String) parent.getItemAtPosition(position);
                if(alerte.equalsIgnoreCase("Alerte temperature")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityListeAlerte.this,
                            android.R.layout.simple_list_item_1, alertes_temperature);
                    mListView.setAdapter(adapter);
                    titre.setText("Les alertes associées à la temperature");
                }
               else if(alerte.equalsIgnoreCase("Alerte decomposition")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityListeAlerte.this,
                            android.R.layout.simple_list_item_1, alertes_decomposition);
                    mListView.setAdapter(adapter);
                    titre.setText("Les alertes associées à la decomposition");
                }
               else if(alerte.equalsIgnoreCase("Alerte porte")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityListeAlerte.this,
                            android.R.layout.simple_list_item_1, alertes_porte);
                    mListView.setAdapter(adapter);
                    titre.setText("Les alertes associées à la porte");
                }
                else if(alerte.equalsIgnoreCase("Alerte hygrometrie")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityListeAlerte.this,
                            android.R.layout.simple_list_item_1, alertes_hygrometrie);
                    mListView.setAdapter(adapter);
                    titre.setText("Les alertes associées à l'hygrometrie");
                }
                else if(alerte.equalsIgnoreCase("Alerte péremption")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityListeAlerte.this,
                            android.R.layout.simple_list_item_1, alertes_peremption);
                    mListView.setAdapter(adapter);
                    titre.setText("Les alertes associées à la péremption");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected  void onActivityResult(int requestCode , int resultCode ,  Intent data){
        super.onActivityResult(requestCode ,resultCode ,data);
      if(resultCode==1){
          String myString = data.getStringExtra("name");
          String[] tabNomAlerte = myString.split("_");
          if(tabNomAlerte[0].equalsIgnoreCase("Temp"))
              alertes_temperature.add(myString);

          else if(tabNomAlerte[0].equalsIgnoreCase("Decomp"))
              alertes_decomposition.add(myString);
          else if(tabNomAlerte[0].equalsIgnoreCase("Porte"))
              alertes_porte.add(myString);
          else if(tabNomAlerte[0].equalsIgnoreCase("Hygro"))
              alertes_hygrometrie.add(myString);
          else if(tabNomAlerte[0].equalsIgnoreCase("Péremp"))
              alertes_peremption.add(myString);

          }




      }

    public void initialise(){
        alertes_decomposition.add("Decomp_alert1");
        alertes_decomposition.add("Decomp_alert2");
        alertes_decomposition.add("Decomp_alert3");
        alertes_decomposition.add("Decomp_alert4");
        alertes_decomposition.add("Decomp_alert5");

        alertes_peremption.add("Péremp_alert1");
        alertes_peremption.add("Péremp_alert2");
        alertes_peremption.add("Péremp_alert3");
        alertes_peremption.add("Péremp_alert4");
        alertes_peremption.add("Péremp_alert5");

        alertes_porte.add("Porte_alerte1");
        alertes_porte.add("Porte_alerte2");
        alertes_porte.add("Porte_alerte3");
        alertes_porte.add("Porte_alerte4");
        alertes_porte.add("Porte_alerte5");

        alertes_temperature.add("Temp_alert1");
        alertes_temperature.add("Temp_alert2");
        alertes_temperature.add("Temp_alert3");
        alertes_temperature.add("Temp_alert4");
        alertes_temperature.add("Temp_alert5");

        alertes_hygrometrie.add("Hygro_alerte1");
        alertes_hygrometrie.add("Hygro_alerte2");
        alertes_hygrometrie.add("Hygro_alerte3");
        alertes_hygrometrie.add("Hygro_alerte4");
        alertes_hygrometrie.add("Hygro_alerte5");

        alertes_global.add("Decomp_alert1");
        alertes_global.add("Temp_alert1");
        alertes_global.add("Péremp_alert1");
        alertes_global.add("Porte_alert1");

    }

}

