package com.example.trialexercise;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IStarWarsApi {

    @GET("films")
    Call<FilmCounter> getFilmCount();

}
