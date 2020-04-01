package com.example.listmoviepopular.ui.moviesList;

import com.example.listmoviepopular.data.network.ApiService;
import com.example.listmoviepopular.data.model.Movie;
import com.example.listmoviepopular.data.mapper.MovieMapper;
import com.example.listmoviepopular.data.network.MoviesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter   implements MoviesListContract.MoviePresenter {
    private MoviesListContract.MoviesListView view;

    public MoviePresenter(MoviesListContract.MoviesListView view) {
        this.view = view;
    }

    @Override
    public void getMovies() {
        ApiService.getInstance().
                getPopularMovies("a105014be69573dd9641d8f95b7b78a7")
                .enqueue(new Callback<MoviesResult>() {

                    @Override
                    public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                        if (response.isSuccessful()) {
                            final List<Movie> moviesList = MovieMapper
                                    .responseDomain(response.body().getResults());

                            view.showMovies(moviesList);
                        } else {
                            view.showError();
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesResult> call, Throwable t) {
                        view.showError();
                    }
                });
    }

    @Override
    public void destroyView() {
        this.view = null;
    }

}