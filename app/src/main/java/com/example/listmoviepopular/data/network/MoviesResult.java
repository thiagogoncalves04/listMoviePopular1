package com.example.listmoviepopular.data.network;

import com.example.listmoviepopular.data.network.MovieResponse;

import java.util.List;

public class MoviesResult {

    private final List<MovieResponse> results;

    public MoviesResult(List<MovieResponse> results) {
        this.results = results;
    }

    public List<MovieResponse> getResults() {
        return results;
    }
}