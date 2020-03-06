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
    private boolean wolfPlayer, elfPlayer, humanPlayer;
    private GifImageView elfImg, humanImg, wolfImg;
    private TextView enemyHealth, characterStats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_menu);
        //enemyImg = findViewById(R.id.enemyChar);
        elfImg = findViewById(R.id.elfChar);
        humanImg = findViewById(R.id.humanChar);
        wolfImg = findViewById(R.id.wolfChar);
        enemyHealth = findViewById(R.id.enemyHealth);
        characterStats = findViewById(R.id.playerStats);
        bundles = getIntent().getExtras();
        wolfPlayer = bundles.getBoolean("WOLF");
        elfPlayer = bundles.getBoolean("ELF");
        humanPlayer = bundles.getBoolean("HUMAN");

        if(wolfPlayer){
           characterStats.setText(new Wolf().toString());
           elfImg.setVisibility(View.INVISIBLE);
           humanImg.setVisibility(View.INVISIBLE);
           wolfImg.setVisibility(View.VISIBLE);

        }else if(elfPlayer){
            characterStats.setText(new Elf().toString());
            wolfImg.setVisibility(View.INVISIBLE);
            humanImg.setVisibility(View.INVISIBLE);
            elfImg.setVisibility(View.VISIBLE);

        }else if(humanPlayer){
            characterStats.setText(new Human().toString());
            wolfImg.setVisibility(View.INVISIBLE);
            elfImg.setVisibility(View.INVISIBLE);
            humanImg.setVisibility(View.VISIBLE);

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
        int WOLF_PLACEHOLDER = -1;
        int ELF_PLACEHOLDER= -1;
        int HUMAN_PLACEHOLDER = -1;
        switch (playerType){
            case "Wolf":
                player.setMaxHealth(WOLF_PLACEHOLDER);
                player.setHealth(player.getMaxHealth());

                player.setAttackPower(player.getAttackPower() + WOLF_PLACEHOLDER );
                player.setDefense(WOLF_PLACEHOLDER);
                break;
            case "Elf":
                player.setMaxHealth(ELF_PLACEHOLDER);
                player.setHealth(player.getMaxHealth());

                player.setAttackPower(player.getAttackPower() + ELF_PLACEHOLDER );
                player.setDefense(ELF_PLACEHOLDER);
                break;
            case "Human":
                player.setMaxHealth(HUMAN_PLACEHOLDER);
                player.setHealth(player.getMaxHealth());

                player.setAttackPower(player.getAttackPower() + HUMAN_PLACEHOLDER );
                player.setDefense(player.getDefense() + HUMAN_PLACEHOLDER);
                break;
        }
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
