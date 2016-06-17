package com.ryandymock.jokefeeder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

  public final static String JOKE_INTENT = "JOKE_INTENT";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke);

    String joke = getIntent().getStringExtra(JOKE_INTENT);
    TextView textView = (TextView) findViewById(R.id.jokeTextView);
    textView.setText(joke);

  }
}
