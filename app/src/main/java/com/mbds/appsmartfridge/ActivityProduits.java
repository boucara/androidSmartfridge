package com.mbds.appsmartfridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import  com.mbds.appsmartfridge.model.Produit;
import com.mbds.appsmartfridge.utils.ProduitAdapterHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityProduits extends AppCompatActivity {

    ListAdapter adapter = null;
    ListView listProds;
    TextView count;
    ArrayList<Produit> LP = new ArrayList<>();
    Button bAjout;
    Button buttonScan;
    private IntentIntegrator qrScan;

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
        count.setText(adapter.getCount()+" Produits");

        buttonScan=(Button) findViewById(R.id.Scan);
        bAjout=(Button) findViewById(R.id.AjoutProd);
        qrScan = new IntentIntegrator(this);
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
                       }}); */
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {

                try {
                    //JSONObject obj = new JSONObject(result.getContents());
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
