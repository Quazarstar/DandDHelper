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
    TextView traitInfo;
    TextView attackInfo;
    TextView armorInfo;
    TextView statsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);

        gameInfo = findViewById(R.id.gameText);
        photoView = (PhotoView) findViewById(R.id.monsterView);
        traitInfo = findViewById(R.id.traitsText);
        attackInfo = findViewById(R.id.attacksText);
        armorInfo = findViewById(R.id.armorText);
        statsInfo = findViewById(R.id.statsText);

        String title = getIntent().getExtras().getString("TITLE");
        getSupportActionBar().setTitle(title);
        getFlavourTextBasedOnTitle(title);
        getTraitTextBasedOnTitle(title);
        getAttacksBasedOnTitle(title);
        getArmorBasedOnTitle(title);
        getStatsBasedOnTitle(title);
        getPictureBasedOnTitle(title);
    }

    public void getFlavourTextBasedOnTitle(String title) {
        String textToShow;
        switch (title) {
            case "GOBLIN\n":  textToShow = getString(R.string.goblin);
                break;
            case "KOBOLD\n":  textToShow = getString(R.string.kobolds);
                break;
            case "WOLF\n":  textToShow = getString(R.string.wolves);
                break;
            case "BANDIT\n":  textToShow = getString(R.string.bandits);
                break;
            default: textToShow = "Invalid title";
                break;
        }

        gameInfo.setText(textToShow);
    }

    public void getTraitTextBasedOnTitle(String title){
        String traitToShow = "";
        switch (title){
            case "GOBLIN\n": traitToShow = getString(R.string.goblinTrait);
                break;
            case "KOBOLD\n": traitToShow = getString(R.string.koboldTrait);
                break;
        }
        traitInfo.setText(traitToShow);
    }

    public void getAttacksBasedOnTitle(String title){
        String attackToShow = "";
        switch(title){
            case "GOBLIN\n": attackToShow = getString(R.string.goblinAttacks);
                break;
            case "KOBOLD\n": attackToShow = getString(R.string.koboldAttacks);
                break;
        }
        attackInfo.setText(attackToShow);
    }

    public void getArmorBasedOnTitle(String title){
        String armorToShow = "";
        switch(title){
            case "GOBLIN\n": armorToShow = getString(R.string.goblinArmor);
                break;
            case "KOBOLD\n": armorToShow = getString(R.string.koboldArmor);
                break;
        }
        armorInfo.setText(armorToShow);
    }

    public void getStatsBasedOnTitle(String title){
        String statsToShow = "";
        switch(title){
            case "GOBLIN\n": statsToShow = getString(R.string.goblinStats);
                break;
            case "KOBOLD\n": statsToShow = getString(R.string.koboldStats);
                break;
        }
        statsInfo.setText(statsToShow);
    }

    public void getPictureBasedOnTitle(String title){
        switch (title){
            case "GOBLIN\n": photoView.setImageResource(R.drawable.goblin);
                break;
            case "KOBOLD\n": photoView.setImageResource(R.drawable.kobold);
                break;
            case "WOLF\n": photoView.setImageResource(R.drawable.wolves);
                break;
            case "BANDIT\n": photoView.setImageResource(R.drawable.bandit);
                break;
        }
    }



    public void goToMonDetection(View view) {
        Intent intent = new Intent(this, MonsterDetectionActivity.class);
        startActivity(intent);
    }

    public void returnHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
