package com.mbds.appsmartfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.mbds.appsmartfridge.ActivityFrigos;

public class ActivityAccueil extends AppCompatActivity {

    ImageButton frigos;
    ImageButton nousContact;
    ImageButton parametres;
    ImageButton aboutUs;
    TextView frigos_t;
    TextView parametres_t;
    TextView aboutUs_t;
    TextView contactUs_t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        frigos_t=(TextView)findViewById(R.id.frigos);
        frigos=(ImageButton)findViewById(R.id.imageButton);

        nousContact=(ImageButton)findViewById(R.id.nousContacter);
        parametres_t=(TextView)findViewById(R.id.parametres);
        parametres = (ImageButton)findViewById(R.id.imageButton4);
        aboutUs_t=(TextView)findViewById(R.id.about);
        aboutUs=(ImageButton)findViewById(R.id.imageButton5);
        contactUs_t=(TextView)findViewById(R.id.contactUs);
        frigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityAccueil.this,ActivityFrigos.class);
                startActivity(i);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityAccueil.this,AProposActivity.class);
                startActivity(i);
            }
        });
        nousContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ActivityAccueil.this,AProposActivity.class);
                startActivity(i);
            }
        });

    }
}
