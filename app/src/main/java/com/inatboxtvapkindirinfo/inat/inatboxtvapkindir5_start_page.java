package com.inatboxtvapkindirinfo.inat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;

public class inatboxtvapkindir5_start_page extends AppCompatActivity  {
    TextView start;
    
    private com.facebook.ads.AdView bannerAdContainer;
    LinearLayout adView1,L1,L2;
    FrameLayout nativeAdContainer;
    FrameLayout frameLayout;
    NativeAd nativeAd1;
    InterstitialAd interstitialAd;

    public String TAG = String.valueOf(getClass());

    
    
    
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inatboxtvapkindir5_activity_start_page);




        
        inatboxtvapkindir5_splesh.url_passing(inatboxtvapkindir5_start_page.this);
        inatboxtvapkindir5_splesh.url_passing1(inatboxtvapkindir5_start_page.this);



        loadfbNativeAd();
        showfbbanner();
        ShowFullAds();
        this.start = (TextView) findViewById(R.id.start);


        findViewById(R.id.fl_adplaceholder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inatboxtvapkindir5_splesh.url_passing(inatboxtvapkindir5_start_page.this);
                inatboxtvapkindir5_splesh.url_passing1(inatboxtvapkindir5_start_page.this);

            }
        });
        findViewById(R.id.fl_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inatboxtvapkindir5_splesh.url_passing(inatboxtvapkindir5_start_page.this);
                inatboxtvapkindir5_splesh.url_passing1(inatboxtvapkindir5_start_page.this);

            }
        });



        this.start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                inatboxtvapkindir5_start_page.this.startActivity(new Intent(inatboxtvapkindir5_start_page.this, inatboxtvapkindir5_Next.class));

            }
        });



    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        
        Intent intent=new Intent(inatboxtvapkindir5_start_page.this,inatboxtvapkindir5_Exit.class);
        startActivity(intent);
    }

    public void loadfbNativeAd() {

        Log.e(TAG, "fbnative1 " + getString(R.string.fbnative));
        nativeAdContainer = findViewById(R.id.fl_adplaceholder);
        LayoutInflater inflater = this.getLayoutInflater();
        adView1 = (LinearLayout) inflater.inflate(R.layout.inatboxtvapkindir5_native_ad_layout, nativeAdContainer, false);
        nativeAdContainer.addView(adView1);
        nativeAd1 = new NativeAd(getApplicationContext(), getString(R.string.fbnative));
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e("fbnative1==>", "onMediaDownloaded: ");

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                //  nativeAdContainer.setVisibility(View.GONE);
                Log.e("fbnative1==>", adError.getErrorMessage());
                loadfbNativeAd1();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbnative1==>", "onAdLoaded: ");
                if (nativeAd1 == null || nativeAd1 != ad) {

                    return;
                }

                inatboxtvapkindir5_splesh.inflateAd(nativeAd1, adView1, getApplicationContext());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbnative1==>", "onAdClicked: ");


            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbnative1==>", "onLoggingImpression: ");

            }
        };

        nativeAd1.loadAd(
                nativeAd1.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());


    }
    public void loadfbNativeAd1() {

        Log.e(TAG, "fbnative2 " + getString(R.string.fbnative1));
        nativeAdContainer = findViewById(R.id.fl_adplaceholder);
        LayoutInflater inflater = this.getLayoutInflater();
        adView1 = (LinearLayout) inflater.inflate(R.layout.inatboxtvapkindir5_native_ad_layout, nativeAdContainer, false);
        nativeAdContainer.addView(adView1);
        nativeAd1 = new NativeAd(getApplicationContext(), getString(R.string.fbnative1));
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e("fbnative2==>", "onMediaDownloaded: ");

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                //  nativeAdContainer.setVisibility(View.GONE);
                Log.e("fbnative2==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbnative2==>", "onAdLoaded: ");
                if (nativeAd1 == null || nativeAd1 != ad) {

                    return;
                }

                inatboxtvapkindir5_splesh.inflateAd(nativeAd1, adView1, getApplicationContext());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbnative2==>", "onAdClicked: ");


            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbnative2==>", "onLoggingImpression: ");

            }
        };

        nativeAd1.loadAd(
                nativeAd1.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());


    }

    private void showfbbanner() {
        Log.e(TAG, "fbban1 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban1==>", adError.getErrorMessage());
                showfbbanner1();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban1==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban1==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban1==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }

    private void showfbbanner1() {
        Log.e(TAG, "fbban2 " + getString(R.string.fbbanner1));
        FrameLayout adViewContainer = findViewById(R.id.fl_b);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner1), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban2==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban2==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban2==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban2==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }

    public void ShowFullAds() {
        Log.e(TAG, "fbfull1 " + getString(R.string.fbfull));
        try {
            if (inatboxtvapkindir5_splesh.interstitialAd1 != null && inatboxtvapkindir5_splesh.interstitialAd1.isAdLoaded())
                inatboxtvapkindir5_splesh.interstitialAd1.show();
            else {
                if (!inatboxtvapkindir5_splesh.interstitialAd1.isAdLoaded())
                    inatboxtvapkindir5_splesh.interstitialAd1.loadAd();

                interstitialAd = new InterstitialAd(this, getString(R.string.fbfull));
                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        // Interstitial dismissed callback
                        Log.e(TAG, "fbfull1 " + "Interstitial ad dismissed.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        // Ad error callback
                        Log.e(TAG, "fbfull1 " + adError.getErrorMessage());
                        ShowFullAds1();
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d(TAG, "fbfull1 " + "Interstitial ad is loaded and ready to be diSplash_screenlayed!");
                        if (interstitialAd != null && interstitialAd.isAdLoaded())
                            interstitialAd.show();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        // Ad clicked callback
                        Log.d(TAG, "fbfull1 " + "Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        // Ad impression logged callback
                        Log.d(TAG, "fbfull1 " + "Interstitial ad impression logged!");
                    }
                };

                interstitialAd.loadAd(
                        interstitialAd.buildLoadAdConfig()
                                .withAdListener(interstitialAdListener)
                                .build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ShowFullAds1() {
        Log.e(TAG, "fbfull2 " + getString(R.string.fbfull1));
        try {
            if (inatboxtvapkindir5_splesh.interstitialAd2 != null && inatboxtvapkindir5_splesh.interstitialAd2.isAdLoaded())
                inatboxtvapkindir5_splesh.interstitialAd2.show();
            else {
                if (!inatboxtvapkindir5_splesh.interstitialAd2.isAdLoaded())
                    inatboxtvapkindir5_splesh.interstitialAd2.loadAd();

                interstitialAd = new InterstitialAd(this, getString(R.string.fbfull1));
                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        // Interstitial dismissed callback
                        Log.e(TAG, "fbfull2 " + "Interstitial ad dismissed.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        // Ad error callback
                        Log.e(TAG, "fbfull2 " + adError.getErrorMessage());

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d(TAG, "fbfull2 " + "Interstitial ad is loaded and ready to be diSplash_screenlayed!");
                        if (interstitialAd != null && interstitialAd.isAdLoaded())
                            interstitialAd.show();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        // Ad clicked callback
                        Log.d(TAG, "fbfull2 " + "Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        // Ad impression logged callback
                        Log.d(TAG, "fbfull2 " + "Interstitial ad impression logged!");
                    }
                };

                interstitialAd.loadAd(
                        interstitialAd.buildLoadAdConfig()
                                .withAdListener(interstitialAdListener)
                                .build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}