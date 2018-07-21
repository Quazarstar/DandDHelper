package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MapSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_selection);
    }

    public void goToMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void goTownMap(View view) {
        Intent intent = new Intent(this, townMapActivity.class);
        startActivity(intent);
    }

    public void goLabyrinthMap(View view) {
        Intent intent = new Intent(this, labyrinthMapActivity.class);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
