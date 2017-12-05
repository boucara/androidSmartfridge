package fr.com.mbds.smartfridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import fr.com.mbds.smartfridge.utils.FrigoAdapterHelper;

public class ActivityFrigos extends AppCompatActivity {

    ListAdapter adapter = null;
    ListView listFrigos;
    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_frigos);
        listFrigos=(ListView)findViewById(R.id.frigos);
        adapter=new FrigoAdapterHelper(this);
        listFrigos.setAdapter(adapter);
        count=(TextView)findViewById(R.id.countFrigos);
        count.setText(adapter.getCount()+" SmartFrigos");

    }
}
