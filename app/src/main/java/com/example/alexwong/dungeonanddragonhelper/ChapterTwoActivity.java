package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two);

        chapterTwoText = (TextView) findViewById(R.id.chapterTwoStart);
        chapterTwoSideQuest = (TextView) findViewById(R.id.chapterTwoObjective);

        final Button townButton2 = findViewById(R.id.townButtonCh2);

        chapterTwoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu town2Pop = new PopupMenu(ChapterTwoActivity.this, chapterTwoText);
                town2Pop.getMenuInflater().inflate(R.menu.chapter2townpopup, town2Pop.getMenu());
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

    }

    public void returnHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}