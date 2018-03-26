package com.mbds.appsmartfridge;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mbds.appsmartfridge.R;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class ActivityHygrometrie extends AppCompatActivity {

    EditText nomAlerte;
    TextView seektext,min,max;
    com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar seekBar;
    final Context context=this;
    Button ajout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hygrometrie);
        nomAlerte=(EditText)findViewById(R.id.nom);
        min=(TextView)findViewById(R.id.min) ;
        max=(TextView)findViewById(R.id.max) ;

        min.setText("30%");
        max.setText("70%");

        seektext=(TextView)findViewById(R.id.seektext) ;

        seekBar=( com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar)findViewById(R.id.rangeSeekbar);
        seekBar.setRangeValues(30,70) ;
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                seektext.setText(minValue+"%" + "-" + maxValue+"%");
            }
        });
        seekBar.setNotifyWhileDragging(true);
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
                                    Intent intent = new Intent(ActivityHygrometrie.this,ActivityListeAlerte.class);
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
}
