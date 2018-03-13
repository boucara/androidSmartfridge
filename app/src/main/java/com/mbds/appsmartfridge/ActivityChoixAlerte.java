package com.mbds.appsmartfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class ActivityChoixAlerte extends AppCompatActivity {
    private RadioGroup radioAlerteGroup;
    private RadioButton radioAlerteButton;
    private Button btnValider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_alerte);
        addListenerOnButton();
    }
    public void addListenerOnButton() {

        radioAlerteGroup = (RadioGroup) findViewById(R.id.radioAlerte);
        btnValider = (Button) findViewById(R.id.btnValider);

        btnValider.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioAlerteGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioAlerteButton = (RadioButton) findViewById(selectedId);
                if(radioAlerteButton.getText().equals("Temperature")){
                    Intent intent = new Intent(ActivityChoixAlerte.this,ActivityTemperature.class);
                    startActivityForResult(intent,1);
                }
               else if(radioAlerteButton.getText().equals("Décomposition")){
                    Intent intent = new Intent(ActivityChoixAlerte.this,ActivityDecomposition.class);
                    startActivityForResult(intent,2);
                }
                else if(radioAlerteButton.getText().equals("Péremption")){
                    Intent intent = new Intent(ActivityChoixAlerte.this,ActivityPeremption.class);
                    startActivityForResult(intent,1);
            }
               else if(radioAlerteButton.getText().equals("Hygrométrie")){
                    Intent intent = new Intent(ActivityChoixAlerte.this,ActivityHygrometrie.class);
                    startActivityForResult(intent,1);
                }
                else if(radioAlerteButton.getText().equals("Porte")){
                    Intent intent = new Intent(ActivityChoixAlerte.this,ActivityPorte.class);
                    startActivityForResult(intent,1);
                }



            }

        });

    }
}
