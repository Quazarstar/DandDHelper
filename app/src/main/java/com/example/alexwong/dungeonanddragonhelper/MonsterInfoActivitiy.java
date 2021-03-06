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
            case "IMP\n": textToShow = getString(R.string.imp);
                break;
            case "SKELETON\n": textToShow = getString(R.string.skeletons);
                break;
            case "ZOMBIE\n": textToShow = getString(R.string.zombies);
                break;
            case "DARK\u0020MAGE\n": textToShow = getString(R.string.darkMage);
                break;
            case "DEMON\u0020LORD\n": textToShow = getString(R.string.demonLord);
                break;
            case "ASSASSIN\n": textToShow = getString(R.string.assassin);
                break;
            case "EVIL\u0020KNIGHT\n": textToShow = getString(R.string.evilKnight);
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
            case "BANDIT\n": traitToShow = getString(R.string.banditTrait);
                break;
            case "WOLF\n": traitToShow = getString(R.string.wolfTrait);
                break;
            case "IMP\n": traitToShow = getString(R.string.impTrait);
                break;
            case "SKELETON\n": traitToShow = getString(R.string.skeletonTrait);
                break;
            case "ZOMBIE\n": traitToShow = getString(R.string.zombieTrait);
                break;
            case "DARK\u0020MAGE\n": traitToShow = getString(R.string.darkMageTrait);
                break;
            case "DEMON\u0020LORD\n": traitToShow = getString(R.string.demonLordTrait);
                break;
            case "ASSASSIN\n": traitToShow = getString(R.string.assassinTrait);
                break;
            case "EVIL\u0020KNIGHT\n": traitToShow = getString(R.string.evilKnightTrait);
                break;
            default: traitToShow = "Invalid title";
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
            case "BANDIT\n": attackToShow = getString(R.string.banditAttacks);
                break;
            case "WOLF\n": attackToShow = getString(R.string.wolfAttacks);
                break;
            case "IMP\n": attackToShow = getString(R.string.impAttacks);
                break;
            case "SKELETON\n": attackToShow = getString(R.string.skeletonAttacks);
                break;
            case "ZOMBIE\n": attackToShow = getString(R.string.zombieAttacks);
                break;
            case "DARK\u0020MAGE\n": attackToShow = getString(R.string.darkMageAttacks);
                break;
            case "DEMON\u0020LORD\n": attackToShow = getString(R.string.demonLordAttacks);
                break;
            case "ASSASSIN\n": attackToShow = getString(R.string.assassinAttacks);
                break;
            case "EVIL\u0020KNIGHT\n": attackToShow = getString(R.string.evilKnightAttacks);
                break;
            default: attackToShow = "Invalid title";
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
            case "BANDIT\n": armorToShow = getString(R.string.banditArmor);
                break;
            case "WOLF\n": armorToShow = getString(R.string.wolfArmor);
                break;
            case "IMP\n": armorToShow = getString(R.string.impArmor);
                break;
            case "SKELETON\n": armorToShow = getString(R.string.skeletonArmor);
                break;
            case "ZOMBIE\n": armorToShow = getString(R.string.zombieArmor);
                break;
            case "DARK\u0020MAGE\n": armorToShow = getString(R.string.darkMageArmor);
                break;
            case "DEMON\u0020LORD\n": armorToShow = getString(R.string.demonLordArmor);
                break;
            case "ASSASSIN\n": armorToShow = getString(R.string.assassinArmor);
                break;
            case "EVIL\u0020KNIGHT\n": armorToShow = getString(R.string.evilKnightArmor);
                break;
            default: armorToShow = "Invalid title";
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
            case "BANDIT\n": statsToShow = getString(R.string.banditStats);
                break;
            case "WOLF\n": statsToShow = getString(R.string.wolfStats);
                break;
            case "IMP\n": statsToShow = getString(R.string.impStats);
                break;
            case "SKELETON\n": statsToShow = getString(R.string.skeletonStats);
                break;
            case "ZOMBIE\n": statsToShow = getString(R.string.zombieStats);
                break;
            case "DARK\u0020MAGE\n": statsToShow = getString(R.string.darkMageStats);
                break;
            case "DEMON\u0020LORD\n": statsToShow = getString(R.string.demonLordStats);
                break;
            case "ASSASSIN\n": statsToShow = getString(R.string.assassinStats);
                break;
            case "EVIL\u0020KNIGHT\n": statsToShow = getString(R.string.evilKnightStats);
                break;
            default: statsToShow = "Invalid title";
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
            case "BANDIT\n": photoView.setImageResource(R.drawable.banditicon);
                break;
            case "IMP\n": photoView.setImageResource(R.drawable.imp);
                break;
            case "SKELETON\n": photoView.setImageResource(R.drawable.skeleton);
                break;
            case "ZOMBIE\n": photoView.setImageResource(R.drawable.zombie);
                break;
            case "DARK\u0020MAGE\n": photoView.setImageResource(R.drawable.darkmage);
                break;
            case "DEMON\u0020LORD\n": photoView.setImageResource(R.drawable.demonlord);
                break;
            case "ASSASSIN\n": photoView.setImageResource(R.drawable.assassin);
                break;
            case "EVIL\u0020KNIGHT\n": photoView.setImageResource(R.drawable.evilknight);
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
