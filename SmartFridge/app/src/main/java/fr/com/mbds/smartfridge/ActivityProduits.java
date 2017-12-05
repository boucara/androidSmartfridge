package fr.com.mbds.smartfridge;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import fr.com.mbds.smartfridge.utils.ProduitAdapterHelper;

public class ActivityProduits extends AppCompatActivity {

    ListAdapter adapter = null;
    ListView listProds;
    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        //setContentView(R.layout.content_activity_produits);
        listProds=(ListView)findViewById(R.id.produits);
        adapter=new ProduitAdapterHelper(this);
        listProds.setAdapter(adapter);
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

}
