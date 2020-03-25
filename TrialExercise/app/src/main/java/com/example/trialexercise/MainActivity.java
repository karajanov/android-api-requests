package com.example.trialexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IStarWarsApi apiReference = RetrofitBuilder.getApiReference(RetrofitBuilder.getBuilder());

    final int filmCount = 7;

    ConstraintLayout mainLayout;
    TextView textViewFilmInfo;
    ProgressBar loadingBar;
    boolean isDark = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization
        mainLayout = findViewById(R.id.main_layout);
        textViewFilmInfo = findViewById(R.id.textview_film_info);
        loadingBar = findViewById(R.id.progress_bar);

        loadingBar.setVisibility(View.GONE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_dark_mode:
                changeBackgroundColor();
                return true;

            case R.id.item_random_film:
                int filmId = getRandomNum(1, filmCount + 1);
                setFilmInfo(filmId);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeBackgroundColor() {

        if (isDark) {

            mainLayout.setBackgroundColor(Color.WHITE);
            isDark = false;

        } else {

            mainLayout.setBackgroundColor(Color.GRAY);
            isDark = true;
        }
    }

    private int getRandomNum(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }

    private void setFilmInfo(int id) {

        Call<Film> call = apiReference.getFilmInfo(id);
        loadingBar.setVisibility(View.VISIBLE);

        call.enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {

                // HTTP 4**
                if (!response.isSuccessful()) {

                    textViewFilmInfo.setText("Invalid request");
                    Log.e(this.getClass().getSimpleName(), String.valueOf(response.code()));

                } else {

                    String filmInfo = "Title: " + response.body().getTitle() +
                            "\nDirector: " + response.body().getDirector() +
                            "\nRelease Date: " + response.body().getReleaseDate() +
                            "\nProducer: " + response.body().getProducer() +
                            "\nEpisode: " + response.body().getEpisodeId();

                    textViewFilmInfo.setText(filmInfo);
                }

                loadingBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

                textViewFilmInfo.setText("Request failed");
                Log.e(this.getClass().getSimpleName(), t.getMessage());

                loadingBar.setVisibility(View.GONE);
            }
        });
    }
}
