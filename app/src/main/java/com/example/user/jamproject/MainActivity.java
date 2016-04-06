package com.example.user.jamproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    static final int PAGE_COUNT = 2;
    private boolean[] buttonCheck = new boolean[5];
    private String[] mNumbers = new String[5];
    int[] counters = new int[5];
    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumbers = getResources().getStringArray(R.array.numbers_array);
        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0)
                return getString(R.string.firsttab_text);
            else
                return getString(R.string.secondtab_text);
        }
    }

    public void callClick(View view) {

        for (int i = 0; i < 5; i++) {
            if (buttonCheck[i] == true) {
                SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
                if(sp.getInt(""+i,-1) != 0){
                    counters[i] = sp.getInt(""+i,-1);
                }
                counters[i]++;

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(""+i, counters[i]);
                editor.commit();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + mNumbers[i]));
                startActivity(intent);
            }
        }
    }

    public void fireClick(View view) {
        Button b = (Button) findViewById(R.id.fire_button);
        if (buttonCheck[0] == false) {
            refreshButtons();
            b.setBackground(getResources().getDrawable(R.drawable.firebutton_pressed, null));
            buttonCheck[0] = true;
        } else {
            refreshButtons();
        }
    }

    public void poliecClick(View view) {
        Button b = (Button) findViewById(R.id.police_button);
        if (buttonCheck[1] == false) {
            refreshButtons();
            b.setBackground(getResources().getDrawable(R.drawable.policebutton_pressed, null));
            buttonCheck[1] = true;
        } else {
            refreshButtons();
        }
    }

    public void ambulanceClick(View view) {
        Button b = (Button) findViewById(R.id.ambulance_button);
        if (buttonCheck[2] == false) {
            refreshButtons();
            b.setBackground(getResources().getDrawable(R.drawable.ambulancebutton_pressed, null));
            buttonCheck[2] = true;
        } else {
            refreshButtons();
        }
    }

    public void poisonClick(View view) {
        Button b = (Button) findViewById(R.id.poison_button);
        if (buttonCheck[3] == false) {
            refreshButtons();
            b.setBackground(getResources().getDrawable(R.drawable.poisonbutton_pressed, null));
            buttonCheck[3] = true;
        } else {
            refreshButtons();
        }
    }

    public void helplineClick(View view) {
        Button b = (Button) findViewById(R.id.helpline_button);
        if (buttonCheck[4] == false) {
            refreshButtons();
            b.setBackground(getResources().getDrawable(R.drawable.helpliebutton_pressed, null));
            buttonCheck[4] = true;
        } else {
            refreshButtons();
        }
    }

    public void startStatisticsActivity(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feedback));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.write_your_feedback));

        startActivity(Intent.createChooser(intent, getString(R.string.send_email)));
    }

    public void startFireInfoActivity(View view) {
        Intent intent = new Intent(this, FireDescriptionActivity.class);
        startActivity(intent);
    }

    public void startPoliceInfoActivity(View view) {
        Intent intent = new Intent(this, PoliceDescriptionActivity.class);
        startActivity(intent);
    }

    public void startAmbulanceInfoActivity(View view) {
        Intent intent = new Intent(this, AmbulanceDescriptionActivity.class);
        startActivity(intent);
    }

    public void startPoisonInfoActivity(View view) {
        Intent intent = new Intent(this, PoisonDescriptionActivity.class);
        startActivity(intent);
    }

    public void startHelplineInfoActivity(View view) {
        Intent intent = new Intent(this, HelplineDescriptionActivity.class);
        startActivity(intent);
    }

    public void refreshButtons() {
        Button b = (Button) findViewById(R.id.fire_button);
        b.setBackground(getResources().getDrawable(R.drawable.firebutton, null));
        b = (Button) findViewById(R.id.police_button);
        b.setBackground(getResources().getDrawable(R.drawable.policebutton, null));
        b = (Button) findViewById(R.id.ambulance_button);
        b.setBackground(getResources().getDrawable(R.drawable.ambulancebutton, null));
        b = (Button) findViewById(R.id.poison_button);
        b.setBackground(getResources().getDrawable(R.drawable.poisonbutton, null));
        b = (Button) findViewById(R.id.helpline_button);
        b.setBackground(getResources().getDrawable(R.drawable.helpliebutton, null));
        for (int i = 0; i < 5; i++) {
            buttonCheck[i] = false;
        }

    }
}