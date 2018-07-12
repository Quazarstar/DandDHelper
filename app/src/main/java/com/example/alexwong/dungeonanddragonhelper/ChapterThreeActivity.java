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

public class ChapterThreeActivity extends AppCompatActivity {

    TextView chapterThreeStart;
    TextView chapterThreeProblem;
    TextView chapterThreeContact;
    TextView chapterThreeBetray;
    TextView chapterThreeEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_three);

        chapterThreeStart = (TextView) findViewById(R.id.chapterThreeStart);
        chapterThreeProblem = (TextView) findViewById(R.id.chapterThreeProblem);
        chapterThreeContact = (TextView) findViewById(R.id.chapterThreeSolution);
        chapterThreeBetray = (TextView) findViewById(R.id.chapterThreeBetrayl);
        chapterThreeEnd = (TextView) findViewById(R.id.chapterThreeEnd);
        final Button townButton3 = findViewById(R.id.townButtonCh3);

        if(savedInstanceState !=null){
            String ch3StartSave = savedInstanceState.getString("ch3Begin");
            chapterThreeStart.setText(ch3StartSave);
            String ch3ProblemSave = savedInstanceState.getString("ch3Prob");
            chapterThreeProblem.setText(ch3ProblemSave);
            String ch3ContactSave = savedInstanceState.getString("ch3Sol");
            chapterThreeContact.setText(ch3ContactSave);
            String ch3BetraySave = savedInstanceState.getString("ch3Bet");
            chapterThreeBetray.setText(ch3BetraySave);
            String ch3End = savedInstanceState.getString("ch3End");
            chapterThreeEnd.setText(ch3End);
        }

        String sPCH3Start = getPreferences(Context.MODE_PRIVATE).getString("ch3Begin", "");
        if(!sPCH3Start.equals("")){
            chapterThreeStart.setText(sPCH3Start);
        }
        String sPCH3Prob = getPreferences(Context.MODE_PRIVATE).getString("ch3Prob", "");
        if(!sPCH3Prob.equals("")){
            chapterThreeProblem.setText(sPCH3Prob);
        }
        String sPCH3Sol = getPreferences(Context.MODE_PRIVATE).getString("ch3Sol", "");
        if(!sPCH3Sol.equals("")){
            chapterThreeContact.setText(sPCH3Sol);
        }
        String sPCH3Betray = getPreferences(Context.MODE_PRIVATE).getString("ch3Bet", "");
        if(!sPCH3Betray.equals("")){
            chapterThreeBetray.setText(sPCH3Betray);
        }
        String sPCH3End = getPreferences(Context.MODE_PRIVATE).getString("ch3End", "");
        if(!sPCH3End.equals("")){
            chapterThreeEnd.setText(sPCH3End);
        }

        chapterThreeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu town3Pop = new PopupMenu(ChapterThreeActivity.this, chapterThreeStart);
                town3Pop.getMenuInflater().inflate(R.menu.chapter3townpopup, town3Pop.getMenu());
                town3Pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterThreeActivity.this,"You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterThreeStart.setText(R.string.ch3SelectedTown);
                        chapterThreeStart.append(item.getTitle());
                        return true;
                    }
                });

                town3Pop.show();
                townButton3.setVisibility(View.VISIBLE);
            }
        });

        chapterThreeProblem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu problem3Pop = new PopupMenu(ChapterThreeActivity.this, chapterThreeProblem);
                problem3Pop.getMenuInflater().inflate(R.menu.chapter3disasterpopup, problem3Pop.getMenu());
                problem3Pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterThreeActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterThreeProblem.setText(R.string.ch3SelectedDisaster);
                        chapterThreeProblem.append(item.getTitle());
                        return true;
                    }
                });

                problem3Pop.show();
            }

        });

        chapterThreeContact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch3ContactPop = new PopupMenu(ChapterThreeActivity.this, chapterThreeContact);
                ch3ContactPop.getMenuInflater().inflate(R.menu.chapter3informantpopup, ch3ContactPop.getMenu());
                ch3ContactPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterThreeActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterThreeContact.setText(R.string.ch3SelectedContact);
                        chapterThreeContact.append(item.getTitle());
                        return true;
                    }
                });

                ch3ContactPop.show();
            }
        });

        chapterThreeBetray.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch3BetrayPop = new PopupMenu(ChapterThreeActivity.this, chapterThreeBetray);
                ch3BetrayPop.getMenuInflater().inflate(R.menu.chapter3betraylpopup, ch3BetrayPop.getMenu());
                ch3BetrayPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterThreeActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterThreeBetray.setText(R.string.ch3SelectedBetray);
                        chapterThreeBetray.append(item.getTitle());
                        return true;
                    }
                });

                ch3BetrayPop.show();
            }
        });

        chapterThreeEnd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PopupMenu ch3EndPop = new PopupMenu(ChapterThreeActivity.this, chapterThreeEnd);
                ch3EndPop.getMenuInflater().inflate(R.menu.chapter3endpopup, ch3EndPop.getMenu());
                ch3EndPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterThreeActivity.this, "You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterThreeEnd.setText(R.string.ch3SelectedEnd);
                        chapterThreeEnd.append(item.getTitle());
                        return true;
                    }
                });

                ch3EndPop.show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("ch3Begin", chapterThreeStart.getText().toString());
        outState.putString("ch3Prob", chapterThreeProblem.getText().toString());
        outState.putString("ch3Sol", chapterThreeContact.getText().toString());
        outState.putString("ch3Bet", chapterThreeBetray.getText().toString());
        outState.putString("ch3End", chapterThreeEnd.getText().toString());

        super.onSaveInstanceState(outState);
    }

    private void saveSettings(){
        SharedPreferences.Editor sPEditor = getPreferences(Context.MODE_PRIVATE).edit();

        sPEditor.putString("ch3Begin", chapterThreeStart.getText().toString());
        sPEditor.putString("ch3Prob", chapterThreeProblem.getText().toString());
        sPEditor.putString("ch3Sol", chapterThreeContact.getText().toString());
        sPEditor.putString("ch3Bet", chapterThreeBetray.getText().toString());
        sPEditor.putString("ch3End", chapterThreeEnd.getText().toString());

        sPEditor.apply();

    }

    @Override
    protected void onStop() {
        saveSettings();
        super.onStop();
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, ChapterTwoActivity.class);
        startActivity(intent);
    }

    public void newCampaign(View view) {
        chapterThreeStart.setText(R.string.ch3StartTown);
        chapterThreeProblem.setText(R.string.ch3TownDisaster);
        chapterThreeContact.setText(R.string.ch3Informant);
        chapterThreeBetray.setText(R.string.ch3betrayl);
        chapterThreeEnd.setText(R.string.ch3End);
    }

    public void goToMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void goToChapterFour(View view) {
        Intent intent = new Intent(this, ChapterFourActivity.class);
        startActivity(intent);
    }
}
