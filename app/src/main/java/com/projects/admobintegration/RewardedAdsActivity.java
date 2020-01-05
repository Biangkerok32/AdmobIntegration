package com.projects.admobintegration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class RewardedAdsActivity extends AppCompatActivity {

    private RewardedAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rewarded_ads);

        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
                if (rewardedAd.isLoaded()) {
                    rewardedAd.show(RewardedAdsActivity.this, new RewardedAdCallback() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                        }
                    });
                }
                Toast.makeText(RewardedAdsActivity.this, "Ad successfully loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
                Toast.makeText(RewardedAdsActivity.this, "Ad failed to load.", Toast.LENGTH_SHORT).show();

            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }
}
