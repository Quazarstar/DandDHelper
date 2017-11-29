package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AdventureActivity extends AppCompatActivity {

TextView beginningtext;
TextView beginningQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

        beginningQuest = (TextView) findViewById(R.id.chapterOneQuest);
        beginningtext = (TextView) findViewById(R.id.beginningtext);

        beginningtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                PopupMenu heroPop = new PopupMenu(AdventureActivity.this, beginningtext);
                heroPop.getMenuInflater().inflate(R.menu.heropop_menu, heroPop.getMenu());
                heroPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(AdventureActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(AdventureActivity.this, "You Clicked : " + questItem.getTitle(), Toast.LENGTH_SHORT).show();
                        beginningQuest.setText(R.string.selectedQuest);
                        beginningQuest.append(questItem.getTitle());
                        return true;
                    }
                });

                questPop.show();
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
