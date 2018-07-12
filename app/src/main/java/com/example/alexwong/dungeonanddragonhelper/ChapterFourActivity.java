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

public class ChapterFourActivity extends AppCompatActivity {

    TextView chapterFourStart;
    TextView chapterFourClue;
    TextView chapterFourDestination;
    TextView chapterFourBattle;
    TextView chapterFourEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_four);

        chapterFourStart = (TextView) findViewById(R.id.chapterFourStart);
        chapterFourClue = (TextView) findViewById(R.id.chapterFourClue);
        chapterFourDestination = (TextView) findViewById(R.id.chapterFourDestination);
        chapterFourBattle = (TextView) findViewById(R.id.chapterFourBattle);
        chapterFourEnd = (TextView) findViewById(R.id.chapterFourEnd);
        final Button mapButton4 = findViewById(R.id.mapButtonCh4);
        final Button mapButtonDung4 = findViewById(R.id.mapButtonCh4Dungeon);

        if(savedInstanceState !=null){
            String ch4StartSave = savedInstanceState.getString("ch4Begin");
            chapterFourStart.setText(ch4StartSave);
            String ch3ClueSave = savedInstanceState.getString("ch4Clue");
            chapterFourClue.setText(ch3ClueSave);
            String ch4LocalSave = savedInstanceState.getString("ch4Local");
            chapterFourDestination.setText(ch4LocalSave);
            String ch4BatSave = savedInstanceState.getString("ch4Bat");
            chapterFourBattle.setText(ch4BatSave);
            String ch4End = savedInstanceState.getString("ch4End");
            chapterFourEnd.setText(ch4End);
        }

        String sPCH4Start = getPreferences(Context.MODE_PRIVATE).getString("ch4Begin", "");
        if(!sPCH4Start.equals("")){
            chapterFourStart.setText(sPCH4Start);
        }
        String sPCH4Clue = getPreferences(Context.MODE_PRIVATE).getString("ch4Clue", "");
        if(!sPCH4Clue.equals("")){
            chapterFourClue.setText(sPCH4Clue);
        }
        String sPCH4Local = getPreferences(Context.MODE_PRIVATE).getString("ch4Local", "");
        if(!sPCH4Local.equals("")){
            chapterFourDestination.setText(sPCH4Local);
        }
        String sPCH4Bat = getPreferences(Context.MODE_PRIVATE).getString("ch4Bat", "");
        if(!sPCH4Bat.equals("")){
            chapterFourBattle.setText(sPCH4Bat);
        }
        String sPCH4End = getPreferences(Context.MODE_PRIVATE).getString("ch4End", "");
        if(!sPCH4End.equals("")){
            chapterFourEnd.setText(sPCH4End);
        }

        chapterFourStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu ch4startPop = new PopupMenu(ChapterFourActivity.this, chapterFourStart);
                ch4startPop.getMenuInflater().inflate(R.menu.chapter4beginpopup, ch4startPop.getMenu());
                ch4startPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFourActivity.this,"You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFourStart.setText(R.string.ch4SelectedStart);
                        chapterFourStart.append(item.getTitle());
                        return true;
                    }
                });

                ch4startPop.show();
                mapButton4.setVisibility(View.VISIBLE);
            }
        });

        chapterFourClue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch4cluePop = new PopupMenu(ChapterFourActivity.this, chapterFourClue);
                ch4cluePop.getMenuInflater().inflate(R.menu.chapter4cluepopup, ch4cluePop.getMenu());
                ch4cluePop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFourActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFourClue.setText(R.string.ch4SelectedClue);
                        chapterFourClue.append(item.getTitle());
                        return true;
                    }
                });

                ch4cluePop.show();
            }

        });

        chapterFourDestination.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch4LocalPop = new PopupMenu(ChapterFourActivity.this, chapterFourDestination);
                ch4LocalPop.getMenuInflater().inflate(R.menu.chapter4localpopup, ch4LocalPop.getMenu());
                ch4LocalPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFourActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFourDestination.setText(R.string.ch4SelectedLocal);
                        chapterFourDestination.append(item.getTitle());
                        return true;
                    }
                });

                ch4LocalPop.show();
                mapButtonDung4.setVisibility(View.VISIBLE);
            }
        });

        chapterFourBattle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch4RitualPop = new PopupMenu(ChapterFourActivity.this, chapterFourBattle);
                ch4RitualPop.getMenuInflater().inflate(R.menu.chapter4battlepopup, ch4RitualPop.getMenu());
                ch4RitualPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFourActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFourBattle.setText(R.string.ch4SelectedRitual);
                        chapterFourBattle.append(item.getTitle());
                        return true;
                    }
                });

                ch4RitualPop.show();
            }
        });

        chapterFourEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch4EndPop = new PopupMenu(ChapterFourActivity.this, chapterFourEnd);
                ch4EndPop.getMenuInflater().inflate(R.menu.chapter4endpopup, ch4EndPop.getMenu());
                ch4EndPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterFourActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterFourEnd.setText(R.string.ch4SelectedEnd);
                        chapterFourEnd.append(item.getTitle());
                        return true;
                    }
                });

                ch4EndPop.show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("ch4Begin", chapterFourStart.getText().toString());
        outState.putString("ch4Clue", chapterFourClue.getText().toString());
        outState.putString("ch4Local", chapterFourDestination.getText().toString());
        outState.putString("ch4Bat", chapterFourBattle.getText().toString());
        outState.putString("ch4End", chapterFourEnd.getText().toString());

        super.onSaveInstanceState(outState);
    }

    private void saveSettings(){
        SharedPreferences.Editor sPEditor = getPreferences(Context.MODE_PRIVATE).edit();

        sPEditor.putString("ch4Begin", chapterFourStart.getText().toString());
        sPEditor.putString("ch4Clue", chapterFourClue.getText().toString());
        sPEditor.putString("ch4Local", chapterFourDestination.getText().toString());
        sPEditor.putString("ch4Bat", chapterFourBattle.getText().toString());
        sPEditor.putString("ch4End", chapterFourEnd.getText().toString());

        sPEditor.apply();

    }

    @Override
    protected void onStop() {
        saveSettings();
        super.onStop();
    }

    public void goToMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ChapterThreeActivity.class);
        startActivity(intent);
    }

    public void newCampaign(View view) {
        chapterFourStart.setText(R.string.ch4start);
        chapterFourClue.setText(R.string.ch4Discovery);
        chapterFourDestination.setText(R.string.ch4Discovery);
        chapterFourBattle.setText(R.string.ch4Battle);
        chapterFourEnd.setText(R.string.ch4End);
    }
}
