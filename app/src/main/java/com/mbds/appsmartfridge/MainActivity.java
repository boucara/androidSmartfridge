package com.mbds.appsmartfridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.mbds.appsmartfridge.Main2Activity;
import com.mbds.appsmartfridge.R;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    String[] alertes_temperature = new String[]{"temp-alert1","temp-alert2","temp-alerte3","temp-alerte4","temp-alerte5","temp-alert6","temp-alert7"};
    String[] alertes_decomposition = new String[]{"gaz-alert1","gaz-alert2","gaz-alerte3","gaz-alerte4","gaz-alerte5","gaz-alert6","gaz-alert7"};
    String[] alertes_porte = new String[]{"porte-alert1","porte-alert2","porte-alerte3","porte-alerte4","porte-alert5","porte-alert6","porte-alert7"};
    String[] alertes_hygrometrie = new String[]{"hygro-alert1","hygro-alert2","hygo-alerte3","hygro-alerte4","hygro-alert5","hygro-alert6","hygro-alert7"};
    String[] alertes_peremption= new String[]{"exp-alert1","exp-alert2","exp-alerte3","exp-alerte4","exp-alert5","exp-alert6","exp-alert7" ,"exp-alert7","exp-alert7"
            ,"exp-alert7","exp-alert7","exp-alert7","exp-alert7","exp-alert7","exp-alert7","exp-alert7","exp-alert7","exp-alert7"};

    FloatingActionButton fab;
    int ok_ann=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,ok_ann);
            }
        });
        mListView=(ListView) findViewById(R.id.listView);
        Spinner spinner_Alerte = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[] { "Alerte temperature", "Alerte decomposition", "Alerte porte" , "Alerte hygrometrie","Alerte péremption" };
        ArrayAdapter<String> adapter_Alerte = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

        spinner_Alerte.setAdapter(adapter_Alerte);
        spinner_Alerte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                String alerte=(String) parent.getItemAtPosition(position);
                if(alerte.equalsIgnoreCase("Alerte temperature")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, alertes_temperature);
                    mListView.setAdapter(adapter);
                }
               else if(alerte.equalsIgnoreCase("Alerte decomposition")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, alertes_decomposition);
                    mListView.setAdapter(adapter);
                }
               else if(alerte.equalsIgnoreCase("Alerte porte")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, alertes_porte);
                    mListView.setAdapter(adapter);
                }
                else if(alerte.equalsIgnoreCase("Alerte hygrometrie")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, alertes_hygrometrie);
                    mListView.setAdapter(adapter);
                }
                else if(alerte.equalsIgnoreCase("Alerte péremption")){

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, alertes_peremption);
                    mListView.setAdapter(adapter);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
