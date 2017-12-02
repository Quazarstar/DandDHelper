package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
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
            }
        });

    }

    public void returnHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void goChapterTwo(View view) {
        Intent intent = new Intent(this, ChapterTwoActivity.class);
        startActivity(intent);
    }
}
