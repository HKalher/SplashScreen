package com.example.splashscreen;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class SplashScreen extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
