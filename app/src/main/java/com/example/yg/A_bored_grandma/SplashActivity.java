package com.example.yg.A_bored_grandma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new SplashHandler(),2000);
    }
    private class SplashHandler implements Runnable{
        public void run(){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            SplashActivity.this.finish();
        }
    }
}
