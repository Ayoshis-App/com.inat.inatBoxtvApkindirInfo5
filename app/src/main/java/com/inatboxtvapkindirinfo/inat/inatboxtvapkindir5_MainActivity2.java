package com.inatboxtvapkindirinfo.inat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

import java.util.ArrayList;
import java.util.List;

public class inatboxtvapkindir5_MainActivity2 extends AppCompatActivity {


    TextView btn, btn1;

    ImageView Q_1, Q_2;
    private com.facebook.ads.AdView bannerAdContainer;
    LinearLayout adView1, L1, L2;
    FrameLayout nativeAdContainer;
    FrameLayout frameLayout;
    NativeAd nativeAd1;
    InterstitialAd interstitialAd;
    ProgressDialog progressDialog;
    public String TAG = String.valueOf(getClass());
    CardView A1;
    FrameLayout A2;
    private SharedPreferences sharedPreferences;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inatboxtvapkindir5_main2);
        loadfbNativeAd();
        showfbbanner();
        ShowFullAds();

        inatboxtvapkindir5_splesh.url_passing(inatboxtvapkindir5_MainActivity2.this);
        inatboxtvapkindir5_splesh.url_passing1(inatboxtvapkindir5_MainActivity2.this);
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);


        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedData = sharedPreferences.getString("data", null);
        String savedData1 = sharedPreferences.getString("data1", null);
        if (savedData != null) {
            btn.setVisibility(View.VISIBLE);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (savedData1 != null && savedData1.length() >= 14) {
//                            String packageName = data.substring(3, data.length() - 14);
//                            String customUrl = data.substring(3, data.length() - 14);
                    Log.d(TAG, "Custom URL: " + savedData1);

                    // Open the custom URL in a browser
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(savedData1));
                    startActivity(intent);
                } else {
                    Log.d(TAG, "Data is null or incomplete");
                }
            }

        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(inatboxtvapkindir5_MainActivity2.this, inatboxtvapkindir5_MainActivity.class);
                startActivity(i);
            }
        });
    }

    public static void inflateAd(NativeAd nativeAd, View adView, final Context context) {
        MediaView nativeAdIcon = (MediaView) adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = (TextView) adView.findViewById(R.id.native_ad_title);
        TextView nativeAdBody = (TextView) adView.findViewById(R.id.native_ad_body);
        MediaView nativeAdMedia = (MediaView) adView.findViewById(R.id.native_ad_media);
        TextView sponsoredLabel = (TextView) adView.findViewById(R.id.native_ad_sponsored_label);

        nativeAdMedia.setListener(new MediaViewListener() {
            @Override
            public void onVolumeChange(MediaView mediaView, float volume) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: Volume " + volume);
            }

            @Override
            public void onPause(MediaView mediaView) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: Paused");
            }

            @Override
            public void onPlay(MediaView mediaView) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: Play");
            }

            @Override
            public void onFullscreenBackground(MediaView mediaView) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: FullscreenBackground");
            }

            @Override
            public void onFullscreenForeground(MediaView mediaView) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: FullscreenForeground");
            }

            @Override
            public void onExitFullscreen(MediaView mediaView) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: ExitFullscreen");
            }

            @Override
            public void onEnterFullscreen(MediaView mediaView) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: EnterFullscreen");
            }

            @Override
            public void onComplete(MediaView mediaView) {
                Log.e(inatboxtvapkindir5_MainActivity2.class.toString(), "MediaViewEvent: Completed");
            }
        });

        TextView nativeAdSocialContext = (TextView) adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdCallToAction = (TextView) adView.findViewById(R.id.native_ad_call_to_action);
        LinearLayout L1 = (LinearLayout) adView.findViewById(R.id.L1);
        L1.setVisibility(View.VISIBLE);

        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        List< View > clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdIcon);
        clickableViews.add(nativeAdMedia);
        clickableViews.add(nativeAdCallToAction);
        nativeAd.registerViewForInteraction(adView, nativeAdMedia, nativeAdIcon, clickableViews);

        NativeAdBase.NativeComponentTag.tagView(nativeAdIcon, NativeAdBase.NativeComponentTag.AD_ICON);
        NativeAdBase.NativeComponentTag.tagView(nativeAdTitle, NativeAdBase.NativeComponentTag.AD_TITLE);
        NativeAdBase.NativeComponentTag.tagView(nativeAdBody, NativeAdBase.NativeComponentTag.AD_BODY);
        NativeAdBase.NativeComponentTag.tagView(nativeAdSocialContext, NativeAdBase.NativeComponentTag.AD_SOCIAL_CONTEXT);
        NativeAdBase.NativeComponentTag.tagView(nativeAdCallToAction, NativeAdBase.NativeComponentTag.AD_CALL_TO_ACTION);
    }

    public void loadfbNativeAd() {

        Log.e(TAG, "fbnative5 " + getString(R.string.fbnative));
        nativeAdContainer = findViewById(R.id.fl_adplaceholder);
        LayoutInflater inflater = this.getLayoutInflater();
        adView1 = (LinearLayout) inflater.inflate(R.layout.inatboxtvapkindir5_native_ad_layout, nativeAdContainer, false);
        nativeAdContainer.addView(adView1);
        nativeAd1 = new NativeAd(getApplicationContext(), getString(R.string.fbnative));
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e("fbnative5==>", "onMediaDownloaded: ");

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                //  nativeAdContainer.setVisibility(View.GONE);
                Log.e("fbnative5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbnative5==>", "onAdLoaded: ");
                if (nativeAd1 == null || nativeAd1 != ad) {

                    return;
                }
                inflateAd(nativeAd1, adView1, getApplicationContext());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbnative5==>", "onAdClicked: ");


            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbnative5==>", "onLoggingImpression: ");

            }
        };

        nativeAd1.loadAd(
                nativeAd1.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());


    }

    private void showfbbanner() {
        Log.e(TAG, "fbban5 " + getString(R.string.fbbanner));
        FrameLayout adViewContainer = findViewById(R.id.fl_b);
        bannerAdContainer = new com.facebook.ads.AdView(this, getString(R.string.fbbanner), com.facebook.ads.AdSize.BANNER_HEIGHT_90);
        adViewContainer.addView(bannerAdContainer);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.e("fbban5==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbban5==>", "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbban5==>", "onAdClicked: ");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbban5==>", "onLoggingImpression: ");
            }
        };

        bannerAdContainer.loadAd(
                bannerAdContainer.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());
    }

    public void ShowFullAds() {
        Log.e(TAG, "fbfull5 " + getString(R.string.fbfull));
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
                        Log.e(TAG, "fbfull5 " + "Interstitial ad dismissed.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        // Ad error callback
                        Log.e(TAG, "fbfull5" + adError.getErrorMessage());

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d(TAG, "fbfull5 " + "Interstitial ad is loaded and ready to be diSplash_screenlayed!");
                        if (interstitialAd != null && interstitialAd.isAdLoaded())
                            interstitialAd.show();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        // Ad clicked callback
                        Log.d(TAG, "fbfull5 " + "Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        // Ad impression logged callback
                        Log.d(TAG, "fbfull5 " + "Interstitial ad impression logged!");
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

    public void onBackPressed() {
        super.onBackPressed();

        inatboxtvapkindir5_splesh.url_passing(inatboxtvapkindir5_MainActivity2.this);
        inatboxtvapkindir5_splesh.url_passing1(inatboxtvapkindir5_MainActivity2.this);
        ShowFullAds();


    }

}

