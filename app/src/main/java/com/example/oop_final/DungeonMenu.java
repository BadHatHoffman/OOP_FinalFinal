package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
    //Class accessible variables
    public Bundle bundles;
    private boolean wolfPlayer, elfPlayer, humanPlayer;
    private GifImageView elfImg, humanImg, wolfImg, dragon, troll, ogre, orc, gnome;
    private TextView enemyHealth, characterStats, storyTxt, levelUp;
    private Button attackButton, continueButton, potionButton;
    private int storyPlace = 0;
    private int potions = 3;
    Hero player;
    Enemy enemy;
    public Bundle bundle = new Bundle();



    @Override
    //Sets the screen to the dungeon menu
    protected void onCreate(Bundle savedInstanceState) {
        MediaPlayer musica= MediaPlayer.create(DungeonMenu.this,R.raw.dungeon_music);
        musica.setLooping(true);
        musica.start();
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);


        //Find all of the components
        setContentView(R.layout.activity_dungeon_menu);
        dragon = findViewById(R.id.dragon);
        orc = findViewById(R.id.orc);
        ogre = findViewById(R.id.ogre);
        troll = findViewById(R.id.troll);
        gnome = findViewById(R.id.gnome);
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
        levelUp = findViewById(R.id.levelUp);
        continueButton.setEnabled(false);
        dragon.setVisibility(View.INVISIBLE);
        orc.setVisibility(View.INVISIBLE);
        ogre.setVisibility(View.INVISIBLE);
        troll.setVisibility(View.INVISIBLE);
        gnome.setVisibility(View.INVISIBLE);

        //Sets the dungeon player to the selected one from character select menu
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
        displayStory();
    }

    //Players attack method/enemy death check
    public void onClick_Attack(View v){
        playerAttacks();
        enemyHealth.setText(enemy.toString());
        if(enemy.getHealth() <= 0) {
            enemyDeath();
        }else {
            enemyAttacks();
        }
        characterStats.setText(player.toString());
    }


    //Sets potions/makes potions usable
    public void onClick_Potion(View v){
        //TODO Kayla
        potions--; //Subtracts potions when button clicked
        potionButton.setText("Potion  : " + potions);
        //Enables/disable button
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


    //Allows the user to progress past the story to the next fight
    public void onClick_Continue(View v) {
        //TODO Ethan
        attackButton.setEnabled(true);
        potionButton.setEnabled(true);
        continueButton.setEnabled(false);
        continueButton.setVisibility(View.INVISIBLE);
        storyTxt.setText("");
        attackButton.setVisibility(View.VISIBLE);
        potionButton.setVisibility(View.VISIBLE);
        enemyHealth.setVisibility(View.VISIBLE);
        if (enemy == null) {
            enemy = new Gnome();
            gnome.setVisibility(View.VISIBLE);
            enemyHealth.setText(enemy.toString());
            enemyHealth.setVisibility(View.VISIBLE);
        } else if (enemy instanceof Gnome) {
            enemy = new Troll();
            troll.setVisibility(View.VISIBLE);
            enemyHealth.setText(enemy.toString());
            enemyHealth.setVisibility(View.VISIBLE);
        } else if (enemy instanceof Troll){
            enemy = new Ogre();
            ogre.setVisibility(View.VISIBLE);
            enemyHealth.setText(enemy.toString());
            enemyHealth.setVisibility(View.VISIBLE);
        }else if(enemy instanceof Ogre){
            enemy = new Orc();
            orc.setVisibility(View.VISIBLE);
            enemyHealth.setText(enemy.toString());
            enemyHealth.setVisibility(View.VISIBLE);
        }else if(enemy instanceof Orc){
            enemy = new Dragon();
            dragon.setVisibility(View.VISIBLE);
            enemyHealth.setText(enemy.toString());
            enemyHealth.setVisibility(View.VISIBLE);
        }
        levelUp.setText("");

    }


    //Checks whether the exp = 100 and levels up the player
    public void checkLevelUP() {
        //TODO Kayla
        if(player.getExp()>=100){
            player.setExp(player.getExp()-100);
            player.levelUp();
            levelUp.setText("Level Up! New Stats and full health!\n");
        }
    }

    //Checks if the players health hits 0 and displays game over to them
    public void playerDeath(){
        player.setHealth(0);
        storyTxt.setText("Game Over!!");
        attackButton.setEnabled(false);
        continueButton.setEnabled(false);
        potionButton.setEnabled(false);
        attackButton.setVisibility(View.INVISIBLE);
        potionButton.setVisibility(View.INVISIBLE);
        continueButton.setVisibility(View.INVISIBLE);
    }


    //Checks if the enemies health hits 0, then distributes exp
    public void enemyDeath(){
        //TODO KAT
            player.setExp(player.getExp() + enemy.getExperienceWorth());
            checkLevelUP();
            storyTxt.setText("");
            storyPlace++;
            displayStory();
    }

    //Displays the story to the player
    public void displayStory(){
        switch(storyPlace){
            case 0:
                setStoryVisibility();
                storyTxt.setText("You wish to capture the Dragon who lives in the forest cave and present him as a pet to your lover. You embark on your journey alone, keen " +
                        "to prove your strength. You begin your descent into the cave. About 100 feet into the cave, you encounter an angry Gnome telling you you dont belong, he swings a hammer at you.");
                break;
            case 1:
                setStoryVisibility();
                storyTxt.setText("After defeating the Gnome, you trudge further into the dungeon. As you walk " +
                        "along the cold dark tunnels you bump into the walls and trip over cracks in the ground, you feel yourself bump into " +
                        "something warm. You feel drool drip onto your shoulder, the smell is awful. You light a torch and see none other than a Troll!");
                //gnome
                break;
            case 2:
                setStoryVisibility();
                storyTxt.setText("You've escaped the Troll! As you continue down the dark tunnels of the cave you realize its " +
                        "beginning to get lighter. You stumble upon a medium sized opening, its circular in shape. In the " +
                        "middle is a camp, a single Ogre is cooking the group dinner. He spots you and decides you're to be the next meal.");

                //troll
                break;
            case 3:
                setStoryVisibility();
                storyTxt.setText("You defeat the Ogre, you quickly realize you need to leave " +
                        "the area before their friends come back. The tunnel you run into gets progressively tighter to move through then suddenly it becomes " +
                        "an underground ravine. You work your way down the twisting rocks, at the bottom you find a large" +
                        " green creature blocking your path. As you approach you realize its a sleeping Orc, it awakes angry and startled and attacks you!");
                //ogre
                break;
            case 4:
                setStoryVisibility();
                storyTxt.setText("Once you've defeated the Orc you follow a path of small pieces of gold. " +
                        "you must be on the right path to the Dragon. You continue on " +
                        "your path anxious and alert. You can see the opening leading into a brightly lit " +
                        "treasure room, upon the pile of gold lays a dragon. As you approach he awakens waiting for you angrily. ");
                //orc
                break;
            case 5:
                setStoryVisibility();
                storyTxt.setText("You have defeated the Dragon! Beaten, the Dragon allows you to claim him if he can continue to " +
                        "live in his cave. He will grant you and your lover passage to see him whenever you please. He reminds you however he will eventually seek freedom and he will" +
                        " not underestimate you again, he will use more than 30% of his power next time. ");
                continueButton.setVisibility(View.INVISIBLE);
                continueButton.setEnabled(false);
                //dragon
                break;
        }
    }


    //Sets the visibility of buttons and enemies for the story to display
    public void setStoryVisibility(){
        enemyHealth.setVisibility(View.INVISIBLE);
        attackButton.setVisibility(View.INVISIBLE);
        potionButton.setVisibility(View.INVISIBLE);
        continueButton.setVisibility(View.VISIBLE);
        continueButton.setEnabled(true);
        attackButton.setEnabled(false);
        potionButton.setEnabled(false);
        dragon.setVisibility(View.INVISIBLE);
        orc.setVisibility(View.INVISIBLE);
        ogre.setVisibility(View.INVISIBLE);
        troll.setVisibility(View.INVISIBLE);
        gnome.setVisibility(View.INVISIBLE);
    }

    //Rolls a die for the players damage
    public void playerAttacks(){
        int playerRoll = player.roll(1,20);

            if (playerRoll < 8) {
                storyTxt.setText("You missed!!");
            } else if (playerRoll <= 19) {
                enemy.setHealth(enemy.getHealth() - player.getAttackPower());
                storyTxt.setText("You hit the " + enemy.getClass().getSimpleName() + " for " + player.getAttackPower() + " damage!");
            } else {
                enemy.setHealth(enemy.getHealth() - player.getAttackPower() * 2);
                storyTxt.setText("Critical hit! You do  " + player.getAttackPower() * 2 + " damage to the " + enemy.getClass().getSimpleName());
            }

    }

    //Rolls the enemies die for attack damage
    public void enemyAttacks(){
        int enemyRoll = enemy.roll(1,20);

        if(player.getHealth() <=0){
            playerDeath();
        }else {
            if (enemyRoll > 10) {
                if (enemy.rng.nextInt(100) < player.getBlockChance()) {
                    player.setHealth((player.getHealth() - enemy.getAttackPower() / 2));
                    storyTxt.append("\n\n You blocked and take " + enemy.getAttackPower() / 2 + " damage.");
                } else {
                    player.setHealth(player.getHealth() - enemy.getAttackPower());
                    storyTxt.append("\n\nThe " + enemy.getClass().getSimpleName() + " hits you for " + enemy.getAttackPower() + " damage!");
                }
            } else {
                storyTxt.append("\n\nYou dodged the attack!");
            }
        }
    }
}
