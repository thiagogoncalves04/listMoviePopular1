package com.example.listmoviepopular.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("original_title")
    private final String originalTitle;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("overview")
    private final String overview;
    @SerializedName("vote_average")
    private final Number voteAverage;

    public Movie(String title, String posterPath, String overview, Number voteAverage) {
        this.originalTitle = title;
        this.posterPath = posterPath;
        this.overview = overview;
        this.voteAverage = voteAverage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public Number getVoteAverage() {
        return voteAverage;
    }
}