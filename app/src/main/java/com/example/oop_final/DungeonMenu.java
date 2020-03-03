package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DungeonMenu extends AppCompatActivity {
    public Bundle bundles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_menu);
        bundles = getIntent().getExtras();
    }
}
