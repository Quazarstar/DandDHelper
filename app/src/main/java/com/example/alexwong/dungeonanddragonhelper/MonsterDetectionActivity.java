package com.example.alexwong.dungeonanddragonhelper;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.VisionRequestInitializer;
import com.google.api.services.vision.v1.model.AnnotateImageRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;
import com.google.api.services.vision.v1.model.Feature;
import com.google.api.services.vision.v1.model.Image;
import com.google.api.services.vision.v1.model.TextAnnotation;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class MonsterDetectionActivity extends AppCompatActivity {

    private Vision vision;
    public static final int CAMERA_PERMISSIONS_REQUEST = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;

    private Context mContext;

    private ImageView photo_view;
    private PopupWindow mPopupWindow;

    private RelativeLayout mRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logodetection);

        mContext = getApplicationContext();
        Activity mActivity = MonsterDetectionActivity.this;
        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_LogoDet);
        Button popButton = findViewById(R.id.detectionHelp);

        popButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                View popView = inflater.inflate(R.layout.custompop,null);

                mPopupWindow = new PopupWindow(
                        popView,
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT
                );

                if(Build.VERSION.SDK_INT>=21){
                    mPopupWindow.setElevation(5.0f);
                }

                Button closeButton = popView.findViewById(R.id.ib_close);

                closeButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        mPopupWindow.dismiss();
                    }
                });
                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
            }
        });

        Button button = findViewById(R.id.setPicture);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setPicture();
            }
        });

        Vision.Builder visionBuilder = new Vision.Builder(
                new NetHttpTransport(),
                new AndroidJsonFactory(),
                null);

        visionBuilder.setVisionRequestInitializer(
                new VisionRequestInitializer("AIzaSyCufg-u7ciBxyEiZXfnWXkXpJzaidU_m74"));

        vision = visionBuilder.build();
        photo_view = findViewById(R.id.photo_view);

    }

    public void setPicture() {
        if (PermissionUtils.requestPermission(
                this,
                CAMERA_PERMISSIONS_REQUEST,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA)) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            logoDetection(imageBitmap);
            photo_view.setImageBitmap(imageBitmap);
        }
    }


    private void logoDetection(final Bitmap imageBitmap) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    ByteArrayOutputStream photoData = new ByteArrayOutputStream();
                    imageBitmap.compress(Bitmap.CompressFormat.JPEG, 90, photoData);
                    byte[] imageBytes = photoData.toByteArray();

                    Image inputImage = new Image();
                    inputImage.encodeContent(imageBytes);

                    Feature desiredFeature = new Feature();
                    desiredFeature.setType("TEXT_DETECTION");

                    AnnotateImageRequest request = new AnnotateImageRequest();
                    request.setImage(inputImage);
                    request.setFeatures(Arrays.asList(desiredFeature));

                    BatchAnnotateImagesRequest batchRequest = new BatchAnnotateImagesRequest();
                    batchRequest.setRequests(Arrays.asList(request));

                    BatchAnnotateImagesResponse batchResponse =
                            vision.images().annotate(batchRequest).execute();

                    final TextAnnotation text = batchResponse.getResponses()
                            .get(0).getFullTextAnnotation();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    text.getText(), Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(MonsterDetectionActivity.this, MonsterInfoActivitiy.class);
                            intent.putExtra("TITLE", text.getText());
                            startActivity(intent);

                        }
                    });

                } catch(Exception e) {
                    Log.d("ERROR", e.getMessage());
                }
            }
        });
    }


    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
