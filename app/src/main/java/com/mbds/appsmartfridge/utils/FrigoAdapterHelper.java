package com.mbds.appsmartfridge.utils;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.mbds.appsmartfridge.R;
import com.mbds.appsmartfridge.model.Frigo;

/**
 * Created by jperk on 03/12/2017.
 */

public class FrigoAdapterHelper implements ListAdapter {
    ArrayList<Frigo> LF;
    Context ctx;
    TextView frigoName ;
    TextView name;
    TextView frigoStatus;
    ImageView frigo;
    //Button bConnect;
    //Button bDisconnect;
    public FrigoAdapterHelper(Context ctx) {
        this.LF = new ArrayList<>();
        LF.add(new Frigo(1,"Samsung SMARTF","Connecté",4,50,"decomp","samsung garantie 6a","180cm x 50cm x 60cm","Samsung"));
        LF.add(new Frigo(2,"LG SMRTF","Déconnecté",5,50,"decomp","lg garantie 5a","180cm x 50cm x 60cm","LG"));
        LF.add(new Frigo(3,"BEKO FSMRT","Connecté",6,50,"decomp","beko garantie 2a","180cm x 50cm x 60cm","Beko"));
        this.ctx = ctx;
    }

    public FrigoAdapterHelper(ArrayList<Frigo> LF, Context ctx) {
        super();
        this.LF = LF;
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
        return LF.size();
    }

    @Override
    public Object getItem(int position) {
        return LF.get(position);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View returnView;
        if(convertView==null){

            returnView=View.inflate(ctx, R.layout.frigo, null);
        }
        else {
            returnView = convertView;
        }

        frigoName=(TextView)returnView.findViewById(R.id.frigoName);
        frigoName.setText(LF.get(position).getFrigoName());
        frigoStatus=(TextView)returnView.findViewById(R.id.etatFrigo);
        frigoStatus.setText(LF.get(position).getFrigoStatus());
        frigo=(ImageView)returnView.findViewById(R.id.imageID);
        //frigo.setImageBitmap(LF.get(position).getImage());
        name=(TextView)returnView.findViewById(R.id.name);
        name.setText(LF.get(position).getNom());
       /* bDisconnect=(Button)returnView.findViewById(R.id.buttonDeconnecter);
        bConnect=(Button)returnView.findViewById(R.id.buttonConnecter);
        if(LF.get(position).getFrigoStatus()=="Connected"){

            bDisconnect.setVisibility(View.VISIBLE);
            bConnect.setVisibility(View.INVISIBLE);

        }
        if(LF.get(position).getFrigoStatus()=="Disconnected"){
            bDisconnect.setVisibility(View.INVISIBLE);
            bConnect.setVisibility(View.VISIBLE);
        }
*/
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
        if(LF.isEmpty())
            return true;
        else
            return false;
    }
}
