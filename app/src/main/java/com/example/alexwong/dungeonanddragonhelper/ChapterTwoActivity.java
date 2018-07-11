package com.example.alexwong.dungeonanddragonhelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ChapterTwoActivity extends AppCompatActivity {
    TextView chapterTwoText;
    TextView chapterTwoSideQuest;
    TextView chapterTwoObjective;
    TextView chapterTwoMainDungeon;
    TextView chapterTwoToChapterThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two);

        chapterTwoText = (TextView) findViewById(R.id.chapterTwoStart);
        chapterTwoSideQuest = (TextView) findViewById(R.id.chapterTwoSideQuest);
        chapterTwoObjective = (TextView) findViewById(R.id.chapterTwoObjective);
        chapterTwoMainDungeon = (TextView) findViewById(R.id.chapterTwoObjectiveDungeon);
        chapterTwoToChapterThree = (TextView) findViewById(R.id.chapterTwoEnd);
        final Button townButton2 = findViewById(R.id.townButtonCh2);

        if(savedInstanceState !=null){
            String ch2StartSave = savedInstanceState.getString("ch2Begin");
            chapterTwoText.setText(ch2StartSave);
            String ch2SideQuestSave = savedInstanceState.getString("ch2SQ");
            chapterTwoSideQuest.setText(ch2SideQuestSave);
            String ch2Obj = savedInstanceState.getString("ch2OBJ");
            chapterTwoObjective.setText(ch2Obj);
            String ch2MD = savedInstanceState.getString("ch2MD");
            chapterTwoMainDungeon.setText(ch2MD);
            String ch2Ch3 = savedInstanceState.getString("ch2CH3");
            chapterTwoToChapterThree.setText(ch2Ch3);
        }

        String sPCh2Begin = getPreferences(Context.MODE_PRIVATE).getString("ch2Begin", "");
        if(!sPCh2Begin.equals("")){
            chapterTwoText.setText(sPCh2Begin);
        }
        String sPCh2SQ = getPreferences(Context.MODE_PRIVATE).getString("ch2SQ", "");
        if(!sPCh2SQ.equals("")){
            chapterTwoSideQuest.setText(sPCh2SQ);
        }
        String sPCh2OBJ = getPreferences(Context.MODE_PRIVATE).getString("ch2OBJ", "");
        if(!sPCh2OBJ.equals("")){
            chapterTwoObjective.setText(sPCh2OBJ);
        }
        String sPCh2MD = getPreferences(Context.MODE_PRIVATE).getString("ch2MD", "");
        if(!sPCh2MD.equals("")){
            chapterTwoMainDungeon.setText(sPCh2MD);
        }
        String sPCh2Ch3 = getPreferences(Context.MODE_PRIVATE).getString("ch2CH3", "");
        if(!sPCh2Ch3.equals("")){
            chapterTwoToChapterThree.setText(sPCh2Ch3);
        }

        chapterTwoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu town2Pop = new PopupMenu(ChapterTwoActivity.this, chapterTwoText);
                town2Pop.getMenuInflater().inflate(R.menu.ch2townpopup, town2Pop.getMenu());
                town2Pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterTwoActivity.this,"You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterTwoText.setText(R.string.ch2SelectedTown);
                        chapterTwoText.append(item.getTitle());
                        return true;
                    }
                });

                town2Pop.show();
                townButton2.setVisibility(View.VISIBLE);
            }
        });

        chapterTwoSideQuest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu sidequest2Pop = new PopupMenu(ChapterTwoActivity.this, chapterTwoSideQuest);
                sidequest2Pop.getMenuInflater().inflate(R.menu.ch2sidequestpop_menu, sidequest2Pop.getMenu());
                sidequest2Pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterTwoActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterTwoSideQuest.setText(R.string.ch2SelectedSideQuest);
                        chapterTwoSideQuest.append(item.getTitle());
                        return true;
                    }
                });

                sidequest2Pop.show();
            }

        });

        chapterTwoObjective.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu objective2Pop = new PopupMenu(ChapterTwoActivity.this, chapterTwoObjective);
                objective2Pop.getMenuInflater().inflate(R.menu.ch2mainquestpop_menu, objective2Pop.getMenu());
                objective2Pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterTwoActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterTwoObjective.setText(R.string.chapter2selectedquesthint);
                        chapterTwoObjective.append(item.getTitle());
                        return true;
                    }
                });

                objective2Pop.show();
            }
        });

        chapterTwoMainDungeon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch2Dungeon = new PopupMenu(ChapterTwoActivity.this, chapterTwoMainDungeon);
                ch2Dungeon.getMenuInflater().inflate(R.menu.ch2mainquestdungeon_menu, ch2Dungeon.getMenu());
                ch2Dungeon.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterTwoActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterTwoMainDungeon.setText(R.string.chapterTwoSelectedObjectiveRumor);
                        chapterTwoMainDungeon.append(item.getTitle());
                        return true;
                    }
                });

                ch2Dungeon.show();
            }
        });

        chapterTwoToChapterThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch2End = new PopupMenu(ChapterTwoActivity.this, chapterTwoToChapterThree);
                ch2End.getMenuInflater().inflate(R.menu.ch2toch3pop_menu, ch2End.getMenu());
                ch2End.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterTwoActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterTwoToChapterThree.setText(R.string.chapterTwoSelectedEnd);
                        chapterTwoToChapterThree.append(item.getTitle());
                        return true;
                    }
                });

                ch2End.show();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("ch2Begin", chapterTwoText.getText().toString());
        outState.putString("ch2SQ", chapterTwoSideQuest.getText().toString());
        outState.putString("ch2OBJ", chapterTwoObjective.getText().toString());
        outState.putString("ch2MD", chapterTwoMainDungeon.getText().toString());
        outState.putString("ch2CH3", chapterTwoToChapterThree.getText().toString());

        super.onSaveInstanceState(outState);
    }

    private void saveSettings(){
        SharedPreferences.Editor sPEditor = getPreferences(Context.MODE_PRIVATE).edit();

        sPEditor.putString("ch2Begin", chapterTwoText.getText().toString());
        sPEditor.putString("ch2SQ", chapterTwoSideQuest.getText().toString());
        sPEditor.putString("ch2OBJ", chapterTwoObjective.getText().toString());
        sPEditor.putString("ch2MD", chapterTwoMainDungeon.getText().toString());
        sPEditor.putString("ch2CH3", chapterTwoToChapterThree.getText().toString());

        sPEditor.apply();

    }

    @Override
    protected void onStop() {
        saveSettings();
        super.onStop();
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, AdventureActivity.class);
        startActivity(intent);
    }

    public void newCampaign(View view) {
        chapterTwoText.setText(R.string.ch2Start);
        chapterTwoSideQuest.setText(R.string.chapter2Objective);
        chapterTwoObjective.setText(R.string.chapter2quest);
        chapterTwoMainDungeon.setText(R.string.chapterTwoObjectiveRumor);
        chapterTwoToChapterThree.setText(R.string.chapterTwoToChapterThreeReason);
    }

    public void goToChapterThree(View view) {
        Intent intent = new Intent(this, ChapterThreeActivity.class);
        startActivity(intent);
    }

    public void goToMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}