package mbds.smartfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import mbds.smartfridge.model.Frigo;
import mbds.smartfridge.utils.FrigoAdapterHelper;

public class ActivityFrigos extends AppCompatActivity {

    ListAdapter adapter ;
    ListView listFrigos;
    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_frigos);
        listFrigos=(ListView)findViewById(R.id.frigos);
        adapter=new FrigoAdapterHelper(this);
        listFrigos.setAdapter(adapter);

        listFrigos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(ActivityFrigos.this,"CLicked + "+position,Toast.LENGTH_LONG).show();
                Frigo f=(Frigo)adapter.getItem(position);
                Bundle args = new Bundle();
                args.putSerializable("frigo",f);
                Intent i = new Intent(ActivityFrigos.this,ActivityFrigo.class);
                i.putExtras(args);
                startActivity(i);/**/

            }
        });
        count=(TextView)findViewById(R.id.countFrigos);
        count.setText(adapter.getCount()+" SmartFrigos");


    }
}
