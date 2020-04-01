package com.example.listmoviepopular.data.network;

import com.example.listmoviepopular.data.network.MoviesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {

        @GET("movie/popular")
        Call<MoviesResult> getPopularMovies(@Query("api_key") String apiKey);

}