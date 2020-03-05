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

    public void onAttack(View v){

    }

    public void onDefense(View v){

    }
}
