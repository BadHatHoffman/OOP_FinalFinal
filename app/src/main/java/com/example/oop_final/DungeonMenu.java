package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class DungeonMenu extends AppCompatActivity {
    public Bundle bundles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_menu);
        bundles = getIntent().getExtras();

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
