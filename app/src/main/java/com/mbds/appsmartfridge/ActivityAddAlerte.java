package com.mbds.appsmartfridge;

import android.app.DatePickerDialog;
import android.app.Dialog;
//import android.icu.util.Calendar;
import java.util.Calendar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class ActivityAddAlerte extends AppCompatActivity {
    TextView titre  ;
    Button buttonDate , ajout;
    EditText nomAlerte;
    com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar seekBar ,rangeSeekBarH;
    SeekBar mySeekbar;
    SeekBar customSeekBar;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView , seektext , seektextD ,min ,max ,seektextP,seektextH;
    private int year, month, day;
    final Context context = this;


    static final int LONG_DELAY = 3500;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_alerte);

        titre=(TextView)findViewById(R.id.titre);
        nomAlerte=(EditText)findViewById(R.id.nom);
        seektext=(TextView)findViewById(R.id.seektext) ;
        seektextD=(TextView)findViewById(R.id.seektextD) ;
        seektextP=(TextView)findViewById(R.id.seektextP) ;

        min=(TextView)findViewById(R.id.min) ;
        max=(TextView)findViewById(R.id.max) ;



        ajout=(Button) findViewById(R.id.ajout) ;
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(nomAlerte.getText().toString().matches(" ") || nomAlerte.getText().toString().isEmpty() || nomAlerte.getText().toString().equals("\t")){
                    Toast.makeText(context, "vous devez renseigner le nom de l'alerte!", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(!nomAlerte.getText().toString().contains("_")){
                    Toast.makeText(context, "Saisie incorrecte , respectez les consignes de nommages!", Toast.LENGTH_LONG).show();
                    return;
                }
            else{

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Ajout alerte");
                    alertDialogBuilder
                            .setMessage("voulez vous confirmer?")
                            .setCancelable(false)
                            .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(ActivityAddAlerte.this,ActivityListeAlerte.class);
                                    intent.putExtra("name",nomAlerte.getText().toString());
                                    setResult(1, intent);
                                    finish();
                                }
                            })
                            .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
            }




            }
        });

        buttonDate=(Button)findViewById(R.id.buttondate);


        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        seekBar=( com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar)findViewById(R.id.rangeSeekbar);

        mySeekbar =(SeekBar)findViewById(R.id.seek1);
        mySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                seektextD.setText("temps de décomposition :" + progressChangedValue+"%");

            }
        });




        customSeekBar =(SeekBar)findViewById(R.id.customSeekBar);
        customSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                seektextP.setText("temps d'ouverture de la porte  :" + progressChangedValue+"s");

            }
        });


        Spinner spinner_Alerte = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[] { "Temperature", "Decomposition", "Porte" , "Hygrometrie","Péremption" };
        ArrayAdapter<String> adapter_Alerte = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adapter_Alerte.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner_Alerte.setAdapter(adapter_Alerte);
        spinner_Alerte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                String alerte=(String) parent.getItemAtPosition(position);

                if(alerte.equalsIgnoreCase("temperature")){
                    nomAlerte.setVisibility(View.VISIBLE);
                    nomAlerte.setHint("Example: Temp_myalerte");
                    seekBar.setVisibility(View.VISIBLE);
                    buttonDate.setVisibility(View.INVISIBLE);
                    dateView.setVisibility(View.INVISIBLE);
                    mySeekbar.setVisibility(View.INVISIBLE);
                    titre.setText(" Alerte Temperature");
                    customSeekBar.setVisibility(View.INVISIBLE);
                    seektext.setVisibility(View.VISIBLE);
                    seektextD.setVisibility(View.INVISIBLE);
                    seektextP.setVisibility(View.INVISIBLE);
                    min.setVisibility(View.VISIBLE);
                    min.setText("0°");
                    max.setVisibility(View.VISIBLE);
                    max.setText("15°");
                    seekBar.setRangeValues(0,15) ;
                    seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                        @Override
                        public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                            seektext.setText(minValue+"°" + "-" + maxValue+"°");
                        }
                    });

                }

                else if(alerte.equalsIgnoreCase("decomposition")){
                    nomAlerte.setVisibility(View.VISIBLE);
                    nomAlerte.setHint("Example: Decomp_myalerte");
                    seekBar.setVisibility(View.INVISIBLE);
                    buttonDate.setVisibility(View.INVISIBLE);
                    dateView.setVisibility(View.INVISIBLE);
                    mySeekbar.setVisibility(View.VISIBLE);
                    titre.setText(" Alerte Decomposition");
                    customSeekBar.setVisibility(View.INVISIBLE);
                    seektext.setVisibility(View.INVISIBLE);
                    seektextD.setVisibility(View.VISIBLE);
                    seektextP.setVisibility(View.INVISIBLE);

                    min.setVisibility(View.VISIBLE);
                    min.setText("0%");
                    max.setVisibility(View.VISIBLE);
                    max.setText("100%");
                }
                else if(alerte.equalsIgnoreCase("porte")){
                    nomAlerte.setVisibility(View.VISIBLE);
                    nomAlerte.setHint("Example: Porte_myalerte");
                    seekBar.setVisibility(View.INVISIBLE);
                    buttonDate.setVisibility(View.INVISIBLE);
                    dateView.setVisibility(View.INVISIBLE);
                    mySeekbar.setVisibility(View.INVISIBLE);
                    titre.setText(" Alerte Porte");
                    customSeekBar.setVisibility(View.VISIBLE);
                    seektext.setVisibility(View.INVISIBLE);
                    seektextD.setVisibility(View.INVISIBLE);
                    seektextP.setVisibility(View.VISIBLE);
                    min.setVisibility(View.VISIBLE);
                    min.setText("0S");
                    max.setVisibility(View.VISIBLE);
                    max.setText("180S");
                }
               else if(alerte.equalsIgnoreCase("hygrometrie")){
                    seekBar.setVisibility(View.VISIBLE);
                    buttonDate.setVisibility(View.INVISIBLE);
                    dateView.setVisibility(View.INVISIBLE);
                    nomAlerte.setVisibility(View.VISIBLE);
                    nomAlerte.setHint("Example: Hygro_myalerte");
                    mySeekbar.setVisibility(View.INVISIBLE);

                    titre.setText(" Alerte Hygrométrie");
                    customSeekBar.setVisibility(View.INVISIBLE);
                    seektext.setVisibility(View.VISIBLE);
                    seektextD.setVisibility(View.INVISIBLE);
                    seektextP.setVisibility(View.INVISIBLE);
                    min.setVisibility(View.VISIBLE);
                    min.setText("0%");
                    max.setVisibility(View.VISIBLE);
                    max.setText("100%");
                    seektext.setText("");
                    seekBar.setRangeValues(0,100) ;


                    seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                        @Override
                        public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                            seektext.setText(minValue+"%" + "-" + maxValue+"%");
                        }
                    });


                }
                else if(alerte.equalsIgnoreCase("péremption")) {

                    buttonDate.setVisibility(View.VISIBLE);
                    dateView.setVisibility(View.VISIBLE);
                    nomAlerte.setVisibility(View.VISIBLE);
                    nomAlerte.setHint("Example: Péremp_myalerte");
                    seekBar.setVisibility(View.INVISIBLE);
                    mySeekbar.setVisibility(View.INVISIBLE);
                    titre.setText(" Alerte Péremption");
                    customSeekBar.setVisibility(View.INVISIBLE);
                    seektextD.setVisibility(View.INVISIBLE);
                    min.setVisibility(View.INVISIBLE);
                    max.setVisibility(View.INVISIBLE);
                    seektextP.setVisibility(View.INVISIBLE);
                    seektext.setVisibility(View.INVISIBLE);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        seekBar.setNotifyWhileDragging(true);
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

}
