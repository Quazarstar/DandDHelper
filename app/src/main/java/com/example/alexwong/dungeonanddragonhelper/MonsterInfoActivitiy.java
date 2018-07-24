package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class MonsterInfoActivitiy extends AppCompatActivity {

    TextView gameInfo;
    PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);

        gameInfo = findViewById(R.id.gameText);
        photoView = (PhotoView) findViewById(R.id.monsterView);

        String title = getIntent().getExtras().getString("TITLE");
        getSupportActionBar().setTitle(title);
        getContentBasedOnTitle(title);
        getPictureBasedOnTitle(title);

    }

    public void getContentBasedOnTitle(String title) {
        String textToShow;
        switch (title) {
            case "GOBLIN\n":  textToShow = getString(R.string.goblin);
                break;
            case "KOBOLD\n":  textToShow = getString(R.string.kobolds);
                break;
            case "WOLF\n":  textToShow = getString(R.string.wolves);
                break;
            case "BANDITS":  textToShow = getString(R.string.bandits);
                break;
            default: textToShow = "Invalid title";
                break;
        }

        gameInfo.setText(textToShow);
    }

    public void getPictureBasedOnTitle(String title){

        switch (title){
            case "GOBLIN\n": photoView.setImageResource(R.drawable.goblin);
                break;
            case "KOBOLD\n": photoView.setImageResource(R.drawable.kobold);
                break;
        }
    }



    public void goToMonDetection(View view) {
        Intent intent = new Intent(this, MonsterDetectionActivity.class);
        startActivity(intent);
    }
}
