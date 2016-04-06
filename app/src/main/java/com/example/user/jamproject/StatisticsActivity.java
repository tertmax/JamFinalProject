package com.example.user.jamproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StatisticsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        try {
            TextView t = (TextView) findViewById(R.id.fire_stat);
            t.setText(""+sp.getInt("0", -1));
        } catch (Exception ex) {
        }
        try {
            TextView t = (TextView) findViewById(R.id.police_stat);
            t.setText(""+sp.getInt("1", -1));
        } catch (Exception ex) {
        }
        try {
            TextView t = (TextView) findViewById(R.id.ambulance_stat);
            t.setText(""+sp.getInt("2", -1));
        } catch (Exception ex) {
        }
        try {
            TextView t = (TextView) findViewById(R.id.poison_stat);
            t.setText(""+sp.getInt("3", -1));
        } catch (Exception ex) {
        }
        try {
            TextView t = (TextView) findViewById(R.id.helpline_stat);
            t.setText(""+sp.getInt("4", -1));
        } catch (Exception ex) {
        }

    }
}
