package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import models.Elf;
import models.Human;
import models.Wolf;
import pl.droidsonroids.gif.GifImageView;

public class DungeonMenu extends AppCompatActivity {
    public Bundle bundles;
    private boolean wolf;
    private boolean elf;
    private boolean human;
    private GifImageView enemyImg, characterImg;
    private TextView enemyHealth, characterStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_menu);
        enemyImg = findViewById(R.id.enemyChar);
        characterImg = findViewById(R.id.characterChar);
        enemyHealth = findViewById(R.id.enemyHealth);
        characterStats = findViewById(R.id.playerStats);
        bundles = getIntent().getExtras();
        wolf = bundles.getBoolean("WOLF");
        elf = bundles.getBoolean("ELF");
        human = bundles.getBoolean("HUMAN");

        if(wolf){
            characterStats.setText(new Wolf().toString());
            characterImg.setImageResource(getResources().getIdentifier("wolf.gif","drawable",getPackageName()));
        }else if(elf){
            characterStats.setText(new Elf().toString());
            characterImg.setImageResource(getResources().getIdentifier("elf.gif","drawable",getPackageName()));
        }else if(human){
            characterStats.setText(new Human().toString());
            characterImg.setBackgroundResource(getResources().getIdentifier("human.gif", "drawable", getPackageName()));
        }
    }

    public void onClick_Attack(View v){
        //TODO Ethan
    }

    public void onClick_Potion(View v){
        //TODO Kayla
    }

    public void onClick_Continue(View v){
        //TODO Ethan
    }

    public void levelUP() {
        //TODO Kayla
    }

    public void updateStats(){
        //TODO Kayla
    }
    public void enemyDeath(){
        //TODO KAT
    }

    public void displayStory(){
        //TODO KAT
    }
    public void enemyCounter(){
        //TODO KAT
    }
}
