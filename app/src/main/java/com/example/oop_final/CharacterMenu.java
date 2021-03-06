package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import models.Elf;
import models.Human;
import models.Wolf;
import pl.droidsonroids.gif.GifImageView;

public class CharacterMenu extends AppCompatActivity {

    //Class wide variables
    public Bundle bundle = new Bundle();
    private boolean wolfValue = false;
    private boolean elfValue = false;
    private boolean humanValue = false;
    private TextView wolfTxt, elfTxt, humanTxt;
    @Override

    //Sets the Activity to
    protected void onCreate(Bundle savedInstanceState) {
        MediaPlayer musica= MediaPlayer.create(CharacterMenu.this,R.raw.character_music);
        musica.setLooping(true);
        musica.start();
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

    //Sets the wolf image by setting wolf to true
    public void wolfClick(View v){
        wolfValue = true;
        bundle.putBoolean("WOLF", wolfValue);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //Sets the elf image by setting wolf to true
    public void elfClick(View v){
        elfValue = true;
        bundle.putBoolean("ELF",  elfValue);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //Sets the human image by setting wolf to true
    public void humanClick(View v){
        humanValue = true;
        bundle.putBoolean("HUMAN",  humanValue);
        Intent intent = new Intent(this, DungeonMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
