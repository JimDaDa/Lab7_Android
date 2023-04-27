package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showImage(View view) {
        this.startActivity(new Intent(this, ImageGalleryActivity.class));
    }

    public void showVideo(View view) {
        this.startActivity(new Intent(this, VideoGalleryActivity.class));
    }
}