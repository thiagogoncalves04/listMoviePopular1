package com.example.listmoviepopular.ui.moviesList;

import com.example.listmoviepopular.data.model.Movie;

import java.util.List;

public interface MoviesListContract {

    interface MoviesListView {
        void showMovies(List<Movie> movies);

        void showError();
    }

    interface MoviePresenter {
        void getMovies();

        void destroyView();
    }
}