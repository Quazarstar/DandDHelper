package com.example.alexwong.dungeonanddragonhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class AdventureActivity extends AppCompatActivity {

TextView beginningtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

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

    }

    public void returnHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
