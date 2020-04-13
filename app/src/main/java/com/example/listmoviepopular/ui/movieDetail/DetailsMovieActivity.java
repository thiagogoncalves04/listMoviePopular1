package com.example.listmoviepopular.ui.movieDetail;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.listmoviepopular.R;
import com.example.listmoviepopular.data.model.Movie;
import com.example.listmoviepopular.ui.moviesList.ListMovieActivity;
import com.squareup.picasso.Picasso;

public class DetailsMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "EXTRA_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        Button buttonBack = findViewById(R.id.button_return);
        ImageView imageDetailMovie = findViewById(R.id.image_poster_detail);
        TextView textTitleMovie = findViewById(R.id.text_title_movie);
        TextView textOverview = findViewById(R.id.text_overview);
        TextView textVoteAverage = findViewById(R.id.text_vote_average);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnMovieListView();
            }
        });

        final Movie movie = (Movie) getIntent().getParcelableExtra(EXTRA_MOVIE);
        textTitleMovie.setText(movie.getOriginalTitle());
        textOverview.setText(movie.getOverview());
        textVoteAverage.setText(movie.getVoteAverage().toString());
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w342/" + movie.getPosterPath())
                .into(imageDetailMovie);
    }

    private void returnMovieListView() {
        Intent intent = new Intent(this, ListMovieActivity.class);
        startActivity(intent);
        finish();
    }
}