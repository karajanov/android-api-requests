package com.example.trialexercise;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static final String starWarsApiUrl = "https://swapi.co/";

    public static Retrofit getBuilder(){

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(starWarsApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return builder;
    }

    public static IStarWarsApi getApiReference(Retrofit builder){

        if(builder == null)
            return null;

        return builder.create(IStarWarsApi.class);
    }

}
