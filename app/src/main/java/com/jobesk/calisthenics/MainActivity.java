package com.jobesk.calisthenics;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment f = new HomeFragment();
        openfrag(f);
    }

    private void openfrag(Fragment f1) {

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
//        FT.addToBackStack(null);
        FT.replace(R.id.frame_container, f1);
        FT.commit();

    }

}
