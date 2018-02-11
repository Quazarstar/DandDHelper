package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MapActivity extends AppCompatActivity {

    public static final int STORAGE_PERMISSIONS_REQUEST = 1;
    PhotoView photoView;
    Button mapButton;
    Button saveMapButton;
    Random r;

    Integer[] images = {
            R.drawable.map1,
            R.drawable.map2,
            R.drawable.map3,
            R.drawable.map4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        photoView = (PhotoView) findViewById(R.id.mapView);

        mapButton = (Button) findViewById(R.id.getMapButton);

        r = new Random();

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //display random image
                photoView.setImageResource(images[r.nextInt(images.length)]);
            }
        });

    }

    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void saveMap(View view) throws IOException {
        boolean success = false;
        BitmapDrawable draw = (BitmapDrawable) photoView.getDrawable();
        Bitmap bitmap = draw.getBitmap();

        FileOutputStream outStream = null;
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() + "/YourFolderName");
        dir.mkdirs();
        String fileName = String.format("%d.jpg", System.currentTimeMillis());
        File outFile = new File(dir, fileName);
        outStream = new FileOutputStream(outFile);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
        outStream.flush();
        outStream.close();
        success = true;

        if (success) {
            Toast.makeText(getApplicationContext(), "Image saved with success to folder YourFolderName with name :" +fileName,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Error during image saving", Toast.LENGTH_LONG).show();
        }

    }
}




