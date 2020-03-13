package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    public Bundle bundle = new Bundle();
    @Override

    //Sets the opening screens music as well as bundles all the information for screen change
    protected void onCreate(Bundle savedInstanceState) {
        //Music
        MediaPlayer musica= MediaPlayer.create(MainActivity.this,R.raw.opening_music);
        musica.setLooping(true);
        musica.start();
        //Bundle
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Sets Activity to Character selection screen
    public void beginClick(View v){
        //Bundling for change
        Intent intent = new Intent(this, CharacterMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
