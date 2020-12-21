package com.example.netflix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageView logo = findViewById(R.id.logo);
        ImageView name = findViewById(R.id.app_name);
        Animation top_anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        Animation bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        logo.setAnimation(top_anim);
        name.setAnimation(bottom_anim);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(MainActivity.this,Dashboard.class));
            finish();
        },3000);

    }
}