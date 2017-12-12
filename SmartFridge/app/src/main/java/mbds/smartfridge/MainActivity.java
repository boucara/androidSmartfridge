package mbds.smartfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton frigos;
    ImageButton produits;
    ImageButton parametres;
    ImageButton aboutUs;
    TextView frigos_t;
    TextView produits_t;
    TextView parametres_t;
    TextView aboutUs_t;
    TextView contactUs_t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frigos_t=(TextView)findViewById(R.id.frigos);
        frigos=(ImageButton)findViewById(R.id.imageButton);
        produits_t=(TextView)findViewById(R.id.all_produits);
        produits=(ImageButton)findViewById(R.id.imageButton3);
        parametres_t=(TextView)findViewById(R.id.parametres);
        parametres = (ImageButton)findViewById(R.id.imageButton4);
        aboutUs_t=(TextView)findViewById(R.id.about);
        aboutUs=(ImageButton)findViewById(R.id.imageButton5);
        contactUs_t=(TextView)findViewById(R.id.contactUs);
        frigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ActivityFrigos.class);
                startActivity(i);
            }
        });
        produits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ActivityProduits.class);
                startActivity(i);
            }
        });

    }
}
