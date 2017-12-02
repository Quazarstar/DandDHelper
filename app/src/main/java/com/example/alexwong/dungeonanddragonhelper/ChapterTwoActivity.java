package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class ChapterTwoActivity extends AppCompatActivity {
    TextView chapterTwoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_two);

        chapterTwoText = (TextView) findViewById(R.id.chapterTwoStart);

        chapterTwoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu heroPop = new PopupMenu(ChapterTwoActivity.this, chapterTwoText);
                heroPop.getMenuInflater().inflate(R.menu.chapter2townpopup, heroPop.getMenu());
                heroPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(ChapterTwoActivity.this,"You Selected : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        chapterTwoText.setText(R.string.ch2SelectedTown);
                        chapterTwoText.append(item.getTitle());
                        return true;
                    }
                });

                heroPop.show();//showing popup menu
            }
        });//closing the setOnClickListener method

    }

    public void returnHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}