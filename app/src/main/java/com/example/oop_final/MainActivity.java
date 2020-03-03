package com.example.oop_final;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.app.Activity;
=======
import android.content.Intent;
>>>>>>> c1e5ec6b9709f31f387bf8e34f71fa45a75ee593
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    public Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

<<<<<<< HEAD
    public void openingScreen() {

=======
    public void beginClick(View v){
        Intent intent = new Intent(this, CharacterMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
>>>>>>> c1e5ec6b9709f31f387bf8e34f71fa45a75ee593
    }


}
