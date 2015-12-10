package com.costular.flatsharing;

import android.app.Application;
import android.os.Bundle;

import com.karumi.dexter.Dexter;

/**
 * Created by diego on 10/12/15.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Dexter.initialize(getApplicationContext());
    }
}