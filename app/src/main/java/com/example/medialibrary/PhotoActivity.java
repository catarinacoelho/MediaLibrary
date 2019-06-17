package com.example.medialibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);

        Intent intent = getIntent();
        String image_url = intent.getStringExtra("imageurl");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(PhotoActivity.this)
                .load(image_url)
                .into(imageView);

    }

}

