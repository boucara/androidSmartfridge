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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mbds.appsmartfridge.R;

public class ActivityDecomposition extends AppCompatActivity {
    SeekBar Seekbar;
    TextView seektext;
    final Context context = this;
    Button ajout ;
    EditText nomAlerte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decomposition);

        seektext=(TextView)findViewById(R.id.seektext);

        Seekbar =(SeekBar)findViewById(R.id.customSeekBar);
        Seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                seektext.setText(" décomposition :" + progressChangedValue);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        });
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
                                    Intent intent = new Intent(ActivityDecomposition.this,ActivityListeAlerte.class);
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
