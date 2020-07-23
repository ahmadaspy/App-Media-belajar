 package com.corp.aspy.mediabelajarhtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

 public class MainActivity extends AppCompatActivity {
    private ImageView splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash = (ImageView) findViewById(R.id.logo_img);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MenuListView.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.mysplash);
        splash.startAnimation(animation);
    }
}
