package com.example.alexwong.dungeonanddragonhelper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class labyrinthMapActivity extends AppCompatActivity {

    private static Context context;

    public static final int STORAGE_PERMISSIONS_REQUEST = 1;
    PhotoView photoView;
    Button mapButton;
    Random r;

    FirebaseStorage storage = FirebaseStorage.getInstance();

    StorageReference storageRef = storage.getReference();
    StorageReference mapRef = storageRef.child("map.jpg");
    StorageReference mapImageRef = storageRef.child("MapImages/map.jpg");
    StorageReference storageReference = storage.getReference();
    StorageReference pathReference = storageReference.child("MapImages/map.jpg");
    StorageReference gsReference = storage.getReferenceFromUrl("gs://dungeonanddragonhelper.appspot.com/map.jpg");


    Integer[] images = {
            R.drawable.labyrinth1,
            R.drawable.labyrinth2,
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
            public void onClick(View v) {
                //display random image
                photoView.setImageResource(images[r.nextInt(images.length)]);
            }
        });

        mapRef.getName().equals(mapImageRef.getName());
        mapRef.getPath().equals(mapImageRef.getPath());

    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void saveMap(View view) throws IOException {
        boolean success = false;
        BitmapDrawable draw = (BitmapDrawable) photoView.getDrawable();
        Bitmap bitmap = draw.getBitmap();

        FileOutputStream outStream = null;
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() + "/MapImages");
        dir.mkdirs();
        String fileName = String.format("map.jpg");
        File outFile = new File(dir, fileName);
        outStream = new FileOutputStream(outFile);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
        outStream.flush();
        outStream.close();
        success = true;

        if (success) {
            Toast.makeText(getApplicationContext(), "Image saved with success to folder MapImages with name :" + fileName,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Error during image saving", Toast.LENGTH_LONG).show();
        }

    }

    public void putBytes(View view) {

        photoView.setDrawingCacheEnabled(true);
        photoView.buildDrawingCache();
        Bitmap bitmap = photoView.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = mapRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                boolean success = true;
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                if (success) {
                    Toast.makeText(getApplicationContext(), "Map uploaded with success to database", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void getMapFromStorage(View view) {
        StorageReference gsReference = storage.getReferenceFromUrl("gs://dungeonanddragonhelper.appspot.com/map.jpg");
        PhotoView photoView = findViewById(R.id.mapView);
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(photoView);
    }

    public void deleteMapFromStorage(View view) {
        StorageReference photoRef = storage.getReferenceFromUrl("gs://dungeonanddragonhelper.appspot.com/map.jpg");
        photoRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                boolean success = true;
                if (success) {
                    Toast.makeText(getApplicationContext(), "Map deleted from Database successfully", Toast.LENGTH_LONG).show();
                }
                // File deleted successfully
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Uh-oh, an error occurred!
            }
        });
    }
}
