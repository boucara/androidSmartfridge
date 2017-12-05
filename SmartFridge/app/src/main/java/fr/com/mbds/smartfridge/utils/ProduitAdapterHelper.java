package fr.com.mbds.smartfridge.utils;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import fr.com.mbds.smartfridge.R;
import fr.com.mbds.smartfridge.model.Produit;

/**
 * Created by jperk on 03/12/2017.
 */

public class ProduitAdapterHelper implements ListAdapter {
    ArrayList<Produit> LP;
    Context ctx;
    TextView nom ;
    TextView cat;
    TextView date_ajout;
    ImageView imageP;

    public ProduitAdapterHelper(Context ctx) {
        this.LP = new ArrayList<>();
        LP.add(new Produit("Oeufs","Cat1"));
        LP.add(new Produit("Beurre","Cat2"));
        LP.add(new Produit("Fromage","Cat2"));
        LP.add(new Produit("Lait","Cat2"));
        LP.add(new Produit("Jambon","Cat3"));

        this.ctx = ctx;
    }

    public ProduitAdapterHelper(ArrayList<Produit> LP, Context ctx) {
        super();
        this.LP = LP;
        this.ctx = ctx;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return LP.size();
    }

    @Override
    public Object getItem(int position) {
        return LP.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View returnView;
        if(convertView==null){

            returnView=View.inflate(ctx, R.layout.produit, null);
        }
        else {
            returnView = convertView;
        }

        nom=(TextView)returnView.findViewById(R.id.produitNom);
        nom.setText(LP.get(position).getNom());
        cat=(TextView)returnView.findViewById(R.id.categorieProd);
        cat.setText(LP.get(position).getCat());
        imageP=(ImageView)returnView.findViewById(R.id.produitImageID);
        imageP.setImageBitmap(LP.get(position).getImage());
        date_ajout=(TextView)returnView.findViewById(R.id.dateAjoutProduit);
        date_ajout.setText(LP.get(position).getDate_ajout().toString());

        return returnView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        if(LP.isEmpty())
            return true;
        else
            return false;
    }
}
