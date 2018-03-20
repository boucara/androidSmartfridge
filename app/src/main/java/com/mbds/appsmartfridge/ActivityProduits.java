
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
    Button buttonScan;
    private IntentIntegrator qrScan;
    private static String URL = "https://fr.openfoodfacts.org/api/v0/produit/";

    String  myJson;
    Produit newProd = new Produit();
    private static final String TAG_CODE = "code";
    private static final String TAG_NAME_P="generic_name";
    private static final String TAG_URL_IMG="image_url";
    private static final String TAG_INGREDIENTS = "ingredients_text_fr";
    JSONArray item_code = null;
    JSONObject code=null;
    private static final String url_test = "https://fr.openfoodfacts.org/api/v0/produit/3029330003533.json";
    private static final String MAIN_URL = "http://pratikbutani.x10.mx/json_data.json";

/* https://fr.openfoodfacts.org/api/v0/produit/3029330003533.json */
/* code
 * generic_name
 * image_url
 * ingredients_text_fr
 *  */


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

                    URL = "https://fr.openfoodfacts.org/api/v0/produit/" + result.getContents()+".json";
                   // JSONParser jParser = new JSONParser()
                    new GetDataTAsk().execute();
                    //item_code = json.getJSONArray(TAG_CODE);
                    //JSONObject c = item_code.getJSONObject(0);

                   //String lolo = "json";
                   // String example = code.toString();                    //try ...




                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    class GetDataTAsk extends AsyncTask<Void, Void, Void>{

        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(ActivityProduits.this);
            dialog.setTitle("Hey Wait Please...");
            dialog.setMessage("I am getting your JSON");
            dialog.show();
        }



        @Override
        protected Void doInBackground(Void... voids) {
            /**
             * Getting JSON Object from Web Using okHttp
             */
            JSONObject jsonObject = JSONParser.getDataFromURL(URL);

            try {
                /**
                 * Check Whether Its NULL???
                 */
                if (jsonObject != null) {
                    /**
                     * Check Length...
                     */
                    if(jsonObject.length() > 0) {
                        /**
                         * Getting Array named "contacts" From MAIN Json Object
                         */

                       // JSONObject objectJson = jsonObject.getJSONObject("product");
                        String objectJsonString = jsonObject.getString("code");
                        Log.i("JSON OBJ NOT NULL=====",objectJsonString);
                        JSONObject objectJson = jsonObject.getJSONObject("product");

                        if(objectJson != null ){
                            if(objectJson.length() > 0){

                                Log.i("JSON OBJ LENGTH > 0====",objectJson.getString("packaging"));
                                String nimgurl= objectJson.getString(TAG_URL_IMG);
                                String nnamep = objectJson.getString(TAG_NAME_P);

                                String ningr = objectJson.getString(TAG_INGREDIENTS);
                                newProd.setNom(nnamep);
                                newProd.setCat(nimgurl);
                                newProd.setDate_ajout(ningr);
                            }
                            else{
                                Log.i("JSON OBJ LENGTH = 0====","length = 0");
                            }
                            myJson = objectJson.getString("packaging");
                        }
                        else
                            Log.i("JSON OBJ NUL===","null" );

                       // JSONObject myobj = j
                        /**
                         * Check Length of Array...
                         */
                        /*
                        if(lenArray > 0) {
                            Log.i("JSON Array===","NOT NULL");
                           /* for(int jIndex = 0; jIndex < lenArray; jIndex++) {

                                MyDataModel model = new MyDataModel();
                                JSONObject innerObject = array.getJSONObject(jIndex);
                                String name = innerObject.getString(Keys.KEY_NAME);
                                String email = innerObject.getString(Keys.KEY_EMAIL);
                                String image = innerObject.getString(Keys.KEY_PROFILE_PIC);

                                JSONObject phoneObject = innerObject.getJSONObject(Keys.KEY_PHONE);
                                String phone = phoneObject.getString(Keys.KEY_MOBILE);

                                model.setName(name);
                                model.setEmail(email);
                                model.setPhone(phone);
                                model.setImage(image);

                                list.add(model);
                            }*/
                       /* }
                        else {
                            Log.i("JSON Array===","NULL");
                        }*/
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
            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG);
            Log.i("SUCCEES=========",URL);

        }
    }

}
