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
import android.widget.Button;
import android.widget.TextView;

import models.Character;
import models.Gnome;
import models.Hero;
import models.Human;
import models.Wolf;

public class DungeonMenu extends AppCompatActivity {
    public Bundle bundles;
    private boolean wolf;
    private boolean elf;
    private boolean human;
    private GifImageView enemyImg, characterImg;
    private TextView enemyHealth, characterStats;
    private int enemyCounter = 0;

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
    Hero player = new Wolf();
    int potions = 3;
    //Placeholder

    public void onClick_Attack(View v){
        //TODO Ethan
    }

    public void onClick_Potion(View v){
        //TODO Kayla
        if(potions > 0){
            if (player.getHealth() + 50 > player.getMaxHealth()){
                player.setHealth(player.getMaxHealth());
            }else{
                player.setHealth(player.getHealth() + 50);
            }
            potions--;
        }
        if (potions == 0){
            //MAKE BUTTON DISABLE
        }
    }

    public void onClick_Continue(View v){
        //TODO Ethan
    }

    public void levelUP() {
        //TODO Kayla
        if(player.getExp()>=100){
            player.setExp(0);
            if(player.getClass().getSimpleName().equals("Wolf")){
                updateStats("Wolf");
            }
            if(player.getClass().getSimpleName().equals("Elf")){
                updateStats("Elf");
            }
            if(player.getClass().getSimpleName().equals("Human")){
                updateStats("Human");
            }
        }
    }

    public void updateStats(String playerType){
        //TODO Kayla
        switch (playerType){
            case "Wolf":
                player.setMaxHealth(player.getMaxHealth() + 10);
                player.setHealth(player.getMaxHealth());
                player.setAttackPower(player.getAttackPower() + 2 );
                break;
            case "Elf":
                player.setMaxHealth(player.getMaxHealth() + 6);
                player.setHealth(player.getMaxHealth());
                player.setAttackPower(player.getAttackPower() + 6 );
                break;
            case "Human":
                player.setMaxHealth(player.getMaxHealth() + 8);
                player.setHealth(player.getMaxHealth());
                player.setAttackPower(player.getAttackPower() + 4 );
                break;
        }
    }
    public void enemyDeath(){
        //TODO KAT
    }

    public void displayStory(){
        //TODO KAT
    }

}
