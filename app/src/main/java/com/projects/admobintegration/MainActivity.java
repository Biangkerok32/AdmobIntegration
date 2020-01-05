package com.projects.admobintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBanner, btnInterstitial, btnNative, btnRewarded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBanner = findViewById(R.id.btnBanner);
        btnInterstitial = findViewById(R.id.btnInterstitial);
        btnNative = findViewById(R.id.btnNative);
        btnRewarded = findViewById(R.id.btnRewarded);
        btnBanner.setOnClickListener(this);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBanner:

                startActivity(new Intent(MainActivity.this, BannerActivity.class));
                break;

        }
    }
}
