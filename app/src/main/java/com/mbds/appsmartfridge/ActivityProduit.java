package com.mbds.appsmartfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbds.appsmartfridge.model.Produit;

public class ActivityProduit extends AppCompatActivity {

    TextView textViewDatePr;
    TextView textViewDateAj;
    TextView categorieData;
    TextView datePremtionData;
    TextView dateAjoutData;
    TextView textViewCat;
    ImageView img;
    TextView titre;
    Button retirer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        titre=(TextView)findViewById(R.id.titre);
        img=(ImageView)findViewById(R.id.im) ;
        textViewCat=(TextView)findViewById(R.id.textViewCat);
        textViewDatePr=(TextView)findViewById(R.id.textViewDatePr);
        textViewDateAj=(TextView)findViewById(R.id.textViewDateAj);
        categorieData=(TextView)findViewById(R.id.categorieData);
        dateAjoutData=(TextView)findViewById(R.id.dateAjoutData);
        datePremtionData=(TextView)findViewById(R.id.datePremtionData);
        retirer = (Button)findViewById(R.id.buttonRetirer);
        Intent i = getIntent();
        Produit prod = (Produit) i.getSerializableExtra("produit");
        titre.setText(prod.getNom());
        categorieData.setText(prod.getCat());
        dateAjoutData.setText(prod.getDate_ajout());
        datePremtionData.setText("Data indisponible");
    }
}
