package com.example.listmoviepopular.ui.moviesList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.listmoviepopular.R;
import com.example.listmoviepopular.data.model.Movie;
import com.example.listmoviepopular.ui.movieDetail.DetailsMovieActivity;

import java.util.List;

public class ListMovieActivity extends AppCompatActivity implements MoviesListContract.MoviesListView,
        ListenerClickIten{

    private MoviesListAdapter moviesAdapter;
    private MoviesListContract.MoviePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        settingToolbar();

        settingAdapter();

        presenter = new MoviePresenter(this);
        presenter.getMovies();

    }

    private void settingToolbar() {
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }

    private void settingAdapter() {
        final RecyclerView recyclerMovies = findViewById(R.id.recycler_movie);

        moviesAdapter = new MoviesListAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerMovies.setLayoutManager(gridLayoutManager);
        recyclerMovies.setAdapter(moviesAdapter);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        moviesAdapter.setMovies(movies);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroyView();
    }

    @Override
    public void OnClickedIten(Movie movie) {
        Intent intent = new Intent(this, DetailsMovieActivity.class);
        intent.putExtra(DetailsMovieActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }
}