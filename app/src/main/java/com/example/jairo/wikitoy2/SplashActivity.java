package com.example.jairo.wikitoy2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity
{
    private static final long SPLASH_SCREEN_DELAY = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try
        {
            TimerTask task= new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, Datos_ChildActivity.class);
                    startActivity(intent);
                    finish();
                }
            };

            Timer timer=new Timer();
            timer.schedule(task, SPLASH_SCREEN_DELAY);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
