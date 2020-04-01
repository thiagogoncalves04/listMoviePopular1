package com.example.listmoviepopular.ui.moviesList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listmoviepopular.R;
import com.example.listmoviepopular.data.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesListAdapter  extends RecyclerView.Adapter<MoviesListAdapter.MovieListViewHolder> {

    private List<Movie> movies;
    private static ListenerClickIten listener;

    public MoviesListAdapter(ListenerClickIten listener){
        this.listener = listener;
        movies = new ArrayList<>();

    }

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);

        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder movieListViewHolder, int i) {
        movieListViewHolder.bind(movies.get(i));


    }

    @Override
    public int getItemCount() {
        return (movies != null && movies.size() > 0) ? movies.size(): 0;
    }

    static class MovieListViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitleFilm;
        private ImageView imagePost;
        private Movie movie;

        public MovieListViewHolder(View itemView){
            super(itemView);

            textTitleFilm = itemView.findViewById(R.id.text_title_movie);
            imagePost = itemView.findViewById(R.id.image_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null ){
                        listener.OnClickedIten(movie);
                    }
                }
            });

        }

        public void bind(Movie movie){
            this.movie = movie;

            textTitleFilm.setText(movie.getOriginalTitle());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w342/" + movie.getPosterPath())
                    .into(imagePost);
        }
    }

    public void setMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }
}
