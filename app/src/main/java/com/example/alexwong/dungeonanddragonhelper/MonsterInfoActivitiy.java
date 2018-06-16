package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MonsterInfoActivitiy extends AppCompatActivity {

    TextView gameInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);

        gameInfo = findViewById(R.id.gameText);

        String title = getIntent().getExtras().getString("TITLE");
        getSupportActionBar().setTitle(title);
        getContentBasedOnTitle(title);

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



    public void goToMonDetection(View view) {
        Intent intent = new Intent(this, MonsterDetectionActivity.class);
        startActivity(intent);
    }
}
