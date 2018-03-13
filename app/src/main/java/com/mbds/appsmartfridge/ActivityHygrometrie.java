package com.mbds.appsmartfridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.mbds.appsmartfridge.R;
import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class ActivityHygrometrie extends AppCompatActivity {

    EditText nomAlerte;
    TextView seektext,min,max;
    com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hygrometrie);
        nomAlerte=(EditText)findViewById(R.id.nom);
        min=(TextView)findViewById(R.id.min) ;
        max=(TextView)findViewById(R.id.max) ;

        min.setText("30%");
        max.setText("70%");

        seektext=(TextView)findViewById(R.id.seektext) ;

        seekBar=( com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar)findViewById(R.id.rangeSeekbar);
        seekBar.setRangeValues(30,70) ;
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                seektext.setText(minValue+"%" + "-" + maxValue+"%");
            }
        });
        seekBar.setNotifyWhileDragging(true);



    }
}
