package com.example.trialexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;
    private boolean isDark = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.item_dark_mode:
                changeBackgroundColor();
                return true;

            case R.id.item_random_film:
                //
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeBackgroundColor(){

        if(isDark) {

            mainLayout.setBackgroundColor(Color.WHITE);
            isDark = false;

        }else {

            mainLayout.setBackgroundColor(Color.GRAY);
            isDark = true;
        }

    }
}
