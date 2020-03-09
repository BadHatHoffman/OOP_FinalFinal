package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import models.Dragon;
import models.Elf;
import models.Enemy;
import models.Human;
import models.Ogre;
import models.Orc;
import models.Troll;
import models.Wolf;
import pl.droidsonroids.gif.GifImageView;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

import models.Character;
import models.Gnome;
import models.Hero;
import models.Human;
import models.Wolf;

public class DungeonMenu extends AppCompatActivity {
    public Bundle bundles;
    private boolean wolfPlayer, elfPlayer, humanPlayer;
    private GifImageView elfImg, humanImg, wolfImg;
    private TextView enemyHealth, characterStats, storyTxt;
    private Button attackButton, continueButton, potionButton;
    private int enemyCounter = 0;
    Hero player;
    Enemy enemy = new Gnome();
    Enemy[] dungeonEnemy = {new Gnome(), new Troll(), new Ogre(), new Orc(), new Dragon()};


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
        attackButton = findViewById(R.id.attackBttn);
        continueButton = findViewById(R.id.continueBttn);
        potionButton = findViewById(R.id.potionBttn);
        storyTxt = findViewById(R.id.storyTxt);
        continueButton.setEnabled(false);

        if(wolfPlayer){
           characterStats.setText(new Wolf().toString());
           elfImg.setVisibility(View.INVISIBLE);
           humanImg.setVisibility(View.INVISIBLE);
           wolfImg.setVisibility(View.VISIBLE);
           player = new Wolf();

        }else if(elfPlayer){
            characterStats.setText(new Elf().toString());
            wolfImg.setVisibility(View.INVISIBLE);
            humanImg.setVisibility(View.INVISIBLE);
            elfImg.setVisibility(View.VISIBLE);
            player = new Elf();

        }else if(humanPlayer){
            characterStats.setText(new Human().toString());
            wolfImg.setVisibility(View.INVISIBLE);
            elfImg.setVisibility(View.INVISIBLE);
            humanImg.setVisibility(View.VISIBLE);
            player = new Human();
        }
    }
    int potions = 3;

    public void onClick_Attack(View v){
        playerAttacks();
        enemyHealth.setText(enemy.toString());
        enemyAttacks();
        characterStats.setText(player.toString());
    }

    public void onClick_Potion(View v){
        //TODO Kayla
        potionButton.setText("Health: " + potions);
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
        characterStats.setText(player.toString());
    }

    public void onClick_Continue(View v){
        //TODO Ethan
        attackButton.setVisibility(View.VISIBLE);
        potionButton.setVisibility(View.VISIBLE);
        continueButton.setVisibility(View.GONE);
    }

    public void checkLevelUP() {
        //TODO Kayla
        if(player.getExp()>=100){
            player.setExp(0);
            player.levelUp();
          //  characterStats.setText("You have leveled up!\n" + player.toString() );
        }
    }

    public void updateStats(){
        //TODO Kayla

    }
    public void enemyDeath(){
        //TODO KAT
        player.setExp(player.getExp() + enemy.getExperienceWorth());
        checkLevelUP();
        enemyCounter++;
        enemy = dungeonEnemy[enemyCounter];
        continueButton.setEnabled(true);
        attackButton.setEnabled(false);
        potionButton.setEnabled(false);
    }

    public void displayStory(){
        //TODO KAT
    }

    public void playerAttacks(){
        int playerRoll = player.roll(1,20);

        if(playerRoll>=enemy.getHitNum()){
            enemy.setHealth(enemy.getHealth() - player.getAttackPower());
            storyTxt.setText("You hit the " + enemy.getClass().getSimpleName() + " for " + player.getAttackPower() + " damage!");
        } else {
            storyTxt.setText("You missed!!");
        }
        if(enemy.getHealth() <= 0){
            enemyDeath();
        }
    }
    public void enemyAttacks(){
        int enemyRoll = enemy.roll(1,20);
        if(enemyRoll>=10){
            player.setHealth(player.getHealth() - enemy.getAttackPower());
            storyTxt.append("\n\nThe " + enemy.getClass().getSimpleName() + " hits you for " + enemy.getAttackPower() + " damage!");
            //block and dodge
        } else {
            storyTxt.append("\n\nThe enemy missed!");
        }
        if(player.getHealth() <=0){
            player.setHealth(0);
            storyTxt.setText("Game Over!!");
            attackButton.setVisibility(View.GONE);
            continueButton.setVisibility(View.GONE);
            potionButton.setVisibility(View.GONE);
        }
    }
}
