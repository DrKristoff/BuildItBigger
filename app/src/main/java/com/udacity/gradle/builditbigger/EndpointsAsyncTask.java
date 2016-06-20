package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.example.ryand.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by ryand on 6/20/2016.
 */
class EndpointsAsyncTask extends AsyncTask<OnJokeReceivedListener, Void, String> {
  private static JokeApi myApiService = null;
  private Context context;
  private OnJokeReceivedListener listener;

  @Override
  protected String doInBackground(OnJokeReceivedListener... params) {
    if(myApiService == null) {  // Only do this once
              JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
              .setRootUrl("https://build-it-bigger-1349.appspot.com/_ah/api/");
      // end options for devappserver

      myApiService = builder.build();
    }

    listener = params[0];

    try {
      return myApiService.getJoke().execute().getData();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

  @Override
  protected void onPostExecute(String result) {
    listener.onReceived(result);
  }
}
