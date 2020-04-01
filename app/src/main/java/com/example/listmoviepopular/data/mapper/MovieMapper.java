package com.example.listmoviepopular.data.mapper;

import com.example.listmoviepopular.data.model.Movie;
import com.example.listmoviepopular.data.network.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {
    public static List<Movie> responseDomain(List<MovieResponse> moviesListResponses) {
        List<Movie> moviesList = new ArrayList<>();

        for (MovieResponse movieResponse : moviesListResponses) {
            final Movie movie = new Movie(movieResponse.getOriginalTitle(), movieResponse.getPosterPath(),
                    movieResponse.getOverview(), movieResponse.getVoteAverage());
            moviesList.add(movie);
        }

        return moviesList;
    }
}