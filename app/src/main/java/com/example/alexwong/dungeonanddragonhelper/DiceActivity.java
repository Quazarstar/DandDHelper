package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.concurrent.ThreadLocalRandom;

public class DiceActivity extends AppCompatActivity {

    TextView diceText;
    PhotoView dicePhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        dicePhoto = (PhotoView) findViewById(R.id.dicePhoto);

        diceText = findViewById(R.id.diceDisplay);
        final Button D20 = findViewById(R.id.D20);
        final Button D12 = findViewById(R.id.D12);
        final Button D10 = findViewById(R.id.D10);
        final Button D6= findViewById(R.id.D6);
        final Button D4 = findViewById(R.id.D4);
        final Button D100 = findViewById(R.id.D100);
        final Button D8 = findViewById(R.id.D8);

        D20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 20;
                int randomD20 = ThreadLocalRandom.current().nextInt(min,max+1);
                diceText.setText(new StringBuilder().append(randomD20));
                dicePhoto.setImageResource(R.drawable.d20);
            }
        });

        D12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 12;
                int randomD12 = ThreadLocalRandom.current().nextInt(min,max+1);
                diceText.setText(new StringBuilder().append(randomD12));
                dicePhoto.setImageResource(R.drawable.d12);
            }
        });

        D10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 10;
                int randomD10 = ThreadLocalRandom.current().nextInt(min,max+1);
                diceText.setText(new StringBuilder().append(randomD10));
                dicePhoto.setImageResource(R.drawable.d10);
            }
        });

        D8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 8;
                int randomD8 = ThreadLocalRandom.current().nextInt(min,max+1);
                diceText.setText(new StringBuilder().append(randomD8));
                dicePhoto.setImageResource(R.drawable.d8);
            }
        });

        D6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 6;
                int randomD6 = ThreadLocalRandom.current().nextInt(min,max+1);
                diceText.setText(new StringBuilder().append(randomD6));
                dicePhoto.setImageResource(R.drawable.d6);
            }
        });

        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 4;
                int randomD4 = ThreadLocalRandom.current().nextInt(min,max+1);
                diceText.setText(new StringBuilder().append(randomD4));
                dicePhoto.setImageResource(R.drawable.d4);
            }
        });

        D100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 1;
                int max = 100;
                int randomD100 = ThreadLocalRandom.current().nextInt(min,max+1);
                diceText.setText(new StringBuilder().append(randomD100));
                dicePhoto.setImageResource(R.drawable.d100);
            }
        });

    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
