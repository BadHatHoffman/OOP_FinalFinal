package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import models.Wolf;

public class CharacterMenu extends AppCompatActivity {
    public Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_menu);
    }


    public void wolfClick(View v){
        bundle.putBoolean("WOLF", true);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void elfClick(View v){
        bundle.putBoolean("ELF",  true);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);


    }

    public void humanClick(View v){
        bundle.putBoolean("HUMAN",  true);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
