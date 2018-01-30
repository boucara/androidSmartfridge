package com.mbds.appsmartfridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import  com.mbds.appsmartfridge.model.Produit;
import com.mbds.appsmartfridge.utils.ProduitAdapterHelper;

public class ActivityProduits extends AppCompatActivity {

    ListAdapter adapter = null;
    ListView listProds;
    TextView count;
    ArrayList<Produit> LP = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        listProds=(ListView)findViewById(R.id.produits);
        initList();
        adapter=new ProduitAdapterHelper(this,LP);
        listProds.setAdapter(adapter);
        listProds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produit p=(Produit) adapter.getItem(position);
                Bundle args = new Bundle();
                args.putSerializable("produit",p);
                Intent i = new Intent(ActivityProduits.this,ActivityProduit.class);
                i.putExtras(args);
                startActivity(i);
            }
        });
        count=(TextView)findViewById(R.id.countProd);
        count.setText(adapter.getCount()+" Produits");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void initList(){
        LP.add(new Produit(1,1,"Oeufs","Cat1"));
        LP.add(new Produit(2,1,"Beurre","Cat2"));
        LP.add(new Produit(3,2,"Fromage","Cat2"));
        LP.add(new Produit(4,2,"Lait","Cat2"));
        LP.add(new Produit(5,3,"Jambon","Cat3"));
        LP.add(new Produit(6,3,"Lait entier","Cat3"));
        LP.add(new Produit(7,1,"Beurre doux","Cat2"));
    }

}
