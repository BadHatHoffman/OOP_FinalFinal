package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import models.Elf;
import models.Human;
import models.Wolf;
import pl.droidsonroids.gif.GifImageView;

public class CharacterMenu extends AppCompatActivity {
    public Bundle bundle = new Bundle();
    private boolean wolfValue = false;
    private boolean elfValue = false;
    private boolean humanValue = false;
    private TextView wolfTxt, elfTxt, humanTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_menu);
        wolfTxt = findViewById(R.id.wolfTxt);
        elfTxt = findViewById(R.id.elfTxt);
        humanTxt = findViewById(R.id.humanTxt);
        wolfTxt.setText(new Wolf().toString());
        elfTxt.setText(new Elf().toString());
        humanTxt.setText(new Human().toString());
    }


    public void wolfClick(View v){
        wolfValue = true;
        bundle.putBoolean("WOLF", wolfValue);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void elfClick(View v){
        elfValue = true;
        bundle.putBoolean("ELF",  elfValue);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void humanClick(View v){
        humanValue = true;
        bundle.putBoolean("HUMAN",  humanValue);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
