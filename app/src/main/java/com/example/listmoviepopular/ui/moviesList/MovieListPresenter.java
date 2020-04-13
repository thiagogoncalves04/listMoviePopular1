package com.example.listmoviepopular.ui.moviesList;
import com.example.listmoviepopular.data.mapper.MovieMapper;
import com.example.listmoviepopular.data.model.Movie;
import com.example.listmoviepopular.data.network.ApiService;
import com.example.listmoviepopular.data.network.MoviesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieListPresenter implements MoviesListContract.MoviePresenter {
    private MoviesListContract.MoviesListView view;
    private int actualPage = 1;
    private boolean isLoading = false;

    public MovieListPresenter(MoviesListContract.MoviesListView view) {
        this.view = view;
    }

    @Override
    public void getMovies() {
        if (isLoading && !isLastPage()) {
            return; }
        isLoading = true;
        ApiService.getInstance()
                    .getPopularMovies("a105014be69573dd9641d8f95b7b78a7", actualPage)
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
                            isLoading = false;
                            actualPage++;
                        }

                        @Override
                        public void onFailure(Call<MoviesResult> call, Throwable t) {
                            view.showError();
                            isLoading = false;
                        }
                    });
    }

    @Override
    public void destroyView() {
        view = null;
    }

    public boolean isLastPage(){
        return actualPage == 1000;
    }
}