package com.example.trialexercise;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IStarWarsApi {

    @GET("films/{id}")
    Call<Film> getFilmInfo(@Path("id") int id);

}
