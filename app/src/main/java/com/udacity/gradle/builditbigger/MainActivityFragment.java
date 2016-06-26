package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnJokeReceivedListener{

  InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
      Button tellJokeButton = (Button) root.findViewById(R.id.tellJokeButton);

      mInterstitialAd = new InterstitialAd(getActivity());
      mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

      mInterstitialAd.setAdListener(new AdListener() {
        @Override
        public void onAdClosed() {
          requestNewInterstitial();
        }
      });

      requestNewInterstitial();

      tellJokeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          tellJoke();
        }
      });
        return root;
    }

  public void tellJoke(){
    //mSpinner.setVisibility(View.VISIBLE);
    Log.d("RCD","FETCHING JOKE");
    if (mInterstitialAd.isLoaded()) {
      mInterstitialAd.show();
    }
    new EndpointsAsyncTask().execute(this);

  }

  private void requestNewInterstitial() {
    AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
            .build();

    mInterstitialAd.loadAd(adRequest);
  }

  @Override
  public void onReceived(String joke) {
    Log.d("RCD","JOKE RECEIVED");
    Toast.makeText(getActivity(), joke, Toast.LENGTH_LONG).show();
  }
}
