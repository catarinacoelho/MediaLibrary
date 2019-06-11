package com.example.medialibrary;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
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

        Button listButton = (Button) findViewById(R.id.button_list);
        listButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(ImageTextActivity.this, "BUTTON PRRSSED",Toast.LENGTH_LONG).show();
            }
        });

        Button cameraButton = (Button) findViewById(R.id.button_camera);
        cameraButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(ImageTextActivity.this, "BUTTON PRRSSED",Toast.LENGTH_LONG).show();
            }
        });

        GridViewAdapter adapterViewAndroid = new GridViewAdapter(ImageTextActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.gridview);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(ImageTextActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });

    }

    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}
