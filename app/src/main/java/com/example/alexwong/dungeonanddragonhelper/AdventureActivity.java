package com.example.alexwong.dungeonanddragonhelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class AdventureActivity extends AppCompatActivity {

TextView beginningtext;
TextView beginningQuest;
TextView beginningTown;
TextView beginningDungeon;
TextView beginningEnemies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

        beginningQuest = findViewById(R.id.chapterOneQuest);
        beginningtext = findViewById(R.id.beginningtext);
        beginningTown = findViewById(R.id.chapterOneTown);
        beginningDungeon = findViewById(R.id.oneDungeon);
        beginningEnemies = findViewById(R.id.chapterOneEnemies);
        final Button townButton = findViewById(R.id.townMapButton);
        final Button dungeonButton = findViewById(R.id.genDungeonButton);
        final Button monsterCameraButton = findViewById(R.id.monCodexButton);

        if(savedInstanceState != null){
            String beginningSave = savedInstanceState.getString("beginSave");
            beginningtext.setText(beginningSave);
            String questSave = savedInstanceState.getString("beginQuest");
            beginningQuest.setText(questSave);
            String townSave = savedInstanceState.getString("beginTown");
            beginningTown.setText(townSave);
            String dungeonSave = savedInstanceState.getString("beginDungeon");
            beginningDungeon.setText(dungeonSave);
            String enemySave = savedInstanceState.getString("beginEnemy");
            beginningEnemies.setText(enemySave);

        }

        String sPStart = getPreferences(Context.MODE_PRIVATE).getString("beginSave", "");
        if(!sPStart.equals("")){
            beginningtext.setText(sPStart);
        }
        String sPQuest = getPreferences(Context.MODE_PRIVATE).getString("beginQuest", "");
        if(!sPQuest.equals("")){
            beginningQuest.setText(sPQuest);
        }
        String sPTown = getPreferences(Context.MODE_PRIVATE).getString("beginTown", "");
        if(!sPTown.equals("")){
            beginningTown.setText(sPTown);
        }
        String sPDungeon = getPreferences(Context.MODE_PRIVATE).getString("beginDungeon", "");
        if(!sPDungeon.equals("")){
            beginningDungeon.setText(sPDungeon);
        }
        String sPEnemy = getPreferences(Context.MODE_PRIVATE).getString("beginEnemy", "");
        if(!sPEnemy.equals("")){
            beginningEnemies.setText(sPEnemy);
        }




        beginningtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu heroPop = new PopupMenu(AdventureActivity.this, beginningtext);
                heroPop.getMenuInflater().inflate(R.menu.heropop_menu, heroPop.getMenu());
                heroPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(AdventureActivity.this,"You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        beginningtext.setText(R.string.partyMembers);
                        beginningtext.append(item.getTitle());
                        return true;
                    }
                });
                heroPop.show();//showing popup menu
            }
        });//closing the setOnClickListener method



        beginningQuest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu questPop = new PopupMenu(AdventureActivity.this, beginningQuest);
                questPop.getMenuInflater().inflate(R.menu.questpop_menu, questPop.getMenu());
                questPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem questItem) {
                        Toast.makeText(AdventureActivity.this, "You Selected : " + questItem.getTitle(), Toast.LENGTH_SHORT).show();
                        beginningQuest.setText(R.string.selectedQuest);
                        beginningQuest.append(questItem.getTitle());
                        return true;
                    }
                });
                questPop.show();
            }
        });

        beginningTown.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu townPop = new PopupMenu(AdventureActivity.this, beginningTown);
                townPop.getMenuInflater().inflate(R.menu.chapter1town_menu, townPop.getMenu());
                townPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem townItem) {
                        Toast.makeText(AdventureActivity.this, "You Selected : " + townItem.getTitle(), Toast.LENGTH_SHORT).show();
                        beginningTown.setText(R.string.ch1SelectedTown);
                        beginningTown.append(townItem.getTitle());
                        return true;
                    }
                });
                townPop.show();
                townButton.setVisibility(View.VISIBLE);
            }
        });

        beginningDungeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dungeonPop = new PopupMenu(AdventureActivity.this, beginningDungeon);
                dungeonPop.getMenuInflater().inflate(R.menu.chapter1dungeon_menu, dungeonPop.getMenu());
                dungeonPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem dungeonItem) {
                        Toast.makeText(AdventureActivity.this, "You Selected : " + dungeonItem.getTitle(), Toast.LENGTH_SHORT).show();
                        beginningDungeon.setText(R.string.ch1SelectedDungeon);
                        beginningDungeon.append(dungeonItem.getTitle());
                        return true;
                    }
                });
                dungeonPop.show();
                dungeonButton.setVisibility(View.VISIBLE);
            }
        });

        beginningEnemies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu enemyPop = new PopupMenu(AdventureActivity.this, beginningEnemies);
                enemyPop.getMenuInflater().inflate(R.menu.chapter1enemy_menu, enemyPop.getMenu());
                enemyPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem enemyItem) {
                        Toast.makeText(AdventureActivity.this, "You Selected : " + enemyItem.getTitle(), Toast.LENGTH_SHORT).show();
                        beginningEnemies.setText(R.string.ch1SelectedEnemies);
                        beginningEnemies.append(enemyItem.getTitle());
                        return true;
                    }
                });
                enemyPop.show();
                monsterCameraButton.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("beginSave", beginningtext.getText().toString());
        outState.putString("beginQuest", beginningQuest.getText().toString());
        outState.putString("beginTown", beginningTown.getText().toString());
        outState.putString("beginDungeon", beginningDungeon.getText().toString());
        outState.putString("beginEnemy", beginningEnemies.getText().toString());

        super.onSaveInstanceState(outState);
    }

    private void saveSettings(){
        SharedPreferences.Editor sPEditor = getPreferences(Context.MODE_PRIVATE).edit();

        sPEditor.putString("beginSave", beginningtext.getText().toString());
        sPEditor.putString("beginQuest", beginningQuest.getText().toString());
        sPEditor.putString("beginTown", beginningTown.getText().toString());
        sPEditor.putString("beginDungeon", beginningDungeon.getText().toString());
        sPEditor.putString("beginEnemy", beginningEnemies.getText().toString());

        sPEditor.apply();
    }

    @Override
    protected void onStop() {

        saveSettings();
        super.onStop();
    }

    public void returnHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void goChapterTwo(View view) {
        Intent intent = new Intent(this, ChapterTwoActivity.class);
        startActivity(intent);
    }

    public void goToMonsterDetection(View view) {
        Intent intent = new Intent(this, MonsterDetectionActivity.class);
        startActivity(intent);
    }

    public void newCampaign(View view) {
        beginningtext.setText(R.string.begin);
        beginningQuest.setText(R.string.questObjective);
        beginningTown.setText(R.string.chapterOneTown);
        beginningDungeon.setText(R.string.ch1Dungeon);
        beginningEnemies.setText(R.string.ch1Enemies);
    }
}
