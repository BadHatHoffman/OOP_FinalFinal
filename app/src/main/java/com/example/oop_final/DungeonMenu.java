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
    private int potions = 3;
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
        enemyHealth.setText(enemy.toString());
    }
    public void onClick_Attack(View v){
        playerAttacks();
        enemyHealth.setText(enemy.toString());
        enemyAttacks();
        characterStats.setText(player.toString());
    }



    public void onClick_Potion(View v){
        //TODO Kayla
        potions--;
        potionButton.setText("Health: " + potions);
        if(potions >= 0){
            if (player.getHealth() + 50 > player.getMaxHealth()){
                player.setHealth(player.getMaxHealth());
            }else{
                player.setHealth(player.getHealth() + 50);
            }
        }
        if (potions == 0){
            potionButton.setEnabled(false);
        }
        characterStats.setText(player.toString());
    }

    public void onClick_Continue(View v){
        //TODO Ethan
        attackButton.setEnabled(true);
        potionButton.setEnabled(true);
        continueButton.setEnabled(false);
        //textId.setText("");

    }

    public void checkLevelUP() {
        //TODO Kayla
        if(player.getExp()>=100){
            player.setExp(player.getExp()-100);
            player.levelUp();
            //textId.setText("Level Up! New Stats \n" +player.toString());
        }
    }

    public void enemyDeath(){
        //TODO KAT
        player.setExp(player.getExp() + enemy.getExperienceWorth());
        checkLevelUP();
        enemyCounter++;

        if (enemyCounter > 4){
            storyTxt.setText("Testing, you win!");
        } else{
            enemy = dungeonEnemy[enemyCounter];
        }



        continueButton.setEnabled(true);
        attackButton.setEnabled(false);
        potionButton.setEnabled(false);
    }

    public void displayStory(){
        //TODO KAT
    }

    public void playerAttacks(){
        int playerRoll = player.roll(1,20);


        if(player.getHealth() <=0){
            player.setHealth(0);
            storyTxt.setText("Game Over!!");
            attackButton.setEnabled(false);
            continueButton.setEnabled(false);
            potionButton.setEnabled(false);
        }

        if (playerRoll<8){
            storyTxt.setText("You missed!!");
        } else if (playerRoll <= 19){
            enemy.setHealth(enemy.getHealth() - player.getAttackPower());
            storyTxt.setText("You hit the " + enemy.getClass().getSimpleName() + " for " + player.getAttackPower() + " damage!");
        } else {
            enemy.setHealth(enemy.getHealth() - player.getAttackPower()*2);
            storyTxt.setText("Critical hit! You do  " + player.getAttackPower()*2 +" damage to the " + enemy.getClass().getSimpleName());
        }

    }
    public void enemyAttacks(){
        int enemyRoll = enemy.roll(1,20);


        if(enemy.getHealth() <= 0){
            enemyDeath();
        }else if(enemyRoll>10){
            if(enemy.rng.nextInt(100)<player.getBlockChance()){
                player.setHealth((player.getHealth() - enemy.getAttackPower()/2));
                storyTxt.append("\n\n You blocked and take " + enemy.getAttackPower()/2 + " damage.");
            } else {
                player.setHealth(player.getHealth() - enemy.getAttackPower());
                storyTxt.append("\n\nThe " + enemy.getClass().getSimpleName() + " hits you for " + enemy.getAttackPower() + " damage!");
            }
        } else {
            storyTxt.append("\n\nYou dodged the attack!");
        }

    }
}
