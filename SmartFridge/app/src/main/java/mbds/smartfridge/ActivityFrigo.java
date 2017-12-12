package mbds.smartfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import mbds.smartfridge.model.Frigo;

public class ActivityFrigo extends AppCompatActivity {

    TextView titre;
    ImageView imageFrigo;
    ImageView temp;
    ImageView humidite;
    ImageView decomp;
    ImageView status;
    TextView temp_t;
    TextView decomp_t;
    TextView humid_t;
    TextView status_t;
    TextView liste_prod;
    TextView caracts;
    TextView alertes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frigo);
        imageFrigo=(ImageView)findViewById(R.id.imageFrigo);
        temp=(ImageView)findViewById(R.id.imageTemp);
        humidite=(ImageView)findViewById(R.id.imageHumidite);
        decomp=(ImageView)findViewById(R.id.imageDecomposition);
        status=(ImageView)findViewById(R.id.imageStatus);
        titre=(TextView)findViewById(R.id.titre);
        temp_t=(TextView)findViewById(R.id.tempData);
        decomp_t=(TextView)findViewById(R.id.decompositionData);
        humid_t=(TextView)findViewById(R.id.humiditeData);
        status_t=(TextView)findViewById(R.id.statusData);
        liste_prod=(TextView)findViewById(R.id.liste);
        caracts=(TextView)findViewById(R.id.carac);
        alertes=(TextView)findViewById(R.id.alertes);

        Intent i = getIntent();
        Frigo frigo = (Frigo)i.getSerializableExtra("frigo");
        //Toast.makeText(getApplicationContext(),Integer.toString(frigo.getTemperature()),Toast.LENGTH_LONG).show();
        titre.setText(frigo.getFrigoName());
        temp_t.setText(Integer.toString(frigo.getTemperature()));
        decomp_t.setText(frigo.getDecomposition());
        humid_t.setText(Integer.toString(frigo.getHumidite()));
        status_t.setText(frigo.getFrigoStatus());
    }
}
