package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMap(View view){
        Intent intent = new Intent(this, MapSelection.class);
        startActivity(intent);
    }

    public void goToAdventure(View view){
        Intent intent = new Intent(this, AdventureActivity.class);
        startActivity(intent);
    }

    public void goToDetection(View view) {
        Intent intent = new Intent(this, MonsterDetectionActivity.class);
        startActivity(intent);
    }

    public void goToDice(View view) {
        Intent intent = new Intent(this, DiceActivity.class);
        startActivity(intent);
    }
}
