
package com.mbds.appsmartfridge;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import  com.mbds.appsmartfridge.model.Produit;
import com.mbds.appsmartfridge.utils.ProduitAdapterHelper;
import com.mbds.appsmartfridge.utils.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityProduits extends AppCompatActivity {

    String tag = "tag";
    ListAdapter adapter = null;
    ListView listProds;
    TextView count;
    ArrayList<Produit> LP = new ArrayList<>();
    Button bAjout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        listProds=(ListView)findViewById(R.id.produits);
        Intent i = getIntent();
        final long id = (long)i.getSerializableExtra("id");
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
        count.setText(adapter.getCount()+" Produit(s)");

        bAjout=(Button) findViewById(R.id.AjoutProd);
        bAjout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ActivityAjoutProduit.class);
                startActivity(i);
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
    @Override
    protected void onRestart() {
        super.onRestart();
        Intent i=getIntent();
        finish();
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }

}
