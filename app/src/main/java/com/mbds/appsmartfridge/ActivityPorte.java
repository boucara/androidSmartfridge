package com.mbds.appsmartfridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mbds.appsmartfridge.R;

public class ActivityPorte extends AppCompatActivity {

    SeekBar Seekbar;
    TextView seektext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porte);

        seektext=(TextView)findViewById(R.id.seektext);

        Seekbar =(SeekBar)findViewById(R.id.customSeekBar);
        Seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                seektext.setText("temps d'ouverture porte :" + progressChangedValue+"S");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        });
    }
}