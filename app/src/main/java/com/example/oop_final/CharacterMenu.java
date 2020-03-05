package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

public class CharacterMenu extends AppCompatActivity {
    public Bundle bundles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_menu);
        bundles = getIntent().getExtras();
    }
}
