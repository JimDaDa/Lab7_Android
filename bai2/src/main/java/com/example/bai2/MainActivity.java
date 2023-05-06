package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends AppCompatActivity {
    private static final int MY_READ_PERMISSION_CODE =101;
    private RecyclerView recycleView;
    private List<String> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gallery);
        recycleView= findViewById(R.id.gridView);
        //Check
        if (ContextCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_READ_PERMISSION_CODE);

        } else {
            loadImages();

        }
    }
    private void loadImages(){
        recycleView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3 , GridLayoutManager.VERTICAL,false);
        recycleView.setLayoutManager(gridLayoutManager);
        items=ImageGallery.listOfImages(this);
        Log.d("ImageGalleryActivity", "Number of images: " + items.size());
        GalleryAdapter adapter = new GalleryAdapter(items, this , new GalleryAdapter.PhotoListener() {
            @Override
            public void onClickPhoto(String path) {
                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });

        recycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycleView.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_READ_PERMISSION_CODE:

                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadImages();
                } else {
                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                }
        }
        // Other 'case' lines to check for other
        // permissions this app might request.
    }
}
//    public void showImage(View view) {
//        this.startActivity(new Intent(this, ImageGalleryActivity.class));
//    }
//
//    public void showVideo(View view) {
//        this.startActivity(new Intent(this, VideoGalleryActivity.class));
//    }
