package com.example.medialibrary;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class ImageTextActivity extends AppCompatActivity {

    GridView androidGridView;

    String[] gridViewString = {
            "Nature1", "Nature2", "Nature3", "Nature4", "Nature5", "Nature6", "Nature7", "Nature8"

    } ;
    int[] gridViewImageId = {
            R.drawable.nature1, R.drawable.nature2, R.drawable.nature3, R.drawable.nature4,
            R.drawable.nature5, R.drawable.nature6, R.drawable.nature7, R.drawable.nature8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridViewAdapter adapterViewAndroid = new GridViewAdapter(ImageTextActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.gridview);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(ImageTextActivity.this, PhotoActivity.class);
                intent.putExtra("imageurl", gridViewImageId[i]);
                startActivity(intent);
                //Toast.makeText(ImageTextActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });

        Button cameraButton = (Button) findViewById(R.id.button_camera);
        cameraButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(ImageTextActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

    }
}
