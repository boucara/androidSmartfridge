package mbds.smartfridge;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import mbds.smartfridge.model.Frigo;
import mbds.smartfridge.model.Produit;

public class ActivityProduit extends AppCompatActivity {

    TextView textView2;
    TextView textView5;
    TextView categorieData;
    TextView datePremtionData;
    TextView dateAjoutData;
    TextView textView;
    ImageView img;
    TextView titre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        titre=(TextView)findViewById(R.id.titre);
        img=(ImageView)findViewById(R.id.im) ;
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);
        textView5=(TextView)findViewById(R.id.textView5);
        categorieData=(TextView)findViewById(R.id.categorieData);
        dateAjoutData=(TextView)findViewById(R.id.dateAjoutData);
        datePremtionData=(TextView)findViewById(R.id.datePremtionData);
        Intent i = getIntent();
        Produit prod = (Produit) i.getSerializableExtra("produit");
        titre.setText(prod.getNom());
        categorieData.setText(prod.getCat());
        dateAjoutData.setText(prod.getDate_ajout());
        datePremtionData.setText("Data indisponible");
    }
}
