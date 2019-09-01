package com.example.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class SplashActivity extends AppCompatActivity {

    private Context mContext;
    private Handler mMainActivityLaunchHandler;
    private DraweeController mDraweeController;
    private SimpleDraweeView mGifSimpleDraweeView;

    private final int SPLASH_SCREEN_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = this;

        getSupportActionBar().hide();
        initView();
        loadGif();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMainActivity();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMainActivityLaunchHandler.removeCallbacksAndMessages(null);
    }

    private void startMainActivity() {
        mMainActivityLaunchHandler = new Handler();
        mMainActivityLaunchHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivityIntent = new Intent(mContext, MainActivity.class);
                startActivity(mainActivityIntent);
                finish();
            }
        }, SPLASH_SCREEN_DURATION);
    }

    private void initView(){
        mGifSimpleDraweeView = findViewById(R.id.sdv_gif_item);
    }

    private void loadGif() {
        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                .path(String.valueOf(R.drawable.splsh_gif))
                .build();

        mDraweeController = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build();
        mGifSimpleDraweeView.setController(mDraweeController);
    }

}
