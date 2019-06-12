package com.example.myapplication;
import android.app.Activity;
import android.util.Log;


import android.os.Bundle;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.sdk.InterstitialListener;


public class MainActivity extends Activity implements InterstitialListener {

    private final String TAG = "Demo";

    private final String APP_KEY = "85460dcd";
    private final String FALLBACK_USER_ID = "userId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IronSource.setInterstitialListener(this);

        IronSource.setUserId(FALLBACK_USER_ID);
        IronSource.init(this, APP_KEY, IronSource.AD_UNIT.INTERSTITIAL);

        IronSource.loadInterstitial();

    }



    protected void onResume() {
        super.onResume();
        IronSource.onResume(this);
    }
    protected void onPause() {
        super.onPause();
        IronSource.onPause(this);
    }



    public void onInterstitialAdReady() {
        IronSource.showInterstitial();
        Log.d(TAG, "loaded");


    }
    /**
     invoked when there is no Interstitial Ad available after calling load function.
     */
    @Override
    public void onInterstitialAdLoadFailed(IronSourceError error) {
        Log.e(TAG, "error");

    }
    /**
     Invoked when the Interstitial Ad Unit is opened
     */
    @Override
    public void onInterstitialAdOpened() {
        Log.d(TAG, "ad opened");

    }
    /*
     * Invoked when the ad is closed and the user is about to return to the application.
     */
    @Override
    public void onInterstitialAdClosed() {
        Log.d(TAG, "ad closed");

    }
    /*
     * Invoked when the ad was opened and shown successfully.
     */
    @Override
    public void onInterstitialAdShowSucceeded() {
        Log.d(TAG, "ad show succeeded");

    }
    /**
     * Invoked when Interstitial ad failed to show.
     // @param error - An object which represents the reason of showInterstitial failure.
     */
    @Override
    public void onInterstitialAdShowFailed(IronSourceError error) {
        Log.e(TAG, "ad show failed");

    }
    /*
     * Invoked when the end user clicked on the interstitial ad.
     */
    @Override
    public void onInterstitialAdClicked() {
        Log.d(TAG, "ad clicked");
    }

    /**
     invoked when there is no Interstitial Ad available after calling load function.
     */




}
