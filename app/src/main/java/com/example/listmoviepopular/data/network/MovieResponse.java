package com.example.listmoviepopular.data.network;

public class MovieResponse {

    private final String posterPath;

    private final String originalTitle;

    private final String overview;

    private final Number voteAverage;


    public MovieResponse(String posterPath, String originalTitle, String overview, Number voteAverage) {
        this.posterPath = posterPath;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.voteAverage = voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Number getVoteAverage() {
        return voteAverage;
    }
}