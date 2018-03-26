package com.mbds.appsmartfridge;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.mbds.appsmartfridge.model.Produit;
import com.mbds.appsmartfridge.utils.JSONParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ActivityAjoutProduit extends AppCompatActivity {

    Button bAjout;
    Button buttonScan;
    private IntentIntegrator qrScan;
    private static String URL = "https://fr.openfoodfacts.org/api/v0/produit/";
    TextView textViewNomProd;

    TextView textViewCat;
    EditText categorieData;
    TextView textViewDatePr; //textViewDatePrempt
    TextView textViewDateAj; //textViewDateAjoutProd

    DatePicker datePremtionData; //datePremtionDataPicker
    TextView dateAjoutData; //dateAjoutDataProd

    ImageView img; //imgProd
    EditText nom;
    String myJson;
    Produit newProd;
    private static final String TAG_CODE = "code";
    private static final String TAG_NAME_P = "generic_name";
    private static final String TAG_URL_IMG = "image_url";
    private static final String TAG_INGREDIENTS = "ingredients_text_fr";
    private static final String TAG_CATEGORIES = "categories";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actovity_ajout_produit);
         textViewNomProd = (TextView)findViewById(R.id.textViewNameProd);
         nom = (EditText)findViewById(R.id.titreProduit);
         categorieData = (EditText) findViewById(R.id.categorieDataProd);
         textViewCat = (TextView)findViewById(R.id.textViewCatProd);
        bAjout = (Button)findViewById(R.id.buttonAjouterProduit);
        buttonScan = (Button)findViewById(R.id.buttonScannerProduit);
        qrScan = new IntentIntegrator(this);
        Intent i = getIntent();
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {

                try {

                    URL = "https://fr.openfoodfacts.org/api/v0/produit/" + result.getContents()+".json";
                    new ActivityAjoutProduit.GetDataTAsk().execute();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    class GetDataTAsk extends AsyncTask<Void, Void, Void> {

        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(ActivityAjoutProduit.this);
            dialog.setTitle("Hey Wait Please...");
            dialog.setMessage("I am getting your JSON");
            dialog.show();
        }



        @Override
        protected Void doInBackground(Void... voids) {
            JSONObject jsonObject = JSONParser.getDataFromURL(URL);
            try {
                if (jsonObject != null) {
                    if(jsonObject.length() > 0) {
                        String objectJsonString = jsonObject.getString("code");
                        Log.i("JSON OBJ NOT NULL=====",objectJsonString);
                        JSONObject objectJson = jsonObject.getJSONObject("product");

                        if(objectJson != null ){
                            if(objectJson.length() > 0){

                                Log.i("JSON OBJ LENGTH > 0====",objectJson.getString("packaging"));
                                String nimgurl= objectJson.getString(TAG_URL_IMG);
                                String nnamep = objectJson.getString(TAG_NAME_P);
                                String ncategories = objectJson.getString(TAG_CATEGORIES);
                                newProd = new Produit(8,1,nnamep,ncategories);
                            }
                            else{
                                Log.i("JSON OBJ LENGTH = 0====","length = 0");
                            }
                            myJson = objectJson.getString("packaging");
                        }
                        else
                            Log.i("JSON OBJ NUL===","null" );
                    }
                } else {

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            categorieData.setText(newProd.getCat());
            nom.setText(newProd.getNom());

            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG);
            Log.i("SUCCEES=========",URL);

        }
    }
    public void getURLimgToBitMap(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response reponse;
        try {
            reponse = client.newCall(request).execute();
        }


        //return new JSONObject(response.body().string());
        catch (IOException e)

        {
            Log.e("TAG", "" + e.getLocalizedMessage());
        }
    }
}
