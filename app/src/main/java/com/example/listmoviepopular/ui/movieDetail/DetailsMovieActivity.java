package com.example.listmoviepopular.ui.movieDetail;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listmoviepopular.R;
import com.example.listmoviepopular.data.model.Movie;
import com.squareup.picasso.Picasso;

public class DetailsMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "EXTRA_MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        ImageView imageDetailMovie = findViewById(R.id.image_poster_detail);
        TextView textTitleMovie = findViewById(R.id.text_title_movie);
        TextView textOverview= findViewById(R.id.text_overview);
        TextView textVoteAverage = findViewById(R.id.text_vote_average);

        final Movie movie = (Movie) getIntent().getParcelableExtra(EXTRA_MOVIE);
        textTitleMovie.setText(movie.getOriginalTitle());
        textOverview.setText(movie.getOverview());
        textVoteAverage.setText(movie.getVoteAverage().toString());
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w342/" + movie.getPosterPath())
                .into(imageDetailMovie);
    }
}
