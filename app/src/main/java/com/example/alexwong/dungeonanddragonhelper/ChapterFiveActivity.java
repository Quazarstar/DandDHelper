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

public class ChapterFiveActivity extends AppCompatActivity {

    TextView chapterFiveStart;
    TextView chapterFiveEncounter;
    TextView chapterFiveTurn;
    TextView chapterFiveBoss;
    TextView chapterFiveEnd;
    TextView chapterFiveThanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_five);

        chapterFiveStart = (TextView) findViewById(R.id.chapterFiveStart);
        chapterFiveEncounter = (TextView) findViewById(R.id.chapterFiveEncounter);
        chapterFiveTurn = (TextView) findViewById(R.id.chapterFiveTurn);
        chapterFiveBoss = (TextView) findViewById(R.id.chapterFiveFinalBoss);
        chapterFiveEnd = (TextView) findViewById(R.id.chapterFiveEnd);
        chapterFiveThanks = (TextView) findViewById(R.id.chapterFiveThanks);
        final Button mapButton5 = findViewById(R.id.mapButtonCh5);
        final Button battleButton5 = findViewById(R.id.encounterButtonCh5);

        if(savedInstanceState !=null){
            String ch5StartSave = savedInstanceState.getString("ch5Begin");
            chapterFiveStart.setText(ch5StartSave);
            String ch5EncounterSave = savedInstanceState.getString("ch5Encounter");
            chapterFiveEncounter.setText(ch5EncounterSave);
            String ch5TurnSave = savedInstanceState.getString("ch5Turn");
            chapterFiveTurn.setText(ch5TurnSave);
            String ch5BossSave = savedInstanceState.getString("ch5Boss");
            chapterFiveBoss.setText(ch5BossSave);
            String ch5EndSave = savedInstanceState.getString("ch5End");
            chapterFiveEnd.setText(ch5EndSave);
        }

        String sPCH5Start = getPreferences(Context.MODE_PRIVATE).getString("ch5Begin", "");
        if(!sPCH5Start.equals("")){
            chapterFiveStart.setText(sPCH5Start);
        }
        String sPCH5Encounter = getPreferences(Context.MODE_PRIVATE).getString("ch5Encounter", "");
        if(!sPCH5Encounter.equals("")){
            chapterFiveEncounter.setText(sPCH5Encounter);
        }
        String sPCH5Turn = getPreferences(Context.MODE_PRIVATE).getString("ch5Turn", "");
        if(!sPCH5Turn.equals("")){
            chapterFiveTurn.setText(sPCH5Turn);
        }
        String sPCH5Boss = getPreferences(Context.MODE_PRIVATE).getString("ch5Boss", "");
        if(!sPCH5Boss.equals("")){
            chapterFiveBoss.setText(sPCH5Boss);
        }
        String sPCH5End = getPreferences(Context.MODE_PRIVATE).getString("ch5End", "");
        if(!sPCH5End.equals("")){
            chapterFiveEnd.setText(sPCH5End);
        }

        chapterFiveStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu ch5StartPop = new PopupMenu(ChapterFiveActivity.this, chapterFiveStart);
                ch5StartPop.getMenuInflater().inflate(R.menu.chapter5startpopup, ch5StartPop.getMenu());
                ch5StartPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFiveActivity.this,"You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFiveStart.setText(R.string.ch5SelectedStart);
                        chapterFiveStart.append(item.getTitle());
                        return true;
                    }
                });

                ch5StartPop.show();
                mapButton5.setVisibility(View.VISIBLE);
            }
        });

        chapterFiveEncounter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch5EncounterPop = new PopupMenu(ChapterFiveActivity.this, chapterFiveEncounter);
                ch5EncounterPop.getMenuInflater().inflate(R.menu.chapter5encoutnerpopup, ch5EncounterPop.getMenu());
                ch5EncounterPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFiveActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFiveEncounter.setText(R.string.ch5SelectedEncounter);
                        chapterFiveEncounter.append(item.getTitle());
                        return true;
                    }
                });

                ch5EncounterPop.show();
                battleButton5.setVisibility(View.VISIBLE);
            }

        });

        chapterFiveTurn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch5TurnPop = new PopupMenu(ChapterFiveActivity.this, chapterFiveTurn);
                ch5TurnPop.getMenuInflater().inflate(R.menu.chapter5turnpopup, ch5TurnPop.getMenu());
                ch5TurnPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFiveActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFiveTurn.setText(R.string.ch5SelectedTurn);
                        chapterFiveTurn.append(item.getTitle());
                        return true;
                    }
                });

                ch5TurnPop.show();
            }
        });

        chapterFiveBoss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch4RitualPop = new PopupMenu(ChapterFiveActivity.this, chapterFiveBoss);
                ch4RitualPop.getMenuInflater().inflate(R.menu.chapter5finalbosspopup, ch4RitualPop.getMenu());
                ch4RitualPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFiveActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFiveBoss.setText(R.string.ch5SelectedBoss);
                        chapterFiveBoss.append(item.getTitle());
                        return true;
                    }
                });

                ch4RitualPop.show();
            }
        });

        chapterFiveEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch4EndPop = new PopupMenu(ChapterFiveActivity.this, chapterFiveEnd);
                ch4EndPop.getMenuInflater().inflate(R.menu.chapter5endpopup, ch4EndPop.getMenu());
                ch4EndPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFiveActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFiveEnd.setText(R.string.ch5SelectedEnd);
                        chapterFiveEnd.append(item.getTitle());
                        return true;
                    }
                });

                ch4EndPop.show();
                chapterFiveThanks.setVisibility(View.VISIBLE);
            }
        });

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("ch5Begin", chapterFiveStart.getText().toString());
        outState.putString("ch5Encounter", chapterFiveEncounter.getText().toString());
        outState.putString("ch5Turn", chapterFiveTurn.getText().toString());
        outState.putString("ch5Boss", chapterFiveBoss.getText().toString());
        outState.putString("ch5End", chapterFiveEnd.getText().toString());

        super.onSaveInstanceState(outState);
    }

    private void saveSettings(){
        SharedPreferences.Editor sPEditor = getPreferences(Context.MODE_PRIVATE).edit();

        sPEditor.putString("ch5Begin", chapterFiveStart.getText().toString());
        sPEditor.putString("ch5Encounter", chapterFiveEncounter.getText().toString());
        sPEditor.putString("ch5Turn", chapterFiveTurn.getText().toString());
        sPEditor.putString("ch5Boss", chapterFiveBoss.getText().toString());
        sPEditor.putString("ch5End", chapterFiveEnd.getText().toString());

        sPEditor.apply();

    }

    @Override
    protected void onStop() {
        saveSettings();
        super.onStop();
    }

    public void goToMap(View view) {
        Intent intent = new Intent(this, MapSelection.class);
        startActivity(intent);
    }

    public void goToMonDetection(View view) {
        Intent intent = new Intent(this, MonsterDetectionActivity.class);
        startActivity(intent);
    }

    public void newCampaign(View view) {
        chapterFiveStart.setText(R.string.ch5Start);
        chapterFiveEncounter.setText(R.string.ch5Encounter);
        chapterFiveTurn.setText(R.string.ch5Turn);
        chapterFiveBoss.setText(R.string.ch5FinalBoss);
        chapterFiveEnd.setText(R.string.ch5End);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ChapterFourActivity.class);
        startActivity(intent);
    }

    public void returnHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
