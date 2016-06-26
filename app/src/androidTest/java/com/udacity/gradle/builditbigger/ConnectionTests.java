package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.test.UiThreadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by ryand on 6/25/2016.
 */
public class ConnectionTests extends AndroidTestCase implements OnJokeReceivedListener {
  EndpointsAsyncTask task;
  final CountDownLatch signal = new CountDownLatch(1);
  String download;

  protected void setUp() throws Exception {
    super.setUp();

    task = new EndpointsAsyncTask();
  }

  @UiThreadTest
  public void downloadTest() throws InterruptedException{
    task.execute();
    signal.await(40, TimeUnit.SECONDS);

    assertTrue("Valid joke is returned", download !=null);

  }

  @Override
  public void onReceived(String joke) {
    download = joke;
    signal.countDown();
  }
}
