package com.example.trialexercise;

import com.google.gson.annotations.SerializedName;

public class Film {

    private String title;

    @SerializedName("episode_id")
    private int episodeId;

    private String director;

    private String producer;

    @SerializedName("release_date")
    private String releaseDate;

    public String getTitle() {
        return title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
