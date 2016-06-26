package com.udacity.gradle.builditbigger.paid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.OnJokeReceivedListener;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFragment extends Fragment implements OnJokeReceivedListener {

  public MainActivityFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_main, container, false);
    Button tellJokeButton = (Button) root.findViewById(R.id.tellJokeButton);

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
    new EndpointsAsyncTask().execute(this);

  }

  @Override
  public void onReceived(String joke) {
    Log.d("RCD","JOKE RECEIVED");
    Toast.makeText(getActivity(), joke, Toast.LENGTH_LONG).show();
  }
}
