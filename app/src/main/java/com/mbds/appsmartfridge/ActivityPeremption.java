package com.mbds.appsmartfridge;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mbds.appsmartfridge.R;

import java.util.Calendar;

public class ActivityPeremption extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView ;
    private Button  buttonDate;
    private int year, month, day;
    final Context context=this;
    Button ajout;
    EditText nomAlerte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peremption);

        buttonDate=(Button)findViewById(R.id.buttondate);
        nomAlerte=(EditText)findViewById(R.id.nom);


        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
        ajout=(Button) findViewById(R.id.ajout) ;
        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(nomAlerte.getText().toString().matches(" ") || nomAlerte.getText().toString().isEmpty() || nomAlerte.getText().toString().equals("\t")){
                    Toast.makeText(context, "vous devez renseigner le nom de l'alerte!", Toast.LENGTH_LONG).show();
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
                                    Intent intent = new Intent(ActivityPeremption.this,ActivityListeAlerte.class);
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
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);

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
