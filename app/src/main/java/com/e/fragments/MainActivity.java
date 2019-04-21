package com.e.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Fragments.FirstFragment;
import Fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnFragment;
private Boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment=findViewById(R.id.btnFragement);
        btnFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (status) {
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.add(R.id.fragmentContainer,firstFragment);
            fragmentTransaction.commit();
            btnFragment.setText("Load Second Fragment");
            status = false;

        } else {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.add(R.id.fragmentContainer,secondFragment);
            fragmentTransaction.commit();
            btnFragment.setText("Load First Fragment");
            status = true;
        }

    }
}
