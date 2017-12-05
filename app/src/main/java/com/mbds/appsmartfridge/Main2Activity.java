package com.mbds.appsmartfridge;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView titre  ;
    Button buttonDate;
    EditText nomAlerte;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titre=(TextView)findViewById(R.id.titre);
        //titre.setVisibility(View.INVISIBLE);

        buttonDate=(Button)findViewById(R.id.buttondate);
        nomAlerte=(EditText)findViewById(R.id.nom);


        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        Spinner spinner_Alerte = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[] { "temperature", "decomposition", "porte" , "hygrometrie","péremption" };
        ArrayAdapter<String> adapter_Alerte = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner_Alerte.setAdapter(adapter_Alerte);
        spinner_Alerte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                String alerte=(String) parent.getItemAtPosition(position);

                if(alerte.equalsIgnoreCase("temperature")||alerte.equalsIgnoreCase("decomposition")|| alerte.equalsIgnoreCase("porte")||alerte.equalsIgnoreCase("hygrometrie")){

                    buttonDate.setVisibility(View.INVISIBLE);
                    dateView.setVisibility(View.INVISIBLE);
                    nomAlerte.setVisibility(View.INVISIBLE);

                }
                else if(alerte.equalsIgnoreCase("decomposition")){

                }
                else if(alerte.equalsIgnoreCase("porte")){

                }
               else if(alerte.equalsIgnoreCase("hygrometrie")){

                }
                else if(alerte.equalsIgnoreCase("péremption")){

                    buttonDate.setVisibility(View.VISIBLE);
                    dateView.setVisibility(View.VISIBLE);
                    nomAlerte.setVisibility(View.VISIBLE);


                }






            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
