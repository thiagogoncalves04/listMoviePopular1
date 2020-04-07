package com.example.listmoviepopular.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static MoviesService INSTANCE;
    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static MoviesService getInstance() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(MoviesService.class);
        }

        return INSTANCE;
    }
}